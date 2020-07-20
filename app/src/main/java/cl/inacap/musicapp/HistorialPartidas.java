package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class HistorialPartidas extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    ListView listaPartidas;
    TextView txtNomPersona;
    TextView txtRut;
    RequestQueue rQueue;
    ProgressDialog progreso;
    JsonObjectRequest jsonObjectRequest;

    String[][] datos = {
            {"Piano", "Dificil", "9"},
            {"Xilófono", "Media", "7"},
            {"Xilófono", "Facil", "8"},
            {"Piano", "Facil", "7"},
            {"Piano", "Media", "9"},
            {"Xiloófono","Dificil", "8"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_partidas);
        listaPartidas = (ListView) findViewById(R.id.ListaPartidas);
        txtNomPersona = (TextView) findViewById(R.id.nomUsuario);
        txtRut = (TextView) findViewById(R.id.rutUsuario);
        String nom = getIntent().getStringExtra("Nombre");
        String rut = getIntent().getStringExtra("Rut");
        txtRut.setText(rut);
        txtNomPersona.setText(nom);
        listaPartidas.setAdapter(new Adaptador(this,datos));
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }

    public void buscarHistorial(){
        progreso= new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();
        String url = "http://192.168.56.1/conexion/Conexion de PHP/consultaLogin.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,this,this );
        rQueue.add(jsonObjectRequest);
    }
}