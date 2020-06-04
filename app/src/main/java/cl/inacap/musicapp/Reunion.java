package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Reunion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reunion);
    }

    public void onCLick(View view){
        Intent cambio = new Intent(Reunion.this, Seleccion.class);
        startActivity(cambio);
    }

    public void Siguiente(View view){
        Intent cambio = new Intent(Reunion.this, Seleccion.class);
        startActivity(cambio);
    }
}