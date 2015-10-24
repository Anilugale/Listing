package com.androidworks.anil.listing.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.androidworks.anil.listing.R;
import com.androidworks.anil.listing.adapter.AdAdapter;
import com.androidworks.anil.listing.adapter.CategoryAdapter;
import com.androidworks.anil.listing.model.Advertisment;
import com.androidworks.anil.listing.model.Category;
import com.androidworks.anil.listing.util.CommanMethod;

import java.util.ArrayList;
import java.util.List;

/**
 Created by Anil Ugale on 12/10/2015.
 */
public class AdList extends Fragment {

    public static String TAG="AdList";
    private static AdList landingPage;
    RecyclerView ad_list;


    public static AdList newInstance() {

        if(landingPage==null)
            landingPage=new AdList();
        return landingPage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.ad_list,container,false);
        init(view);
        return view;
    }

    private void init(View view) {
        ad_list=(RecyclerView)view.findViewById(R.id.ad_list);
        ad_list.setLayoutManager(new GridLayoutManager(getContext(),2));

        List<Advertisment> data=new ArrayList<>();

        for(int i=0;i<100;i++)
        {
            Advertisment advertisment=new Advertisment();
            advertisment.setName("Item Name"+i);
            advertisment.setPrice("₹ :"+((int)Math.random()*100)+"");
            advertisment.setImageUrl("http://images.indianexpress.com/2015/09/googlenexus5x_big2.jpg");
            data.add(advertisment);
        }

        AdAdapter adapter=new AdAdapter(getActivity(),data);
        ad_list.setAdapter(adapter);


    }




}
