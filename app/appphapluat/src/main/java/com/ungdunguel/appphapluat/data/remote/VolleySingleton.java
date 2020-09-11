package com.ungdunguel.appphapluat.data.remote;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/**
 * Created by lenovo on 3/14/2018.
 */
public class VolleySingleton {
    private static VolleySingleton instance ;
    private RequestQueue requestQueue;
    private Context context;


    private VolleySingleton(Context context)
    {
        this.context = context;
        requestQueue = getRequestQueue();

    }

    public static  synchronized  VolleySingleton getInstance(Context context)
    {

        if(instance == null)
        {
            instance = new VolleySingleton(context);

        }
        return  instance;

    }




    public RequestQueue getRequestQueue()
    {

        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }



    public <T> void addToRequestQueue(Request<T> request)
    {
        getRequestQueue().add(request);
    }




}
