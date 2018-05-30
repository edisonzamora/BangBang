package daudo.zamora.edison.bangbang.Activitys;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import org.json.JSONObject;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.beans.EventoBean;
import daudo.zamora.edison.bangbang.reques.VolleyInstance;


public class InformacionActivity extends AppCompatActivity {
    private TextView titulo,calle,num,cp,ciudad,telefono,fijo,coment,fecha;
   private ImageView imangeninfo;
   private Button reservar;
   private VolleyInstance instance;
   private SharedPreferences sp;
   private String idevento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        Toolbar toolbar=(Toolbar)findViewById(R.id.barra2);
        toolbar.setTitle(R.string.layout_informacion);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Bundle iBundle=getIntent().getExtras();
        EventoBean evento= (EventoBean) iBundle.getSerializable("informacion");
        imangeninfo=(ImageView)findViewById(R.id.img_info);
        Glide.with(getApplicationContext()).load(evento.getImagen()).crossFade().centerCrop().into(imangeninfo);
        idevento=evento.getId_evento();
        fecha=(TextView)findViewById(R.id.info_feccha);
        fecha.setText(evento.getFecha());
        titulo=(TextView)findViewById(R.id.info_text);
        titulo.setText(evento.getNombre());
        calle=(TextView)findViewById(R.id.info_calle);
        calle.setText(evento.getDireccion().getCalle());
        num=(TextView)findViewById(R.id.info_num);
        num.setText(evento.getDireccion().getNumero());
        ciudad=(TextView)findViewById(R.id.info_ciu);
        ciudad.setText(evento.getDireccion().getCiudad());
        cp=(TextView)findViewById(R.id.info_cp);
        cp.setText(evento.getDireccion().getCp());
        telefono=(TextView)findViewById(R.id.info_telf);
        telefono.setText(evento.getDireccion().getTelefono());
        fijo=(TextView)findViewById(R.id.info_fijo);
        fijo.setText(evento.getDireccion().getTelefono_fijo());
        coment=(TextView)findViewById(R.id.info_comen);
        coment.setText(evento.getComentario());
        reservar=(Button)findViewById(R.id.boton_reservar);
        instance=VolleyInstance.getvolleyInstance(getApplicationContext());
        sp=getSharedPreferences(getString(R.string.datosusuario), Context.MODE_PRIVATE);
        boolean registrado=sp.getBoolean(getString(R.string.usuregistrado),false);
        if(registrado=true){

            reservar.setEnabled(true);
        }else{

           reservar.setEnabled(false);
        }
        reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String iduser=sp.getString(getString(R.string.idusuario)," ");
                String url=getString(R.string.urlhost)+"insert/insertreservate.php?idusuario="+iduser+"&idevento="+idevento;
                final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String coneccio = response.optString("conncet");
                        String insertado = response.optString("insertado");
                        String error = response.optString("erro");
                        if ("si".equalsIgnoreCase(insertado)) {
                            Toast.makeText(getApplicationContext(), "Registrado", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "No Registrado", Toast.LENGTH_LONG).show();

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"error al reservar:compruebe coneccion",Toast.LENGTH_SHORT).show();
                        Log.e("ERRORBANG",error.getMessage().toString());
                    }
                });
                instance.agregarAlRequestqueue(request);
            }
        });

    }
}
