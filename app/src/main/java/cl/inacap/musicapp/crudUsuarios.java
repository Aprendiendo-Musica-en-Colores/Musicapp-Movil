package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class crudUsuarios extends AppCompatActivity {

    private FloatingActionButton fbtnMenu,fbtnAgregar,fbtnEliminar,fbtnModificar;
    private EditText etRut,etNombre,etApePat,etApeMat,etDirec,etMail,etFecNac,etUsu,etPass;
    private Spinner etTipoUsu;
    private boolean isOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_usuarios);

        fbtnMenu = findViewById(R.id.fbtnMenu);
        fbtnAgregar = findViewById(R.id.fbtnAgregar);
        fbtnEliminar = findViewById(R.id.fbtnEliminar);
        fbtnModificar = findViewById(R.id.fbtnModificar);
        etRut = findViewById(R.id.idRut);
        etNombre = findViewById(R.id.idNom);
        etApePat = findViewById(R.id.idApePat);
        etApeMat = findViewById(R.id.idApeMat);
        etDirec = findViewById(R.id.idDireccion);
        etMail = findViewById(R.id.idMail);
        etFecNac = findViewById(R.id.idFecNac);
        etUsu = findViewById(R.id.idUsu);
        etPass = findViewById(R.id.idPass);
        etTipoUsu = findViewById(R.id.idTipoUsu);

        isOpen = false;
        fbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){

                }else{

                }
            }
        });
    }
}