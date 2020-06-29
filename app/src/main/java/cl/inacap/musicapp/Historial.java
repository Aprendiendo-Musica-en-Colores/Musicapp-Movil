package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Historial extends AppCompatActivity {
    ListView listaHistorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        listaHistorial = (ListView) findViewById(R.id.Listhistorial);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.historial,android.R.layout.simple_list_item_1);
        listaHistorial.setAdapter(adaptador);
    }
}