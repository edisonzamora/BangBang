package daudo.zamora.edison.bangbang.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;

import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.beans.ReservaBean;

public class ReservasAdaptador extends RecyclerView.Adapter<ReservasAdaptador.ReservaVistaHolder> implements View.OnClickListener {
private List<ReservaBean> list;
private ReservaVistaHolder reservaVistaHolder;
private View.OnClickListener listener;
private Context context;

public ReservasAdaptador(List<ReservaBean> list, Context context) {
        this.list = list;
        this.context=context;
        }

@Override
public ReservaVistaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = null;
        vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_resevas, parent, false);
        vista.setOnClickListener(this);
        reservaVistaHolder = new ReservaVistaHolder(vista);
        return reservaVistaHolder;
        }

@Override
public void onBindViewHolder(ReservaVistaHolder reservaVistaHolder, int position) {
        Glide.with(context).load(list.get(position).getImagen().toString()).crossFade().centerCrop().into(reservaVistaHolder.imageView);
        reservaVistaHolder.textevento.setText(list.get(position).getNombre_evento());
        reservaVistaHolder.fechaevento.setText(list.get(position).getFechaEvento());
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
public static class ReservaVistaHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textevento,fechaevento,fechareserva;


    public ReservaVistaHolder(View vista) {
        super(vista);
            imageView = (ImageView) vista.findViewById(R.id.imagen_r);
            textevento = (TextView) vista.findViewById(R.id.titulo_recycler);
            fechaevento=(TextView) vista.findViewById(R.id.fecha_evento);


    }
}

}
