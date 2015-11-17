package com.androidworks.anil.listing.util;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.androidworks.anil.listing.AppController;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
   Created by anil on 26/08/2015.
 */
public class NetworkRequest {


    public static String TAG="NW";
    public static String RESULT="result";
    public static Gson gson=new Gson();



    public static void  SimpleJsonRequest(final Context context,
                                          JSONObject jsonRequest,
                                          String url,
                                          final JsonCallBack responce,
                                          final int responseCode,
                                          int method
    )
    {
        String tag_json_obj = "json_obj_req";
         JsonObjectRequest jsonObjReq = new JsonObjectRequest(method,
                url ,
                jsonRequest.toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.e(TAG, response.toString());


                                responce.success(response,responseCode);



                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e(TAG, "Error: " + error.getMessage());
                responce.failer(error, responseCode);

            }
        }) ;
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }
}
