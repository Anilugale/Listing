package com.androidworks.anil.listing.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidworks.anil.listing.MainActivity;
import com.androidworks.anil.listing.R;
import com.androidworks.anil.listing.fragment.AdDetails;
import com.androidworks.anil.listing.fragment.AdList;
import com.androidworks.anil.listing.model.Advertisment;
import com.androidworks.anil.listing.model.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
     Created by Anil on 16/10/2015.
 */
public class AdAdapter extends RecyclerView.Adapter<AdAdapter.ViewHolder> {

  private Activity context;
    private List<Advertisment>  catData;

    public AdAdapter(Activity context, List<Advertisment> catData) {
        this.context = context;
        this.catData = catData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =LayoutInflater.from(context).inflate(R.layout.advertisment_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(catData.get(position).getName());
        holder.price.setText(catData.get(position).getPrice());
        Picasso.with(context)
                .load(catData.get(position).getImageUrl())
                .error(R.mipmap.default_item)
                .into(holder.image);


        holder.cat_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAdList();
            }
        });
    }



    @Override
    public int getItemCount() {
        return catData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView name,price;
        protected ImageView image;
        protected CardView cat_item;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            price=(TextView)itemView.findViewById(R.id.price);
            name=(TextView)itemView.findViewById(R.id.name);
            image=(ImageView) itemView.findViewById(R.id.image);

            cat_item=(CardView) itemView.findViewById(R.id.cat_item);
        }
    }

    private void goToAdList() {
        FragmentManager fm =((MainActivity)context).getSupportFragmentManager();
        AdDetails fragment=(AdDetails) fm.findFragmentByTag(AdDetails.TAG);
        if(fragment==null)
        {
            fragment=AdDetails.newInstance();
        }

        fm.beginTransaction()
                .replace(R.id.frame,fragment)
                .addToBackStack(AdDetails.TAG)
                .commit();
    }
}
