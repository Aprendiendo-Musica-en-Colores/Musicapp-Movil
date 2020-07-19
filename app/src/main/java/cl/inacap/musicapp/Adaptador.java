package cl.inacap.musicapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class Adaptador extends BaseAdapter implements Response.Listener<JSONObject>,Response.ErrorListener{

    private static LayoutInflater inflater;
    Context contexto;
    String[][] datos;
    RequestQueue rQueue;
    ProgressDialog progreso;
    JsonObjectRequest jsonObjectRequest;

    public Adaptador(Context conexto, String[][] datos)
    {
        this.contexto = conexto;
        this.datos = datos;
        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {


        final View vista = inflater.inflate(R.layout.list_historial, null);

        TextView titulo = (TextView) vista.findViewById(R.id.tvInstrumento);
        TextView fecha = (TextView) vista.findViewById(R.id.tvDificultad);
        RatingBar calificacion = (RatingBar) vista.findViewById(R.id.ratingBarPel);

        titulo.setText(datos[i][0]);
        fecha.setText(datos[i][1]);
        calificacion.setProgress(Integer.valueOf(datos[i][2]));

        return vista;
    }

    @Override
    public int getCount() {
        return datos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }

}
