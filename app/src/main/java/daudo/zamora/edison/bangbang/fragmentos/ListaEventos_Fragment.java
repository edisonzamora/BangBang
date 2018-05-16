package daudo.zamora.edison.bangbang.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import daudo.zamora.edison.bangbang.Activitys.InformacionActivity;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.adaptadores.EventosAdaptador;
import daudo.zamora.edison.bangbang.beans.EventoBean;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaEventos_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaEventos_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaEventos_Fragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    // TODO: variables  de oncreateview
    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private ArrayList<EventoBean>listaeventos;
    private EventosAdaptador eventosAdaptador;
    private EventoBean evento;

    public ListaEventos_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaEventos_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaEventos_Fragment newInstance(String param1, String param2) {
        ListaEventos_Fragment fragment = new ListaEventos_Fragment();
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
        listaeventos=new ArrayList<>();
        lista_eventos_mock(listaeventos);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerviewid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        eventosAdaptador=new EventosAdaptador(listaeventos,2,getContext());
        eventosAdaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText( getContext(),"evento: "+listaeventos.get(recyclerView.getChildAdapterPosition(v)).getNombre(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getContext(), InformacionActivity.class);
                 evento= listaeventos.get(recyclerView.getChildAdapterPosition(v));
                intent.putExtra("informacion",evento);
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(eventosAdaptador);
        return view;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public static void lista_eventos_mock(List lista) {
        lista.add(new EventoBean(1,"FIESTA1","2018-04-12","BUENA FIESTA 1","http://drive.google.com/uc?export=view&id=1bskJCXbyN47njgtrbJt4ppATOMPCwHg6"));
        lista.add(new EventoBean(2,"FIESTA2","2018-04-12","BUENA FIETSA 2","http://drive.google.com/uc?export=view&id=1bskJCXbyN47njgtrbJt4ppATOMPCwHg6"));
        lista.add(new EventoBean(3,"FIESTA3","2018-04-12","BUENA FIETSA 3","http://drive.google.com/uc?export=view&id=1bskJCXbyN47njgtrbJt4ppATOMPCwHg6"));
        lista.add(new EventoBean(4,"FIESTA4","2018-04-12","BUENA FIESTA 4","http://drive.google.com/uc?export=view&id=1bskJCXbyN47njgtrbJt4ppATOMPCwHg6"));
    }
}
