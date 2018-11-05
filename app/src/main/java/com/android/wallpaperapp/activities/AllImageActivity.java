package com.android.wallpaperapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.wallpaperapp.R;
import com.android.wallpaperapp.adapter.CategoryImageAdapter;
import com.android.wallpaperapp.model.MainCategoryImagesModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class AllImageActivity extends AppCompatActivity {

   private String[] android_image_urls = {
            "https://i.postimg.cc/PxQZW3hp/Animals.jpg",
            "https://i.postimg.cc/9fVQdWfb/Cartoons.jpg",
            "https://i.postimg.cc/qBYBmcRz/Food.jpg",
            "https://i.postimg.cc/XJq3LX6f/Love.jpg",
            "https://i.postimg.cc/m2CcCpwb/Sea.jpg",
            "https://i.postimg.cc/P5MPFL99/Sky.jpg",
            "https://i.postimg.cc/WbNLbrkS/C1.jpg",
            "https://i.postimg.cc/BQQkG0rV/N2.jpg",
            "https://i.postimg.cc/NF04ZgK8/D1.jpg",
           "https://i.postimg.cc/PfFJgs6f/Car.jpg",
            "https://i.postimg.cc/yYZ9xgCg/D5.jpg",
           "https://i.postimg.cc/7Y81gMVM/C6.jpg"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_image);
        initViews();
    }
    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView_allimages);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(AllImageActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<MainCategoryImagesModel> mainCategoryModels = prepareData();
        CategoryImageAdapter adapter = new CategoryImageAdapter(AllImageActivity.this, mainCategoryModels);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<MainCategoryImagesModel> prepareData() {

        ArrayList<MainCategoryImagesModel> main_category_model = new ArrayList<>();

        Collections.shuffle(Arrays.asList(android_image_urls));
        for(String str: android_image_urls){
            Log.e("Array List", str);
            MainCategoryImagesModel mainCategoryModel = new MainCategoryImagesModel();
            mainCategoryModel.setCategory_image_url(str);
            main_category_model.add(mainCategoryModel);
        }
        return main_category_model;
    }

}
