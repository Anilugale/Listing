package com.androidworks.anil.listing.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.androidworks.anil.listing.MainActivity;
import com.androidworks.anil.listing.R;
import com.androidworks.anil.listing.util.CommanMethod;
import com.androidworks.anil.listing.util.JsonCallBack;
import com.androidworks.anil.listing.util.NetworkRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 Created by Anil Ugale on 12/10/2015.
 */
public class Regisration extends Fragment implements View.OnClickListener, JsonCallBack{

    public static String TAG="Regisration";
    private static Regisration landingPage;
    private ProgressDialog progressDialog;
    EditText fist_name,last_name,email,password;


    public static Regisration newInstance() {

        if(landingPage==null)
            landingPage=new Regisration();
        return landingPage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.regisration,container,false);
        init(view);
        return view;
    }

    private void init(View view) {

        view.findViewById(R.id.submit).setOnClickListener(this);

        fist_name=(EditText)view.findViewById(R.id.fist_name_ed);
        last_name=(EditText)view.findViewById(R.id.last_name_ed);
        email=(EditText)view.findViewById(R.id.email_ed);
        password=(EditText)view.findViewById(R.id.password_ed);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.submit:
                validAndRegistration();
                break;


        }
    }



    private void validAndRegistration() {

        try {
            JSONObject request=new JSONObject();
            request.put("first_name",fist_name.getText().toString().trim());
            request.put("last_name",last_name.getText().toString().trim());
            request.put("email",email.getText().toString().trim());
            // Sending side
            byte[] data = password.getText().toString().trim().getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);

            request.put("password",base64);

            Log.e("request",request.toString());

            NetworkRequest.SimpleJsonRequest(getActivity(),
                    request,
                    CommanMethod.Register,
                    this,
                    2020,
                    Request.Method.POST);

            progressDialog=ProgressDialog.show(getActivity(),"","Loading....",true,false);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void success(JSONObject response, int responseCode) {
        System.out.println(response);
        try {
            if(response.getInt(CommanMethod.Tag_Result)==1)
                Toast.makeText(getActivity(), response.getString(CommanMethod.Tag_Message), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        progressDialog.dismiss();

    }

    @Override
    public void failer(VolleyError response, int responseCode) {
        System.out.println(response);
        progressDialog.dismiss();
    }
}
