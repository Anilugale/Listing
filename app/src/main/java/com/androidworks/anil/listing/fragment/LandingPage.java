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
public class LandingPage extends Fragment {

    public static String TAG="LandingPage";
    private static LandingPage landingPage;

    public static LandingPage newInstance() {


        if(landingPage==null)
            landingPage=new LandingPage();
        return landingPage;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_landing,container,false);

        return view;

    }


}
