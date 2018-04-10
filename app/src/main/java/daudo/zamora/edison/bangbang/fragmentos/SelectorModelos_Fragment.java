package daudo.zamora.edison.bangbang.fragmentos;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import daudo.zamora.edison.bangbang.Home;
import daudo.zamora.edison.bangbang.R;

public class SelectorModelos_Fragment  extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private Button boton_lista;
    private Button boton_grig;



    public SelectorModelos_Fragment() {
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
    public static SelectorModelos_Fragment newInstance(String param1, String param2) {
        SelectorModelos_Fragment fragment = new SelectorModelos_Fragment();
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
        View vista=inflater.inflate(R.layout.fragment_selectormodelos,container,false);
        boton_lista=(Button) vista.findViewById(R.id.bnt_lista);
        //boton_lista.setBackgroundColor(Color.BLACK);
        //boton_lista.setTextColor(Color.WHITE);
        boton_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Home)getContext()).recogeInformacion(1);
                //boton_grig.setBackgroundColor(Color.BLACK);
                //boton_lista.setBackgroundColor(Color.RED);


            }
        });
        boton_grig=(Button) vista.findViewById(R.id.bnt_grid);
        //boton_grig.setBackgroundColor(Color.RED);
        //boton_grig.setTextColor(Color.WHITE);
        boton_grig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Home)getContext()).recogeInformacion(2);
                //boton_lista.setBackgroundColor(Color.BLACK);
                //boton_grig.setBackgroundColor(Color.RED);

            }
        });

        return vista;
    }





}
