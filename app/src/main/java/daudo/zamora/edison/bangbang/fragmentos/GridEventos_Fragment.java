package daudo.zamora.edison.bangbang.fragmentos;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import daudo.zamora.edison.bangbang.Activitys.InformacionActivity;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.adaptadores.EventosAdaptador;
import daudo.zamora.edison.bangbang.beans.EventoBean;
import daudo.zamora.edison.bangbang.reques.VolleyInstance;

public class GridEventos_Fragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private ArrayList<EventoBean>lista;
    private EventoBean evento;
    private EventosAdaptador eventosAdaptador;
    private  JsonObjectRequest request;
    private ProgressDialog dialpross;


    public GridEventos_Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GridEventos_Fragment newInstance(String param1, String param2) {
        GridEventos_Fragment fragment = new GridEventos_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_lista_eventos_, container, false);
        lista=new ArrayList<>();
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerviewid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);
        cargaLisat();
        return view;
    }

    private void cargaLisat() {
        dialpross=new ProgressDialog(getContext());
        dialpross.setMessage("cargando..");
        dialpross.show();
        String url=getString(R.string.urlhost)+"select/events.php?bang=events";
        request=new JsonObjectRequest(Request.Method.GET,url,this,this);
        VolleyInstance.getvolleyInstance(getContext()).agregarAlRequestqueue(request);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"Verifique su coneccion a internet porfavor ",Toast.LENGTH_SHORT).show();
        dialpross.hide();
        eventosAdaptador = new EventosAdaptador(lista, 1, getContext());
        recyclerView.setAdapter(eventosAdaptador);
    }
    @Override
    public void onResponse(JSONObject response) {
        try {
            int coneccion = response.getInt("connect");
            int numEventos= response.getInt("num");
            Log.i("BangBangInfo","coneccion"+Integer.toString(coneccion));
            Log.i("BangBangInfo","numero de eventos "+Integer.toString(numEventos));
            JSONArray array =response.optJSONArray("object");
            Log.i("BangBangInfo","array valor eventos: "+Integer.toString(array.length()));
            JSONObject object=null;
            EventoBean eventosBean=null;
            for(int x=0; x<array.length(); x++){
                object = array.getJSONObject(x);
                eventosBean=new EventoBean();
                eventosBean.setId_evento(object.optString("id_event").toString());
                Log.i("BangBangInfo",object.optString("id_event").toString());

                eventosBean.setNombre(object.getString("name_event").toString());
                Log.i("BangBangInfo",object.optString("name_event").toString());

                eventosBean.setFecha(object.getString("date_event").toString());
                Log.i("BangBangInfo",object.optString("date_event").toString());

                eventosBean.setImagen(object.getString("image_event").toString());
                if(object.getString("coment_event")==null || object.getString("coment_event").toString().equalsIgnoreCase("null")){
                    eventosBean.setComentario("");
                }else{
                    eventosBean.setComentario(object.getString("coment_event").toString());
                    Log.i("BangBangInfo",object.optString("coment_event").toString());
                }

                lista.add(eventosBean);
            }
            dialpross.hide();
            eventosAdaptador = new EventosAdaptador(lista, 1, getContext());
            recyclerView.setAdapter(eventosAdaptador);
            eventosAdaptador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), InformacionActivity.class);
                    evento = lista.get(recyclerView.getChildAdapterPosition(v));
                    intent.putExtra("informacion", evento);
                    startActivity(intent);

                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
            e.printStackTrace();
            Log.e("ERROR","jSON EXCEPTION  null" + e.getMessage().toString());
        }

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }

    }

