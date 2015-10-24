package com.androidworks.anil.listing.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidworks.anil.listing.R;

/**
 Created by Anil Ugale on 12/10/2015.
 */
public class Profile extends Fragment {

    public static String TAG="Profile";
    private static Profile landingPage;


    public static Profile newInstance() {

        if(landingPage==null)
            landingPage=new Profile();
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

    }




}
