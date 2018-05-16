package daudo.zamora.edison.bangbang.reques;

import android.content.Context;

import com.android.volley.RequestQueue;

public class VolleyInstance {
    private static VolleyInstance instanace;
    private RequestQueue requestQueue;
    private Context context;

    // get Reques
    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    // cosntructor
    private VolleyInstance(Context contex) {
        this.context = contex;
    }

    public static synchronized VolleyInstance getvolleyInstance(Context contex) {
        if (instanace == null) {
            instanace = new VolleyInstance(contex);
        }
        return instanace;
    }
}

