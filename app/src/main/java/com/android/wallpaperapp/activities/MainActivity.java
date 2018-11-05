package com.android.wallpaperapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.wallpaperapp.R;
import com.android.wallpaperapp.adapter.MainCategoryDataAdapter;
import com.android.wallpaperapp.model.MainCategoryImagesModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String main_category_model_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    private final String android_image_urls[] = {
            "https://api.learn2crack.com/android/images/donut.png",
            "https://api.learn2crack.com/android/images/eclair.png",
            "https://api.learn2crack.com/android/images/froyo.png",
            "https://api.learn2crack.com/android/images/ginger.png",
            "https://api.learn2crack.com/android/images/honey.png",
            "https://api.learn2crack.com/android/images/icecream.png",
            "https://api.learn2crack.com/android/images/jellybean.png",
            "https://api.learn2crack.com/android/images/kitkat.png",
            "https://api.learn2crack.com/android/images/lollipop.png",
            "https://api.learn2crack.com/android/images/marshmallow.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.main_category_recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,1);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<MainCategoryImagesModel> mainCategoryModels = prepareData();
        MainCategoryDataAdapter adapter = new MainCategoryDataAdapter(MainActivity.this,mainCategoryModels);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<MainCategoryImagesModel> prepareData(){

        ArrayList<MainCategoryImagesModel> main_category_model = new ArrayList<>();
        for(int i=0;i<main_category_model_names.length;i++){
            MainCategoryImagesModel mainCategoryModel = new MainCategoryImagesModel();
            mainCategoryModel.setCategory_name(main_category_model_names[i]);
            mainCategoryModel.setCategory_image_url(android_image_urls[i]);
            main_category_model.add(mainCategoryModel);
        }
        return main_category_model;
    }
}
