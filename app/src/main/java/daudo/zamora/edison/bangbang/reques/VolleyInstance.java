package daudo.zamora.edison.bangbang.reques;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyInstance {
    private static VolleyInstance instanace;
    private RequestQueue requestQueue;
    private Context context;
    // cosntructor
    private VolleyInstance(Context contex) {
        this.context = contex;
    }
    //metodo llama la instancia unica, si no esta inicalizada la inicializa
    //si esta incialiada no la inicializa la clase volleyinstace
    public static synchronized VolleyInstance getvolleyInstance(Context contex) {
        if (instanace == null) {
            instanace = new VolleyInstance(contex);
        }
        return instanace;
    }

    //  retorna el requestqueue
    // ambien singlenton
    public RequestQueue getRetornaRequestQueue() {
        if(requestQueue==null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    // ecoge el objeto JsonObjectRequest  creado e incializad
    public <T> void agregarAlRequestqueue(Request<T> request){
        getRetornaRequestQueue().add(request);
    }
}

