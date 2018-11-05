package com.android.wallpaperapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.wallpaperapp.R;
import com.android.wallpaperapp.activities.FullScreenImageActivity;
import com.android.wallpaperapp.model.MainCategoryImagesModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sharma Ji on 18-Feb-18.
 */

public class CategoryImageAdapter extends RecyclerView.Adapter<CategoryImageAdapter.ViewHolder> {

    private ArrayList<MainCategoryImagesModel> categoryImagesModels;
    private Context context;

    public CategoryImageAdapter(Context context, ArrayList<MainCategoryImagesModel> categoryImages) {
        this.categoryImagesModels = categoryImages;
        this.context = context;
    }

    @Override
    public CategoryImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_images_recycler_item, parent, false);
        return new CategoryImageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryImageAdapter.ViewHolder holder, final int position) {
       // holder.tv_catrgory_name.setText(categoryImagesModels.get(position).getCategory_name());
        Picasso.with(context).load(categoryImagesModels.get(position).getCategory_image_url()).placeholder(R.drawable.loading_image).into(holder.all_images);
        holder.all_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,FullScreenImageActivity.class);
                intent.putExtra("imageurl",categoryImagesModels.get(position).getCategory_image_url());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryImagesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //private TextView tv_catrgory_name;
        private ImageView all_images;

        public ViewHolder(View view) {
            super(view);

           // tv_catrgory_name = (TextView) view.findViewById(R.id.txt_category_name);
            all_images = view.findViewById(R.id.all_images);
        }
    }
}
