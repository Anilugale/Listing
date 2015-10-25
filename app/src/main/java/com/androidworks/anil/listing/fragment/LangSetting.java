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
public class LangSetting extends Fragment {

    public static String TAG="LangSetting";
    private static LangSetting landingPage;


    public static LangSetting newInstance() {

        if(landingPage==null)
            landingPage=new LangSetting();
        return landingPage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.language_setting,container,false);
        init(view);
        return view;
    }

    private void init(View view) {

    }




}
