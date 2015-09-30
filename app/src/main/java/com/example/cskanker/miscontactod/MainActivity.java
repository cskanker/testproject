package com.example.cskanker.miscontactod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cskanker.miscontactod.util.TextChangedListener;

public class MainActivity extends AppCompatActivity {
//campos de clase
private EditText txtNombre,txtTelefono,txtEmail,txtDireccion;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    inicializarComponentesUI();
    }

    private void inicializarComponentesUI() {
        txtNombre=(EditText)findViewById(R.id.cmpNombre);
        txtTelefono=(EditText)findViewById(R.id.cmpTelefono);
        txtEmail=(EditText)findViewById(R.id.cmpEmail);
        txtDireccion=(EditText)findViewById(R.id.cmpDireccion);
        txtNombre.addTextChangedListener(new TextChangedListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                btnAgregar = (Button) findViewById(R.id.btnAgregar);
                btnAgregar.setEnabled(!s.toString().trim().isEmpty());
            }
        });
    }


    public void onClick(View view) {
        //view vista que genero el evento
        //String. format para concatenar mas cadenas (tratar de evitar el operador de concatenacion)
        String msg=String.format("%s ha sido agregado a la lista", txtNombre.getText());
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.getText().clear();
        txtTelefono.getText().clear();
        txtEmail.getText().clear();
        txtDireccion.getText().clear();
        //funcion llamar el foco a nombre nuevamente
        txtNombre.requestFocus();
    }
}
