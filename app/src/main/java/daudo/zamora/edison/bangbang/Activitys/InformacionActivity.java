package daudo.zamora.edison.bangbang.Activitys;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import daudo.zamora.edison.bangbang.Home;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.beans.EventoBean;


public class InformacionActivity extends AppCompatActivity {
    private TextView titulo,calle,num,cp,ciudad,telefono,fijo,coment,fecha;
   private ImageView imangeninfo;
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
                Intent intent=new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                finish();
            }
        });
        Bundle iBundle=getIntent().getExtras();
        EventoBean evento= (EventoBean) iBundle.getSerializable("informacion");
        imangeninfo=(ImageView)findViewById(R.id.img_info);
        Glide.with(getApplicationContext()).load(evento.getImagen()).crossFade().centerCrop().into(imangeninfo);
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

    }
}
