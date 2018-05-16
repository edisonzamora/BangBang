package daudo.zamora.edison.bangbang.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.beans.EventoBean;
import daudo.zamora.edison.bangbang.beans.Evento_BO;

/**
 * Created by Edison Zamora on 29/03/2018.
 */

public class EventosAdaptador extends RecyclerView.Adapter<EventosAdaptador.EventoVistaHolder> implements View.OnClickListener {
    private List<EventoBean> list;
    private EventoVistaHolder eventoVistaHolder;
    private View.OnClickListener listener;
    public static int i;
    private Context context;

    /**
     * constructor  del adaptador que recibe una lista de objetos Evento_BO
     **/
    public EventosAdaptador(List<EventoBean> list, int i , Context context) {
        this.list = list;
        this.i = i;
        this.context=context;
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

           // eventoVistaHolderder.imageView.setImageResource(list.get(position).getImagen());
            Glide.with(context).load(list.get(position).getImagen()).into(eventoVistaHolderder.imageView);
            eventoVistaHolderder.textitulo.setText(list.get(position).getNombre());
            eventoVistaHolderder.fechaevento.setText(list.get(position).getFecha());
            eventoVistaHolderder.textcomentario.setText(list.get(position).getComentario());

        }
        if (i == 2) {
            //eventoVistaHolderder.imageView.setImageResource(list.get(position).getImagen());
            Log.i("INFOR",list.get(position).getImagen().toString());
            Glide.with(context).load(list.get(position).getImagen().toString()).into(eventoVistaHolderder.imageView);
            eventoVistaHolderder.textitulo.setText(list.get(position).getNombre());
            eventoVistaHolderder.fechaevento.setText(list.get(position).getComentario());
            eventoVistaHolderder.textcomentario.setText(list.get(position).getComentario());
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
        public TextView textitulo, textcomentario ,fechaevento;

        public EventoVistaHolder(View vista) {
            super(vista);
            /** creamos las referencias de las vistas que vamos a utilizar**/
            if (EventosAdaptador.i == 1) {
                imageView = (ImageView) vista.findViewById(R.id.imagen_recycler2);
                textitulo = (TextView) vista.findViewById(R.id.titulo_recycler2);
                fechaevento  = (TextView) vista.findViewById(R.id.fecha2);
                textcomentario =(TextView) vista.findViewById(R.id.coemntario_e_2);
            }
            if (EventosAdaptador.i == 2) {
                imageView = (ImageView) vista.findViewById(R.id.imagen_e);
                textitulo = (TextView) vista.findViewById(R.id.titulo_recycler_e);
                fechaevento  = (TextView) vista.findViewById(R.id.fecha_evento_e);
                textcomentario =(TextView) vista.findViewById(R.id.coemntario_e);

            }
        }
    }
}

