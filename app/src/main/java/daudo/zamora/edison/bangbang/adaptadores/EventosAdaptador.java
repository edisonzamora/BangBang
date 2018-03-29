package daudo.zamora.edison.bangbang.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.bens.Evento_BO;

/**
 * Created by Edison Zamora on 29/03/2018.
 */

public class EventosAdaptador extends RecyclerView.Adapter<EventosAdaptador.EventoVistaHolder> implements View.OnClickListener {
    private List<Evento_BO> list;
    private EventoVistaHolder eventoVistaHolder;
    private View.OnClickListener listener;
    public static int i;

    /**
     * constructor  del adaptador que recibe una lista de objetos Evento_BO
     **/
    public EventosAdaptador(List<Evento_BO> list, int i) {
        this.list = list;
        this.i = i;
    }

    @Override
    public EventoVistaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = null;
        if (i == 1) {
            vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_recycler, parent, false);
        }
        if (i == 2) {
            vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recycler, parent, false);
        }
        vista.setOnClickListener(this);
        eventoVistaHolder = new EventoVistaHolder(vista);
        return eventoVistaHolder;
    }

    @Override
    public void onBindViewHolder(EventoVistaHolder eventoVistaHolderder, int position) {
        if (i == 1) {

            eventoVistaHolderder.imageView.setImageResource(list.get(position).getImagen());
            eventoVistaHolderder.textViewtitulo.setText(list.get(position).getNombre());
        }
        if (i == 2) {
            eventoVistaHolderder.imageView.setImageResource(list.get(position).getImagen());
            eventoVistaHolderder.textViewtitulo.setText(list.get(position).getNombre());
            eventoVistaHolderder.textViewcomentario.setText(list.get(position).getComentario());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    /**
     * clase interna que ayuda a referencias al que le pasaremos la vista
     **/
    public static class EventoVistaHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewtitulo;
        public TextView textViewcomentario;

        public EventoVistaHolder(View vista) {
            super(vista);
            /** creamos las referencias de las vistas que vamos a utilizar**/
            if (EventosAdaptador.i == 1) {
                imageView = (ImageView) vista.findViewById(R.id.imagen_recycler2);
                textViewtitulo = (TextView) vista.findViewById(R.id.titulo_recycler2);
            }
            if (EventosAdaptador.i == 2) {
                imageView = (ImageView) vista.findViewById(R.id.imagen_recycler);
                textViewtitulo = (TextView) vista.findViewById(R.id.titulo_recycler);
                textViewcomentario = (TextView) vista.findViewById(R.id.comentario_recycler);
            }
        }
    }
}
