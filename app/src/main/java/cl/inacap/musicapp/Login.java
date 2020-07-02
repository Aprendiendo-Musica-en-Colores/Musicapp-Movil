package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText etUsu;
    private EditText etPass;
    Intent cambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsu = (EditText) findViewById(R.id.etUsuario);
        etPass = (EditText) findViewById(R.id.etPassword);
    }

    public void onCLick(View view){

        if (etUsu.getText().toString().equals("admin") || etPass.getText().toString().equals("admin"))
        {
            cambio = new Intent(Login.this, crudUsuarios.class);
            startActivity(cambio);
        }else {
            if (etUsu.getText().toString().equals("") || etPass.getText().toString().equals("")){
                cambio = new Intent(Login.this, HistorialPartidas.class);
                startActivity(cambio);
            }
        }
    }
}