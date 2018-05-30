package daudo.zamora.edison.bangbang.fragmentos;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import daudo.zamora.edison.bangbang.Home;
import daudo.zamora.edison.bangbang.R;

public class Ajustes_Fragment extends Fragment {
private Switch notificacion,permiso;
private SharedPreferences datausuario ,dataajustes;
private Button button;
private SharedPreferences.Editor editor;
  private   Boolean ch;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ajustes,container,false);
        //TextView textView=(TextView)view.findViewById(R.id.text_confi);
        dataajustes = getContext().getSharedPreferences("data_ajuste", Context.MODE_PRIVATE);
        datausuario=getContext().getSharedPreferences(getString(R.string.datosusuario), Context.MODE_PRIVATE);
        button=(Button)view.findViewById(R.id.botn_cerrar_secion);
        boolean registrado=datausuario.getBoolean(getString(R.string.usuregistrado),false);
        if(registrado!=true){
            button.setText("Iniciar Seción");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Home)getContext()).selectFragmrnt(2);
                }
            });
        }else{
            button.setText(getText(R.string.cerrar));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProgressDialog dialpross=new ProgressDialog(getContext());
                    dialpross.setMessage("cargando..");
                    dialpross.show();
                    editor=datausuario.edit();
                    editor.remove(getString(R.string.usuregistrado));
                    editor.remove(getString(R.string.idusuario));
                    editor.remove(getString(R.string.nombreUsuario));
                    editor.remove(getString(R.string.correoUsuario));
                    editor.remove(getString(R.string.passUsuario));
                    editor.commit();
                    ((Home)getContext()).finish();
                    startActivity(((Home)getContext()).getIntent());
                    dialpross.hide();
                }
            });
        }
        ch= dataajustes.getBoolean("noti_chet",false);
        notificacion = (Switch) view.findViewById(R.id.notificacion);
        notificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(getContext(),"Activado",Toast.LENGTH_SHORT).show();
               editor=dataajustes.edit();
               editor.putBoolean("noti_chet", ch);
               editor.commit();
            }
        });
        permiso = (Switch) view.findViewById(R.id.permiso);
        return view ;
    }
}