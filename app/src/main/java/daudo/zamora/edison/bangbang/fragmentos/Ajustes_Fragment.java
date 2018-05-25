package daudo.zamora.edison.bangbang.fragmentos;

;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import daudo.zamora.edison.bangbang.R;

public class Ajustes_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ajustes,container,false);
        TextView textView=(TextView)view.findViewById(R.id.text_confi);
        return view ;
    }//holla
}
