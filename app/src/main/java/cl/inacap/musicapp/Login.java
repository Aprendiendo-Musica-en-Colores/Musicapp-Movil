package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    private EditText etUsuario;
    private EditText etPassword;
    private Button btnLogin;
    RequestQueue request;
    ProgressDialog progreso;
    Intent cambio;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btn_ingresar);
        request = Volley.newRequestQueue(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarWS();
            }
        });
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(this,"Error al validar el usuario "+error.toString(),Toast.LENGTH_LONG).show();
        Log.i("ERROR",error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        progreso.hide();

        Usuario user = new Usuario();
        JSONArray json = response.optJSONArray("usuario");
        JSONObject jsonObject=null;
        try{
            jsonObject = json.getJSONObject(0);
            user.setUsername(jsonObject.optString("username"));
            user.setPass(jsonObject.optString("pass"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        if (etUsuario.getText().toString().equals(user.getUsername()) || etPassword.getText().toString().equals(user.getPass()))
        {
            cambio = new Intent(Login.this, crudUsuarios.class);
            startActivity(cambio);
        }else {
            if (etUsuario.getText().toString().equals("") || etPassword.getText().toString().equals("")){
                cambio = new Intent(Login.this, HistorialPartidas.class);
                startActivity(cambio);
            }
        }
    }

    private void buscarWS(){
        progreso= new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();
        String url = "http://192.168.56.1/conexion/consultaLogin.php?username="+ etUsuario.getText().toString() + "&pass="+ etPassword.getText().toString();
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,this,this );
        request.add(jsonObjectRequest);
    }
}