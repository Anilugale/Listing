package com.androidworks.anil.listing.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidworks.anil.listing.R;
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
    }

    @Override
    public int getItemCount() {
        return catData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
        }
    }
}
