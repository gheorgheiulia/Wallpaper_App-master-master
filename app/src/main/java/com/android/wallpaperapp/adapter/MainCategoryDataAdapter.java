package com.android.wallpaperapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wallpaperapp.R;
import com.android.wallpaperapp.activities.AllImageActivity;
import com.android.wallpaperapp.model.MainCategoryImagesModel;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sharma Ji on 18-Feb-18.
 */

public class MainCategoryDataAdapter extends RecyclerView.Adapter<MainCategoryDataAdapter.ViewHolder> {

    private ArrayList<MainCategoryImagesModel> categoryImagesModels;
    private Context context;
    private InterstitialAd interstitial;
    public MainCategoryDataAdapter(Context context, ArrayList<MainCategoryImagesModel> categoryImages) {
        this.categoryImagesModels = categoryImages;
        this.context = context;
    }

    @Override
    public MainCategoryDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_category_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainCategoryDataAdapter.ViewHolder holder, final int position) {
        holder.tv_catrgory_name.setText(categoryImagesModels.get(position).getCategory_name());
        Picasso.with(context).load(categoryImagesModels.get(position).getCategory_image_url()).placeholder(R.drawable.loading_image).into(holder.img_category_image);
        holder.img_category_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdRequest adRequest = new AdRequest.Builder().build();
                interstitial = new InterstitialAd(context);
                // Insert the Ad Unit ID
                interstitial.setAdUnitId(context.getString(R.string.admob_interstitial_id));
                interstitial.loadAd(adRequest);
                // Prepare an Interstitial Ad Listener
                interstitial.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                        // Call displayInterstitial() function
                        displayInterstitial();
                    }
                });
                Intent intent=new Intent(context,AllImageActivity.class);
                intent.putExtra("category",categoryImagesModels.get(position).getCategory_name());
                context.startActivity(intent);
            }
        });

    }

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
    @Override
    public int getItemCount() {
        return categoryImagesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_catrgory_name;
        private ImageView img_category_image;

        public ViewHolder(View view) {
            super(view);

            tv_catrgory_name = view.findViewById(R.id.txt_category_name);
            img_category_image = view.findViewById(R.id.img_categoryimage);
        }
    }
}
