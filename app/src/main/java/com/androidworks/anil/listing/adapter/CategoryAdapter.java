package com.androidworks.anil.listing.adapter;

import android.app.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidworks.anil.listing.MainActivity;
import com.androidworks.anil.listing.R;
import com.androidworks.anil.listing.fragment.AdList;
import com.androidworks.anil.listing.model.Category;

import java.util.List;

/**
     Created by Anil on 16/10/2015.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

  private Activity context;
    private List<Category>  catData;

    public CategoryAdapter(Activity context, List<Category> catData) {
        this.context = context;
        this.catData = catData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(catData.get(position).getName());
        holder.cat_item.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              goToAdList();
            }
        });
    }

    private void goToAdList() {
        FragmentManager fm =((MainActivity)context).getSupportFragmentManager();
        AdList fragment=(AdList) fm.findFragmentByTag(AdList.TAG);
        if(fragment==null)
        {
            fragment=AdList.newInstance();
        }

        fm.beginTransaction()
                .replace(R.id.frame,fragment)
                .addToBackStack(AdList.TAG)
                .commit();
    }

    @Override
    public int getItemCount() {
        return catData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        CardView cat_item;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            cat_item=(CardView) itemView.findViewById(R.id.cat_item);
        }
    }
}
