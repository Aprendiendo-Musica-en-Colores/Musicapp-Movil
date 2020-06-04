package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ingresar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
    }

    public void onCLick(View view){
        Intent cambio = new Intent(Ingresar.this, Esperas.class);
        startActivity(cambio);
    }
}