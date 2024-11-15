package es.crisvega.pantallaprincipal.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.crisvega.pantallaprincipal.R;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtTitulo;
    private TextView txtDesc;
    private ImageView imgJug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle);

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String descripcion = intent.getStringExtra("descripcion");
        int idImagen = intent.getIntExtra("imagenId",0);

        this.txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        this.txtDesc = (TextView) findViewById(R.id.txtDesc);
        this.imgJug = (ImageView) findViewById(R.id.img_Jug);

        txtTitulo.setText(titulo);
        txtDesc.setText(descripcion);
        imgJug.setImageResource(idImagen);
    }
}