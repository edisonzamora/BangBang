package daudo.zamora.edison.bangbang.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import daudo.zamora.edison.bangbang.Activitys.AllActivity;
import daudo.zamora.edison.bangbang.Home;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.beans.UsuarioBean;
import daudo.zamora.edison.bangbang.reques.VolleyInstance;

public class LoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: instancias de las vistas a  utilizar

    private EditText edt_email;
    private EditText edt_password;
    private CheckBox recordar_usuario;
    private Button btn_aceptar;
    private TextView Signup;
private StringRequest login;
    SharedPreferences prefs;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
      /**aqui se le dara los eventos a los botones**/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        edt_email=(EditText)view.findViewById(R.id.ed_email);
        edt_password=(EditText)view.findViewById(R.id.ed_Pass);
        recordar_usuario=(CheckBox)view.findViewById(R.id.chb_recordar_usuario);
        btn_aceptar=(Button)view.findViewById(R.id.btn_login_aceptar);
        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consulta();
            }
        });
        Signup=(TextView) view.findViewById(R.id.tv_signup);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ((Home)getContext()).selectFragmrnt(1);
            }
        });
        return view;
    }

    private void consulta() {
        String url=getString(R.string.urlhost)+"insert/loginusuario.php?mail="+edt_email.getText().toString()+"&pass="+edt_password.getText().toString();
        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    String conexion=response.getString("connect").toString();
                    String registrado=response.getString("registrado");
                    if(registrado.equalsIgnoreCase("si")){
                        Toast.makeText(getContext(),"registrado",Toast.LENGTH_SHORT).show();
                        JSONArray valores=response.getJSONArray("usuario");
                        JSONObject usuario=valores.getJSONObject(0);
                        UsuarioBean usuarioBean=new UsuarioBean();
                        usuarioBean.setId(Integer.parseInt(usuario.optString("id_user").toString()));
                        usuarioBean.setNombre(usuario.optString("name_user").toString());
                        usuarioBean.setApellido(usuario.optString("last_name_user").toString());
                        usuarioBean.setFechanaciemoto(usuario.optString("age_user").toString());
                        usuarioBean.setSexo(usuario.optString("sex_user").toString());
                        usuarioBean.setCorreo(usuario.optString("email_user").toString());
                        usuarioBean.setTelefono("");
                        usuarioBean.setPass(usuario.optString("pass_user").toString());
                        Log.i("INFI","coneccion:"+conexion);
                        Log.i("INFI","registrado:"+registrado);
                        Log.i("INFI","id:"+Integer.toString(usuarioBean.getId()));
                        Log.i("INFI","nombre:"+usuarioBean.getNombre());
                        Log.i("INFI","apellido:"+usuarioBean.getApellido());
                        Log.i("INFI","edad:"+usuarioBean.getFechanaciemoto());
                        Log.i("INFI","sexo:"+usuarioBean.getSexo());
                        Log.i("INFI","correo:"+usuarioBean.getCorreo());
                        Log.i("INFI","pass:"+usuarioBean.getPass());

                        ((Home)getContext()).selectFragmrnt(2);
                        ((Home)getContext()).configUser(usuarioBean);

                    }else{

                        Toast.makeText(getContext(),"noregistrado",Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"error"+error.toString(),Toast.LENGTH_SHORT).show();

            }
        });
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
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
