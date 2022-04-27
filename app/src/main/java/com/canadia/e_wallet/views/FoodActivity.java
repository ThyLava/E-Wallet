package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.adapter.BankGridViewAdapter;
import com.canadia.e_wallet.adapter.FoodGridViewAdapter;
import com.canadia.e_wallet.adapter.SliderAdapter;
import com.canadia.e_wallet.helper.SliderItems;
import com.canadia.e_wallet.models.BankModel;
import com.canadia.e_wallet.models.FoodModel;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    GridView foods;
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_food);

        foods = findViewById(R.id.grid_food);
        ArrayList<FoodModel> foodModelArrayList = new ArrayList<FoodModel>();
        foodModelArrayList.add(new FoodModel("Chicken Pop", "$ 2.75", "https://images.unsplash.com/photo-1583524505974-6facd53f4597?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE0fHx8ZW58MHx8fHw%3D&w=1000&q=80"));
        foodModelArrayList.add(new FoodModel("Chicken Pop", "$ 3.75", "https://onlinejpgtools.com/images/examples-onlinejpgtools/coffee-resized.jpg"));
        foodModelArrayList.add(new FoodModel("Test Pop", "$ 2.75", "https://static.onecms.io/wp-content/uploads/sites/44/2019/08/26232300/6318283.jpg"));
        foodModelArrayList.add(new FoodModel("Chicken Pop", "$ 2.00", "https://static.onecms.io/wp-content/uploads/sites/44/2019/08/26232300/6318283.jpg"));
        foodModelArrayList.add(new FoodModel("babe Pop", "$ 2.75", "https://static.onecms.io/wp-content/uploads/sites/44/2019/08/26232300/6318283.jpg"));
        foodModelArrayList.add(new FoodModel("Chicken Pop", "$ 2.75", "https://static.onecms.io/wp-content/uploads/sites/44/2019/08/26232300/6318283.jpg"));


        FoodGridViewAdapter adapter = new FoodGridViewAdapter(this, foodModelArrayList);
        foods.setAdapter(adapter);


        ImageSlider imageSlider = findViewById(R.id.food_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://st.depositphotos.com/1005682/2476/i/600/depositphotos_24762569-stock-photo-fast-food-hamburger-hot-dog.jpg"));
        slideModels.add(new SlideModel("https://www.qsrmagazine.com/sites/default/files/styles/slideshow_image/public/slideshow-images/slides/mcdonaldsglobal.jpg?itok=Q5EUIKFj"));
        slideModels.add(new SlideModel("https://media.istockphoto.com/photos/selection-of-american-food-picture-id931308812?k=20&m=931308812&s=612x612&w=0&h=Tudia4RSCvfpWZhli0ehScrzeCtbwvTqB9BZaCta_qA="));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/750073/pexels-photo-750073.jpeg?cs=srgb&dl=pexels-dana-tentis-750073.jpg&fm=jpg"));
        slideModels.add(new SlideModel("https://media.istockphoto.com/photos/cheeseburger-with-cola-and-french-fries-picture-id1154731746?b=1&k=20&m=1154731746&s=170667a&w=0&h=2X069IQ0aNtftDKI3X4lq-DHdCvxBv_y6V_lcGbJVkE="));
        imageSlider.setImageList(slideModels, true);

    }
}