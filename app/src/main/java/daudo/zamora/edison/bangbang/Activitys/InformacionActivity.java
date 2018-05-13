package daudo.zamora.edison.bangbang.Activitys;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import daudo.zamora.edison.bangbang.Home;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.beans.EventoBean;
import daudo.zamora.edison.bangbang.beans.Evento_BO;

public class InformacionActivity extends AppCompatActivity {
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
            }
        });
            TextView textView=(TextView)findViewById(R.id.text_informacion_titulo);
        Bundle iBundle=getIntent().getExtras();
        EventoBean evento= (EventoBean) iBundle.getSerializable("informacion");
       textView.setText(evento.getNombre().toString());
    }
}
