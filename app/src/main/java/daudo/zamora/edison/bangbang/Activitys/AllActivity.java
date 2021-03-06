package daudo.zamora.edison.bangbang.Activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import daudo.zamora.edison.bangbang.Home;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.beans.EventoBean;
import daudo.zamora.edison.bangbang.beans.ReservaBean;
import daudo.zamora.edison.bangbang.fragmentos.LoginFragment;
import daudo.zamora.edison.bangbang.fragmentos.Registro_Fragment;
import daudo.zamora.edison.bangbang.reques.VolleyInstance;

public class AllActivity extends AppCompatActivity{
    private TextView nombre, fecha, calle,numero_callle,cp,ciudad;
    private Button eliminar ,confirmar;
    private ImageView imageView;
    private Toolbar toolbar;

    private String id_reserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
         //SharedPreferences preferences= getApplicationContext().getSharedPreferences(getString(R.string.datosusuario, Context.MODE_PRIVATE));
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }// cambios en el layout
        });
        Bundle bundle=getIntent().getExtras();
        ReservaBean reservaBean = (ReservaBean) bundle.getSerializable("infoReserva");
        id_reserva=reservaBean.getId_reserva();

        imageView=(ImageView)findViewById(R.id.image_reser_car);
        Glide.with(getApplicationContext()).load(reservaBean.getImagen()).crossFade().centerCrop().into(imageView);
        nombre=(TextView)findViewById(R.id.reser_nombre_card);
        nombre.setText(reservaBean.getNombre_evento());
        fecha=(TextView)findViewById(R.id.reser_fecha_card);
        fecha.setText(reservaBean.getFechaReserva());
        calle=(TextView)findViewById(R.id.reser_calle_card);
        EventoBean eventoBean=new EventoBean();
        calle.setText(eventoBean.getDireccion().getCalle());
        numero_callle=(TextView)findViewById(R.id.reser_numero_card);
        numero_callle.setText(eventoBean.getDireccion().getNumero());
        cp=(TextView)findViewById(R.id.reser_cp_card);
        cp.setText(eventoBean.getDireccion().getCp());
        ciudad=(TextView)findViewById(R.id.reser_ciudad_card);
        ciudad.setText(eventoBean.getDireccion().getCiudad());
        eliminar = (Button) findViewById(R.id.boton_eliminar);
        confirmar = (Button) findViewById(R.id.boton_confirmar);
        confirmar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"Reserva confirmada",Toast.LENGTH_SHORT).show();
                    }
                });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String url =getString(R.string.urlhost)+"delet_input/delete.php?reserva="+id_reserva;
                JsonObjectRequest json=new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(),"borrado",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });
                VolleyInstance.getvolleyInstance(getApplicationContext()).agregarAlRequestqueue(json);
            }


        });


    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
       menu.removeItem(R.id.registrar);
        menu.removeItem(R.id.login);
        return true;
    }
}
