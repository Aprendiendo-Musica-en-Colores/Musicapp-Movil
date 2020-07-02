package cl.inacap.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater;
    Context contexto;
    String[][] datos;

    public Adaptador(Context conexto, String[][] datos)
    {
        this.contexto = conexto;
        this.datos = datos;
        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {


        final View vista = inflater.inflate(R.layout.list_historial, null);

        TextView titulo = (TextView) vista.findViewById(R.id.tvTituloCancion);
        TextView duracion = (TextView) vista.findViewById(R.id.tvDuracion);
        TextView fecha = (TextView) vista.findViewById(R.id.tvFecha);
        RatingBar calificacion = (RatingBar) vista.findViewById(R.id.ratingBarPel);

        titulo.setText(datos[i][0]);
        fecha.setText(datos[i][1]);
        duracion.setText("Duración " + datos[i][2]);
        calificacion.setProgress(Integer.valueOf(datos[i][3]));

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

}
