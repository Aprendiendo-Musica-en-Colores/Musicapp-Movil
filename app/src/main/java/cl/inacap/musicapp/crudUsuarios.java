package cl.inacap.musicapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class crudUsuarios extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    FloatingActionButton fbtnMenu,fbtnAgregar,fbtnEliminar,fbtnModificar;
    EditText etRut,etNombre,etApePat,etApeMat,etDirec,etMail,etFecNac,etUsu,etPass;
    private TextView txtAgregar,txtEliminar,txtModificar;
    private Button btnBuscar;
    private Spinner etTipoUsu;
    private boolean isOpen;
    private Animation btnOpenAnim,btnCloseAnim;
    private RequestQueue datos;
    ProgressDialog progreso;
    StringRequest stringRequest;

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

        btnBuscar= (Button) findViewById(R.id.btnBuscar);
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
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarWS();
            }
        });
        fbtnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresarWS();
            }
        });
        fbtnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarWS();
            }
        });
        fbtnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarWS();
            }
        });
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"Error al realizar la operación "+error.toString(),Toast.LENGTH_LONG).show();
        Log.i("ERROR",error.toString());
        progreso.hide();
    }

    @Override
    public void onResponse(JSONObject response) {

            Toast.makeText(this, "Se ha registrado correctamente", Toast.LENGTH_LONG).show();
            progreso.hide();
            etRut.setText("");
            etNombre.setText("");
            etApePat.setText("");
            etApeMat.setText("");
            etDirec.setText("");
            etMail.setText("");
            etFecNac.setText("");
            etUsu.setText("");
            etPass.setText("");
            etTipoUsu.setSelection(0);

            /* Buscar
            Toast.makeText(this,"Datos encontrados "+response,Toast.LENGTH_LONG).show();
            progreso.hide();
            Usuario user = new Usuario();
            JSONArray json = response.optJSONArray("usuario");
            JSONObject jsonObject=null;
            try{
                jsonObject = json.getJSONObject(0);
                user.setNombre(jsonObject.optString("Nombre"));
                user.setApPaterno(jsonObject.optString("ApPaterno"));
                user.setApMaterno(jsonObject.optString("ApMaterno"));
                user.setDireccion(jsonObject.optString("Direccion"));
                user.setEmail(jsonObject.optString("Email"));
                user.setNacimiento(jsonObject.optString("Nacimiento"));
                user.setUsername(jsonObject.optString("username"));
                user.setPass(jsonObject.optString("pass"));
                user.setPerfil(jsonObject.optString("Perfil"));
            }catch (JSONException e){
                e.printStackTrace();
            }
            etNombre.setText(user.getNombre());
            etApePat.setText(user.getApPaterno());
            etApeMat.setText(user.getApMaterno());
            etDirec.setText(user.getDireccion());
            etMail.setText(user.getEmail());
            etFecNac.setText(user.getNacimiento());
            etUsu.setText(user.getUsername());
            etPass.setText(user.getPass());
            etTipoUsu.setSelection(0);
            */
    }
    private void ingresarWS(){
        progreso= new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();
        String url = "http://192.168.0.5/conexion/insert.php?Run="+ etRut.getText().toString() + "&Nombre=" + etNombre.getText().toString() + "&ApPaterno=" + etApePat.getText().toString() +
                "&ApMaterno=" + etApeMat.getText().toString() + "&Direccion=" + etDirec.getText().toString() + "&Email="+ etMail.getText().toString() +
                "&Nacimiento=" + etFecNac.getText().toString() + "&username=" + etUsu.getText().toString() + "&pass=" + etPass.getText().toString() + " &Perfil=" + etTipoUsu.getSelectedItem().toString();
        url=url.replace(" ","%20");
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null,this,this );
        datos.add(request);
    }
    private void modificarWS(){
        progreso= new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();
        String url = "http://192.168.0.5/conexion/update.php?Run="+ etRut.getText().toString()+"&Nombre=" + etNombre.getText().toString() + "&ApPaterno=" + etApePat.getText().toString() +
                "&ApMaterno=" + etApeMat.getText().toString() + "&Direccion=" + etDirec.getText().toString() + "&Email="+ etMail.getText().toString() +
                "&Nacimiento=" + etFecNac.getText().toString() + "&username=" + etUsu.getText().toString() + "&pass=" + etPass.getText().toString() + " &Perfil=" + etTipoUsu.getSelectedItem().toString();
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progreso.hide();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(this,"No se ha podido conectar",Toast.LENGTH_LONG).show();
                progreso.hide();
            }
        });
        datos.add(stringRequest);
    }
    private void buscarWS(){
        progreso= new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();
        String url = "http://192.168.0.5/conexion/consulta.php?Run="+ etRut.getText().toString();
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null,this,this );
        datos.add(request);
    }
    private void eliminarWS(){
        progreso= new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();
        String url = "http://192.168.0.5/conexion/eliminar.php?Run="+ etRut.getText().toString();
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(this,"Se eliminaron los datos",Toast.LENGTH_LONG).show();
                progreso.hide();
                etRut.setText("");
                etNombre.setText("");
                etApePat.setText("");
                etApeMat.setText("");
                etDirec.setText("");
                etMail.setText("");
                etFecNac.setText("");
                etUsu.setText("");
                etPass.setText("");
                etTipoUsu.setSelection(0);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(this,"No se pudo eliminar el registro",Toast.LENGTH_LONG).show();
            }
        });
        datos.add(stringRequest);
    }
}