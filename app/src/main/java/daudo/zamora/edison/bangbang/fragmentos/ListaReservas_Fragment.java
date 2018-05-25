package daudo.zamora.edison.bangbang.fragmentos;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

import daudo.zamora.edison.bangbang.Activitys.AllActivity;
import daudo.zamora.edison.bangbang.Activitys.InformacionActivity;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.adaptadores.ReservasAdaptador;
import daudo.zamora.edison.bangbang.beans.ReservaBean;
import daudo.zamora.edison.bangbang.reques.VolleyInstance;

public class ListaReservas_Fragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener{
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    // TODO: variables  de oncreateview
    private ListaEventos_Fragment.OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private ArrayList<ReservaBean> listareservas;
    private ReservasAdaptador reservasAdaptador;
    private JsonObjectRequest request;
    private ProgressDialog dialpross;
    private  int iduser;



    public ListaReservas_Fragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static ListaReservas_Fragment newInstance(String param1, String param2) {
        ListaReservas_Fragment fragment = new ListaReservas_Fragment();
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
        /**inflamos el fragmento con el layout**/
        View view=inflater.inflate(R.layout.fragment_lista_eventos_, container, false);
        listareservas=new ArrayList<>();
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerviewid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        cargaLisat();
        return view;
    }
    private void cargaLisat() {
        dialpross = new ProgressDialog(getContext());
        dialpross.setMessage("cargando..");
        dialpross.show();
        String url=getString(R.string.urlhost)+"select/reservas.php?bang=reservas&id=2";
        request=new JsonObjectRequest(Request.Method.GET,url, (String) null,this,this);
        VolleyInstance.getvolleyInstance(getContext()).agregarAlRequestqueue(request);

    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"error sin respuesta" + error.getMessage().toString(),Toast.LENGTH_SHORT).show();
        Log.e("error",error.getMessage().toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            int coneccion=response.optInt("connect");
            int nunReservas=response.optInt("num");
            Log.i("BangBangInfo","coneccion: "+Integer.toString(coneccion));
            Log.i("BangBangInfo","numero de resevas "+Integer.toString(nunReservas));

            JSONArray array =response.optJSONArray("object");
            Log.i("BangBangInfo","array valor reservas "+Integer.toString(array.length()));
            JSONObject object=null;
            ReservaBean reservaBean=null;
            for (int x=0; x<array.length(); x++) {
                object = array.getJSONObject(x);
                reservaBean=new ReservaBean();
                reservaBean.setId_reserva(object.optString("id_reservation").toString());
                Log.i("BangBangInfo",object.optString("id_reservation").toString());

                reservaBean.setId_usuario(object.getString("id_user").toString());
                Log.i("BangBangInfo",object.optString("id_user").toString());

                reservaBean.setNombre_evento(object.getString("name_event").toString());
                Log.i("BangBangInfo",object.optString("name_event").toString());

                reservaBean.setFechaEvento( object.getString("date_event").toString());
                Log.i("BangBangInfo",object.optString("date_event").toString());

                reservaBean.setFechaReserva(object.getString("date_reservation").toString());
                Log.i("BangBangInfo",object.optString("date_reservation").toString());

                reservaBean.setImagen(object.getString("image_event").toString());
                listareservas.add(reservaBean);
            }
            dialpross.hide();
            reservasAdaptador=new ReservasAdaptador(listareservas,getContext());
            recyclerView.setAdapter(reservasAdaptador);
            reservasAdaptador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), AllActivity.class);
                    ReservaBean reservaBean = listareservas.get(recyclerView.getChildAdapterPosition(v));
                    intent.putExtra("infoReserva", reservaBean);
                    startActivity(intent);

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("ERROR","jSON EXCEPTION  null" + e.getMessage().toString());
        }
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
        if (context instanceof ListaEventos_Fragment.OnFragmentInteractionListener) {
            mListener = (ListaEventos_Fragment.OnFragmentInteractionListener) context;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
