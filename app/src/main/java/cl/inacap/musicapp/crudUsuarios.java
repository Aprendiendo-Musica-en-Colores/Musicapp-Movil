package cl.inacap.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class crudUsuarios extends AppCompatActivity {

    private FloatingActionButton fbtnMenu,fbtnAgregar,fbtnEliminar,fbtnModificar;
    private EditText etRut,etNombre,etApePat,etApeMat,etDirec,etMail,etFecNac,etUsu,etPass;
    private TextView txtAgregar,txtEliminar,txtModificar;
    private Spinner etTipoUsu;
    private boolean isOpen;
    private Animation btnOpenAnim,btnCloseAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_usuarios);

        btnOpenAnim = AnimationUtils.loadAnimation(crudUsuarios.this,R.anim.fab_open);
        btnCloseAnim = AnimationUtils.loadAnimation(crudUsuarios.this,R.anim.fab_close);

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
        txtAgregar = findViewById(R.id.txtBtnAgregar);
        txtEliminar = findViewById(R.id.txtBtnEliminar);
        txtModificar = findViewById(R.id.txtBtnModificar);

        isOpen = false;
        fbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){
                    fbtnAgregar.setAnimation(btnCloseAnim);
                    fbtnModificar.setAnimation(btnCloseAnim);
                    fbtnEliminar.setAnimation(btnCloseAnim);
                    txtAgregar.setVisibility(View.INVISIBLE);
                    txtEliminar.setVisibility(View.INVISIBLE);
                    txtModificar.setVisibility(View.INVISIBLE);
                    isOpen= false;
                }else{
                    fbtnAgregar.setAnimation(btnOpenAnim);
                    fbtnModificar.setAnimation(btnOpenAnim);
                    fbtnEliminar.setAnimation(btnOpenAnim);
                    txtAgregar.setVisibility(View.VISIBLE);
                    txtEliminar.setVisibility(View.VISIBLE);
                    txtModificar.setVisibility(View.VISIBLE);
                    isOpen=true;
                }
            }
        });
    }
}