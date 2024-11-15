package es.crisvega.pantallaprincipal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.crisvega.pantallaprincipal.R;
import es.crisvega.pantallaprincipal.models.Equipo;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecycleHolder>{

    private ArrayList<Equipo> equipos;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemLongClick(Equipo equipo, int Position);
        void onItemClick(Equipo equipo);
    }

    public RecyclerAdapter(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void setItemClickListener(OnItemClickListener lis) {
        this.listener = lis;
    }

    @NonNull
    @Override
    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_list,parent,false);
        RecycleHolder recycleHolder = new RecycleHolder(view);
        return recycleHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleHolder holder, int position) {
        Equipo equipo = this.equipos.get(position);
        holder.imgEquipo.setImageResource(equipo.getImagenId());
        holder.txtEquipo.setText(equipo.getEquipo());
        holder.txtDescripcion.setText(equipo.getDescripcion());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (listener != null) {
                    listener.onItemLongClick(equipo, holder.getAbsoluteAdapterPosition()); // Llama a un método específico para clic largo
                }
                return true; // Indica que el evento fue manejado
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(equipo); // Llama al método específico para clic simple
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.equipos.size();
    }

    public class RecycleHolder extends RecyclerView.ViewHolder {
        private ImageView imgEquipo;
        private TextView txtEquipo;
        private TextView txtDescripcion;

        public RecycleHolder(@NonNull View itemView) {
            super(itemView);

            imgEquipo = (ImageView) itemView.findViewById(R.id.img_item);
            txtEquipo = (TextView) itemView.findViewById(R.id.txt_item_tittle);
            txtDescripcion = (TextView) itemView.findViewById(R.id.txt_item_desc);
        }
        public void bind(final Equipo equipo, final View.OnClickListener listener) {
            // Configura los datos en las vistas
            imgEquipo.setImageResource(equipo.getImagenId()); // Suponiendo que tienes un método getImagen()
            txtEquipo.setText(equipo.getEquipo());
            txtDescripcion.setText(equipo.getDescripcion());

            // Configura el listener en el itemView
            itemView.setOnClickListener(listener);
        }
    }
}
