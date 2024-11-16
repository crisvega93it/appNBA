package es.crisvega.pantallaprincipal.controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import es.crisvega.pantallaprincipal.R;
import es.crisvega.pantallaprincipal.adapters.RecyclerAdapter;
import es.crisvega.pantallaprincipal.models.Equipo;
import es.crisvega.pantallaprincipal.utilidades.listaEquipos;


public class ListActivity extends AppCompatActivity {

    private RecyclerView recView;
    private RecyclerAdapter recAdapter;
    private listaEquipos equipos;
    private ActionMode mActionMode;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.recView = (RecyclerView) findViewById(R.id.recView);

        this.equipos = new listaEquipos();

        this.recAdapter = new RecyclerAdapter(equipos.getEquipos());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recView.setAdapter(recAdapter);
        recView.setLayoutManager(layoutManager);

        recAdapter.setItemClickListener(new RecyclerAdapter.OnItemClickListener() {

            @Override
            public void onItemLongClick(Equipo equipo, int position) {
                if (mActionMode == null) {
                    selectedPosition = position;
                    mActionMode = startSupportActionMode(mActionCallback);
                } else {
                    mActionMode = null;
                }
            }

            @Override
            public void onItemClick(Equipo equipo) {
                Intent intent = new Intent(ListActivity.this, DetalleActivity.class);
                intent.putExtra("titulo", equipo.getEquipo());
                intent.putExtra("descripcion", equipo.getDescripcion());
                intent.putExtra("imagenId", equipo.getImagenId());
                startActivity(intent);
            }
        });


    }

    private ActionMode.Callback mActionCallback = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_action, menu);
            mode.setTitle("Action Menu");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            int id = item.getItemId();

            if (id == R.id.item_papelera) {
                AlertDialog alertDialog = createAlertDialog();
                alertDialog.show();
                mode.finish(); //
            } else if (id == R.id.item_cancelar) {
                mode.finish();
                return true;
            }

            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    private AlertDialog createAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

        builder.setMessage("¿Deseas eliminar el Item?")
                .setTitle("Eliminar");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                equipos.getEquipos().remove(selectedPosition);
                recAdapter.notifyItemRemoved(selectedPosition);
                selectedPosition = -1;
                Toast.makeText(ListActivity.this, "Borrado", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ListActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }

}