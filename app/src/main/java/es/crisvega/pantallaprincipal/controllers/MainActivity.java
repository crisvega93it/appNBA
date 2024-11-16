package es.crisvega.pantallaprincipal.controllers;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import es.crisvega.pantallaprincipal.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonRegistro;
    private Button botonLista;
    public static int RQ_SECOND_ACT = 0;
    private TextView textBienv;
    private TextView textNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(R.layout.activity_main);

        this.botonRegistro = (Button) findViewById(R.id.buttonRegistro);
        this.botonLista = (Button) findViewById(R.id.buttonLista);
        this.textBienv = (TextView) findViewById(R.id.textViewBienvenido);
        this.textNombre = (TextView) findViewById(R.id.textViewNombre);

        botonRegistro.setOnClickListener(this);
        botonLista.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int boton = v.getId();

        if (boton == botonRegistro.getId()) {

            Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
            startActivityForResult(intent, RQ_SECOND_ACT);
        } else {
            Intent intent = new Intent(MainActivity.this,ListActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RQ_SECOND_ACT) {
            if (resultCode == Activity.RESULT_OK) {
                String nombre = data.getStringExtra("msg");
                textBienv.setText("Bienvenido");
                textNombre.setText(nombre);
                textBienv.setBackgroundColor(Color.BLACK);
                textNombre.setBackgroundColor(Color.BLACK);
            }
        }
    }
}