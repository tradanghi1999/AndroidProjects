package vn.edu.uel.apptudien.data.remote;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//import vn.edu.uel.apptudien.MainActivity;

import static android.accounts.AccountManager.KEY_PASSWORD;

public class ParallelDotsAPI {
    IParallelDotsAPI iParallelDotsAPI;
    Context context;

    public ParallelDotsAPI(IParallelDotsAPI iParallelDotsAPI, Context context) {
        this.iParallelDotsAPI = iParallelDotsAPI;
        this.context = context;
    }
    public void sendVolleyRequest(final IParallelDotsAPI iParallelDotsAPI, final String text_1, final String text_2)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ParallelDotsKey.HTTP_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                        iParallelDotsAPI.onSimilarityResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        iParallelDotsAPI.onFailire("error");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(ParallelDotsKey.text_1,text_1);
                params.put(ParallelDotsKey.text_2,text_2);
                params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return params;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);


    }

}
