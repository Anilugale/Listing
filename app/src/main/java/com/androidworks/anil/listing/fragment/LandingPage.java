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
import com.androidworks.anil.listing.adapter.CategoryAdapter;
import com.androidworks.anil.listing.model.Category;
import com.androidworks.anil.listing.util.CommanMethod;

import java.util.ArrayList;
import java.util.List;

/**
 Created by Anil Ugale on 12/10/2015.
 */
public class LandingPage extends Fragment {

    public static String TAG="LandingPage";
    private static LandingPage landingPage;
    Spinner city;
    private RecyclerView category;

    public static LandingPage newInstance() {

        if(landingPage==null)
            landingPage=new LandingPage();
        return landingPage;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_landing,container,false);
        init(view);
        return view;

    }

    private void init(View view) {

        city=(Spinner) view.findViewById(R.id.city);
        category=(RecyclerView) view.findViewById(R.id.category);

        setCity();

       //quicker
       setCategory();


    }

    private void setCity() {

        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, CommanMethod.city);
        city.setAdapter(monthAdapter);
    }

    private void setCategory() {
        category.setLayoutManager(new GridLayoutManager(getActivity(),2));
        List<Category> categoryList=new ArrayList<>();

        for(String name:CommanMethod.category)
        {
            Category cat=new Category();
            cat.setName(name);
            categoryList.add(cat);
        }

        CategoryAdapter adapter=new CategoryAdapter(getActivity(),categoryList);
        category.setAdapter(adapter);


    }


}
