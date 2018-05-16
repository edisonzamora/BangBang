package daudo.zamora.edison.bangbang.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import daudo.zamora.edison.bangbang.Activitys.InformacionActivity;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.adaptadores.EventosAdaptador;
import daudo.zamora.edison.bangbang.beans.EventoBean;

public class GridEventos_Fragment extends Fragment {
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

    public GridEventos_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GridEventos_Fragment.
     */
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
        View vista=inflater.inflate(R.layout.fragment_grid_eventos_,container,false);
        recyclerView=(RecyclerView)vista.findViewById(R.id.recyclerviewid2);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        lista=new ArrayList<>();
        lista_eventos_mock(lista);
          eventosAdaptador=new EventosAdaptador(lista,1,getContext());
           eventosAdaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getContext() , InformacionActivity.class);
                 evento= lista.get(recyclerView.getChildAdapterPosition(v));
                intent.putExtra("informacion",evento);
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(eventosAdaptador);

        return vista;
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }
    private void lista_eventos_mock(ArrayList lista) {
        lista.add(new EventoBean(1,"FIESTA1","2018-04-12","BUENA FIESTA 1","http://drive.google.com/uc?export=view&id=1bskJCXbyN47njgtrbJt4ppATOMPCwHg6"));
        lista.add(new EventoBean(2,"FIESTA2","2018-04-12","BUENA FIETSA 2","http://drive.google.com/uc?export=view&id=1bskJCXbyN47njgtrbJt4ppATOMPCwHg6"));
        lista.add(new EventoBean(3,"FIESTA3","2018-04-12","BUENA FIETSA 3","http://drive.google.com/uc?export=view&id=1bskJCXbyN47njgtrbJt4ppATOMPCwHg6"));
        lista.add(new EventoBean(4,"FIESTA4","2018-04-12","BUENA FIESTA 4","http://drive.google.com/uc?export=view&id=1bskJCXbyN47njgtrbJt4ppATOMPCwHg6"));
    }

    }

