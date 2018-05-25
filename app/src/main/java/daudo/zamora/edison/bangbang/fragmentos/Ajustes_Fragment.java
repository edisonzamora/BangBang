package daudo.zamora.edison.bangbang.fragmentos;

;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import daudo.zamora.edison.bangbang.R;

public class Ajustes_Fragment extends Fragment {
private Switch notificacion,permiso;
private SharedPreferences prefs;
private SharedPreferences.Editor editor;
    Boolean ch;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ajustes,container,false);
        //TextView textView=(TextView)view.findViewById(R.id.text_confi);
        prefs = getContext().getSharedPreferences("data_ajuste", Context.MODE_PRIVATE);
       ch= prefs.getBoolean("noti_chet",false);


        notificacion = (Switch) view.findViewById(R.id.notificacion);
        if(ch){

            notificacion.setChecked(true);
        }else{
            notificacion.setChecked(false);
        }

        notificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(getContext(),"Activado",Toast.LENGTH_SHORT).show();
               editor=prefs.edit();
               editor.putBoolean("noti_chet", ch);
               editor.commit();

            }
        });

        permiso = (Switch) view.findViewById(R.id.permiso);

        return view ;
    }//holla

}