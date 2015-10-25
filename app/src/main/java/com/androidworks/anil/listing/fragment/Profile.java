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
public class Profile extends Fragment implements View.OnClickListener{

    public static String TAG="Profile";
    private static Profile landingPage;
    FragmentManager fm ;

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
        fm =((MainActivity)getActivity()).getSupportFragmentManager();
        view.findViewById(R.id.post_ad).setOnClickListener(this);
        view.findViewById(R.id.lang_setting).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.lang_setting:
                gotoFragment(1);
                break;
            case R.id.post_ad:

                gotoFragment(2);
                break;




        }
    }

    private void gotoFragment(int fragmentName) {
        Fragment fragment;
        switch(fragmentName)
        {

            case 1:
                 fragment= (LangSetting)fm.findFragmentByTag(LangSetting.TAG);
                if (fragment==null) {
                    fragment=LangSetting.newInstance();
                }
                fm.beginTransaction()
                        .replace(R.id.frame,fragment)
                        .addToBackStack(LangSetting.TAG)
                        .commit();
                break;
            case 2:
                 fragment= (PostAdvetisment)fm.findFragmentByTag(PostAdvetisment.TAG);
                if (fragment==null) {
                    fragment=PostAdvetisment.newInstance();
                }
                fm.beginTransaction()
                        .replace(R.id.frame,fragment)
                        .addToBackStack(PostAdvetisment.TAG)
                        .commit();
                break;

        }




    }
}
