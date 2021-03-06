package com.ungdunguel.appcbdoan.data.remote;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import com.ungdunguel.appcbdoan.model.Page;
import com.ungdunguel.appcbdoan.util.OwnLib;
import com.ungdunguel.appcbdoan.util.StringConf;

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
                        iUelAPI.onResponseWordData(response);
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
                        iUelAPI.onResponseGroupData(response);
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
                        iUelAPI.onResponseNewsData(response);
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
                        iUelAPI.onResponseImage(bitmap);
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
                params.put("width", OwnLib.dpToPx(context,400) +"");
                params.put("height", OwnLib.dpToPx(context,200)+"");
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
                        iUelAPI.onResponseBanner(response);
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
                params.put("width", OwnLib.dpToPx(context,400) +"");
                params.put("height", OwnLib.dpToPx(context,200)+"");
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return params;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }


    public void downloadLanding(String urlString) {
        //Page page = Page.getInstance(context);
        if(urlString == StringConf.DEF_Landing_Link)
        {
            iUelAPI.onFailure("Link Not Existed");
            return;
        }

        ImageRequest stringRequest = new ImageRequest(urlString,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        //mImageView.setImageBitmap(bitmap);
                        iUelAPI.onResponseImage(bitmap);
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
                params.put("width", OwnLib.dpToPx(context,400) +"");
                params.put("height", OwnLib.dpToPx(context,200)+"");
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
                        iUelAPI.onResponseLanding(response);
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
                params.put("width", OwnLib.dpToPx(context,400) +"");
                params.put("height", OwnLib.dpToPx(context,200)+"");
                //params.put(ParallelDotsKey.text_2,text_2);
                //params.put(ParallelDotsKey.api_key, ParallelDotsKey.api_key_value);
                return params;
            }

        };


        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
