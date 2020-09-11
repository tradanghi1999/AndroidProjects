package vn.edu.uel.apptudien.data.remote;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import vn.edu.uel.apptudien.model.Page;
import vn.edu.uel.apptudien.util.OwnLibrary;

public class UelAPI {
    Context context;
    IUelAPI iUelAPI;

    public UelAPI(Context context, IUelAPI iUelAPI) {
        this.context = context;
        this.iUelAPI = iUelAPI;
    }
    public void sendToGetMetaData()
    {
        Page page = Page.getInstance(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,  page.getHome_metadata(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                        iUelAPI.onResponseMetadata(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        iUelAPI.onFailure("error");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                //Map<String,String> params = new HashMap<String, String>();
                //params.put(ParallelDotsKey.text_1,text_1);
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return null;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    public void sendToGetWordData()
    {
        Page page = Page.getInstance(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,  page.getHome_word(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                        iUelAPI.onResponeWordData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        iUelAPI.onFailure("error_UELapi");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                //Map<String,String> params = new HashMap<String, String>();
                //params.put(ParallelDotsKey.text_1,text_1);
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return null;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    public void sendToGetGroupData()
    {
        Page page = Page.getInstance(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,  page.getHome_group(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                        iUelAPI.onResponeGroupData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        iUelAPI.onFailure("error_UELapi");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                //Map<String,String> params = new HashMap<String, String>();
                //params.put(ParallelDotsKey.text_1,text_1);
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return null;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
    public void sendToGetNewsData()
    {
        Page page = Page.getInstance(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,  page.getHome_news(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                        iUelAPI.onResponeNewsData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        iUelAPI.onFailure("error_UELapi");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                //Map<String,String> params = new HashMap<String, String>();
                //params.put(ParallelDotsKey.text_1,text_1);
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return null;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }



    public void downloadBanner(String urlString)
    {
        //Page page = Page.getInstance(context);
        ImageRequest stringRequest = new ImageRequest(urlString,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        //mImageView.setImageBitmap(bitmap);
                        iUelAPI.onResponeImage(bitmap);
                    }
                },0,0,null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        iUelAPI.onFailure("error_UELapi");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("width", OwnLibrary.dpToPx(context,400) +"");
                params.put("height", OwnLibrary.dpToPx(context,200)+"");
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return null;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    public void sendToGetBanner()
    {
        Page page = Page.getInstance(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,  page.getHome_banner(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                        iUelAPI.onResponeBanner(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        iUelAPI.onFailure("error_UELapi");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("width", OwnLibrary.dpToPx(context,400) +"");
                params.put("height", OwnLibrary.dpToPx(context,200)+"");
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return params;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }


    public void downloadLanding(String urlString) {
        //Page page = Page.getInstance(context);
        ImageRequest stringRequest = new ImageRequest(urlString,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        //mImageView.setImageBitmap(bitmap);
                        iUelAPI.onResponeImage(bitmap);
                    }
                },0,0,null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        iUelAPI.onFailure("error_UELapi");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("width", OwnLibrary.dpToPx(context,400) +"");
                params.put("height", OwnLibrary.dpToPx(context,200)+"");
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return null;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    public void sendToGetLanding() {
        Page page = Page.getInstance(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,  page.getHome_landing(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                        iUelAPI.onResponeLanding(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        iUelAPI.onFailure("error_UELapi");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("width", OwnLibrary.dpToPx(context,400) +"");
                params.put("height", OwnLibrary.dpToPx(context,200)+"");
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return params;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
