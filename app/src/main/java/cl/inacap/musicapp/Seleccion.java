package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Seleccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
    }

    public void onCLick(View view){
        Intent cambio = new Intent(Seleccion.this, Piano.class);
        startActivity(cambio);
    }

}