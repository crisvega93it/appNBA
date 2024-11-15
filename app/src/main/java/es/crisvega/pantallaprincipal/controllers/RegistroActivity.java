package es.crisvega.pantallaprincipal.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.crisvega.pantallaprincipal.R;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textoOlvido;
    private Button botonRegistro;
    private EditText textNombre;
    private EditText textEmail;
    private EditText textEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        this.textoOlvido = (TextView) findViewById(R.id.textViewOlvido);
        this.botonRegistro = (Button) findViewById(R.id.buttonRegistrarse);
        this.textNombre = (EditText) findViewById(R.id.editTextName);
        this.textEmail = (EditText) findViewById(R.id.editEmailAddress);
        this.textEdad = (EditText) findViewById(R.id.editTextNumber);


        textoOlvido.setOnClickListener(this);
        botonRegistro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == textoOlvido.getId()) {
            Toast.makeText(this, "¡No mientas!", Toast.LENGTH_SHORT).show();
        } else {
            try {
                String nombre = textNombre.getText().toString();
                String email = textEmail.getText().toString();
                int edad = Integer.parseInt(textEdad.getText().toString());
                int log = logear(nombre, email, edad);
                if (log == -1) {
                    Toast.makeText(this, "Tienes que ser mayor de 18", Toast.LENGTH_SHORT).show();
                } else if (log == -2) {
                    Toast.makeText(this, "Email incorrecto", Toast.LENGTH_SHORT).show();
                } else if (log == -3) {
                    Toast.makeText(this, "El nombre solo puede ocupar hasta 10 espacios", Toast.LENGTH_SHORT).show();
                } else {
                    registroCorrecto(nombre);
                }
            } catch (Exception e) {
                Toast.makeText(this, "Error en el formato de los campos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void registroCorrecto(String nombre) {
        Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("msg", nombre);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }


    private int logear(String nombre, String email, int edad) {
        int correcto = 1;
        if (edad < 18) {
            correcto = -1;
        } else if (!email.contains("@") || !email.contains(".")) {
            correcto = -2;
        } else if (nombre.length() > 10) {
            correcto = -3;
        }
        return correcto;
    }
}