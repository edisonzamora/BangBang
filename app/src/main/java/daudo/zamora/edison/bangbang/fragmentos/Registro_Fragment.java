package daudo.zamora.edison.bangbang.fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.beans.UsuarioBean;

public class Registro_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Referneciade  de las Vistas a utilizar
    private EditText editText_nobre, editText_apellido,editText_correo, editText_pass,editTextedad, editTexttefelono;
    private RadioButton h,m;
    private RadioGroup group;
    private CheckBox acaptarTerminos;
    private Button boton;
    private String valorSexo;
    private UsuarioBean usuario;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public Registro_Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Registro_Fragment newInstance(String param1, String param2) {
        Registro_Fragment fragment = new Registro_Fragment();
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
        /** inflamos los campos y los botonos que vamosautilizar **/
        View view=inflater.inflate(R.layout.fragment_registro, container, false);
        editText_nobre=(EditText)view.findViewById(R.id.nombre_uruario);
        editText_apellido=(EditText)view.findViewById(R.id.apellido_usuario);
        editTextedad=(EditText)view.findViewById(R.id.edad);
        group=(RadioGroup)view.findViewById(R.id.radiogroup);
        h=(RadioButton)view.findViewById(R.id.radioButton1);
        h.setSelected(true);
        m=(RadioButton)view.findViewById(R.id.radioButton2);
        editTexttefelono=(EditText)view.findViewById(R.id.telefono);
        editText_correo=(EditText)view.findViewById(R.id.email_usuario);
        editText_pass=(EditText)view.findViewById(R.id.password_usuario);
        acaptarTerminos=(CheckBox)view.findViewById(R.id.chech_config);
        boton = (Button) view.findViewById(R.id.boton_reg);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (h.isChecked()) {
                    valorSexo ="H";
                } else if (m.isChecked()) {
                    valorSexo ="M";
                }
            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String terminos = "si";
                if (!acaptarTerminos.isChecked()) {
                    terminos = "no";
                    Toast.makeText(getContext(), "Debe Aceptar los terminos de privacidad", Toast.LENGTH_SHORT).show();
                } else {
                    usuario=new UsuarioBean();
                    usuario.setNombre(editText_nobre.getText().toString());
                    usuario.setApellido(editText_apellido.getText().toString());
                    usuario.setFechanaciemoto(editTextedad.getText().toString());
                    if (h.isChecked()){
                        valorSexo="H";
                    }
                    usuario.setSexo(valorSexo);
                    usuario.setTelefono(editTexttefelono.getText().toString());
                    usuario.setCorreo(editText_correo.getText().toString());
                    usuario.setPass(editText_pass.getText().toString());
                    Log.i("INFORMACION", "NOMBRE:" + editText_nobre.getText().toString());
                    Log.i("INFORMACION", "APELLIDO:" + editText_apellido.getText().toString());
                    Log.i("INFORMACION", "edad:" + editTextedad.getText().toString());
                    Log.i("INFORMACION", "SEXO:" + valorSexo);
                    Log.i("INFORMACION", "TELEFONO:" + editTexttefelono.getText().toString());
                    Log.i("INFORMACION", "EMAIL:" + editText_correo.getText().toString());
                    Log.i("INFORMACION", "PASS:" + editText_pass.getText().toString());
                    Log.i("INFORMACION", "ACAPTA LOS TERMINSO:" + terminos);
                    if(validaDatos(usuario)){
                        Toast.makeText(getContext(), "Verifique que los campos requeridos no estén vacíos", Toast.LENGTH_SHORT).show();
                    }else {
                        if(Integer.parseInt(usuario.getFechanaciemoto())>=17 & Integer.parseInt(usuario.getFechanaciemoto())<= 150 ){
                            callApi();
                        }else {
                            Toast.makeText(getContext(), "No tiene edad apropiada", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }
        });
        return view;
    }

    protected void callApi() {
        String url="";
    }
// pequeña validacion para asegurarnos de que los datos no sean nulos
    protected boolean validaDatos(UsuarioBean usuario) {
        if (!usuario.getNombre().toString().equalsIgnoreCase("")) {
            if (!usuario.getApellido().toString().equalsIgnoreCase("")) {
                if(!usuario.getSexo().toString().equalsIgnoreCase("")){
                    if (!usuario.getFechanaciemoto().toString().equalsIgnoreCase("")){
                        if (!usuario.getCorreo().toString().equalsIgnoreCase("")){
                            if (!usuario.getPass().toString().equalsIgnoreCase("")){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
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
}
