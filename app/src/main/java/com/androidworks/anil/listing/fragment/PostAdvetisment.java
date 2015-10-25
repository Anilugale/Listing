package com.androidworks.anil.listing.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidworks.anil.listing.MainActivity;
import com.androidworks.anil.listing.R;

/**
 Created by Anil Ugale on 12/10/2015.
 */
public class PostAdvetisment extends Fragment implements View.OnClickListener{

    public static String TAG="PostAdvetisment";
    private static PostAdvetisment landingPage;
    FragmentManager fm ;

    public static PostAdvetisment newInstance() {

        if(landingPage==null)
            landingPage=new PostAdvetisment();
        return landingPage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.profile,container,false);
        init(view);
        return view;
    }

    private void init(View view) {
        fm =((MainActivity)getActivity()).getSupportFragmentManager();
    }


    @Override
    public void onClick(View v) {


    }


}
