package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

public class crudUsuarios extends AppCompatActivity {

    FloatingActionButton fbtnMenu,fbtnAgregar,fbtnEliminar,fbtnModificar;
    EditText etRut,etNombre,etApePat,etApeMat,etDirec,etMail,etFecNac,etUsu,etPass;
    private TextView txtAgregar,txtEliminar,txtModificar;
    private Spinner etTipoUsu;
    private boolean isOpen;
    private Animation btnOpenAnim,btnCloseAnim;
    private RequestQueue datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_usuarios);

        btnOpenAnim = AnimationUtils.loadAnimation(crudUsuarios.this,R.anim.fab_open);
        btnCloseAnim = AnimationUtils.loadAnimation(crudUsuarios.this,R.anim.fab_close);

        fbtnMenu = findViewById(R.id.fbtnMenu);
        fbtnAgregar = findViewById(R.id.fbtnAgregar);
        fbtnEliminar = findViewById(R.id.fbtnEliminar);
        fbtnModificar = findViewById(R.id.fbtnModificar);
        txtAgregar = findViewById(R.id.txtBtnAgregar);
        txtEliminar = findViewById(R.id.txtBtnEliminar);
        txtModificar = findViewById(R.id.txtBtnModificar);

        etRut = (EditText) findViewById(R.id.idRut);
        etNombre = (EditText) findViewById(R.id.idNom);
        etApePat =(EditText) findViewById(R.id.idApePat);
        etApeMat =(EditText) findViewById(R.id.idApeMat);
        etDirec =(EditText) findViewById(R.id.idDireccion);
        etMail =(EditText) findViewById(R.id.idMail);
        etFecNac =(EditText) findViewById(R.id.idFecNac);
        etUsu =(EditText) findViewById(R.id.idUsu);
        etPass =(EditText) findViewById(R.id.idPass);
        etTipoUsu =(Spinner) findViewById(R.id.idTipoUsu);

        datos= Volley.newRequestQueue(this);

        String[] operaciones = {"Seleccionar Opción","Administrador","Profesor","Usuario"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item, operaciones);
        etTipoUsu.setAdapter(adapter);

        isOpen = false;
        fbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){
                    fbtnAgregar.setAnimation(btnCloseAnim);
                    fbtnModificar.setAnimation(btnCloseAnim);
                    fbtnEliminar.setAnimation(btnCloseAnim);
                    txtAgregar.setVisibility(View.INVISIBLE);
                    txtEliminar.setVisibility(View.INVISIBLE);
                    txtModificar.setVisibility(View.INVISIBLE);
                    isOpen= false;
                }else{
                    fbtnAgregar.setAnimation(btnOpenAnim);
                    fbtnModificar.setAnimation(btnOpenAnim);
                    fbtnEliminar.setAnimation(btnOpenAnim);
                    txtAgregar.setVisibility(View.VISIBLE);
                    txtEliminar.setVisibility(View.VISIBLE);
                    txtModificar.setVisibility(View.VISIBLE);
                    isOpen=true;
                }
            }
        });
    }

    private void cargarWS(){
        String url = "localhost/ConexionBD/registro.php?Run="+ etRut.getText().toString() + "&Nombre=" + etNombre.getText().toString() + "&ApPaterno=" + etApePat.getText().toString() +
                "&ApMaterno=" + etApeMat.getText().toString() + "&Direccion=" + etDirec.getText().toString() + "&Email="+ etMail.getText().toString() +
                "&Nacimiento=" + etFecNac.getText().toString() + "&user=" + etUsu.getText().toString() + "&pass=" + etPass.getText().toString() + " &Perfil=" + etTipoUsu.getSelectedItem().toString();

        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    etRut.setText(response.getString("Run"));
                    etNombre.setText(response.getString("Nombre"));
                    etApePat.setText(response.getString("ApePat"));
                    etApeMat.setText(response.getString("ApeMat"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        datos.add(request);
    }

    /*
    public void ObtenerDatos(){
        String URL="";
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    etRut.setText(response.getString("Run"));
                    etNombre.setText(response.getString("Nombre"));
                    etApePat.setText(response.getString("ApePat"));
                    etApeMat.setText(response.getString("ApeMat"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        datos.add(request);
    }*/

}