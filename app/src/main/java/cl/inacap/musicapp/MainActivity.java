package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCLick(View view){
        Intent cambio = new Intent(MainActivity.this, Login.class);
        startActivity(cambio);
    }

    public void guitarra(View view){
        Intent cambio = new Intent(MainActivity.this, Ingresar.class);
        startActivity(cambio);
    }

}