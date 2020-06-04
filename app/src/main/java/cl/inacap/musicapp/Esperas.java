package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Esperas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esperas);
    }

    public void onCLick(View view){
        Intent cambio = new Intent(Esperas.this, Seleccion.class);
        startActivity(cambio);
    }
}