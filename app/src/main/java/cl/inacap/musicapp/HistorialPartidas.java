package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

public class HistorialPartidas extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    ListView listaPartidas;
    TextView txtNomPersona;
    TextView txtRut;

    String[][] datos = {
            {"Las Manitos", "01/07/2020", "2:49", "9"},
            {"La Rana Sentada", "30/06/2020", "2:17", "7"},
            {"La Cuncuna", "30/04/2020", "2:01", "8"},
            {"Un elefante se balanceaba", "05/04/2020", "2:12", "7"},
            {"El pollito", "08/03/2020", "1:48", "9"},
            {"Los cochinitos", "20/20/2020", "1:56", "8"}
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
}