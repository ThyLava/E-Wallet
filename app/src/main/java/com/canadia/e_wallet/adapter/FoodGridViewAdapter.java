package com.canadia.e_wallet.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.canadia.e_wallet.R;
import com.canadia.e_wallet.models.FoodModel;
import com.canadia.e_wallet.models.PayModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class FoodGridViewAdapter extends ArrayAdapter<FoodModel> {
    public FoodGridViewAdapter(@NonNull Context context, ArrayList<FoodModel> foodModelArrayList) {
        super(context, 0, foodModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View list_food_view = convertView;
        if (list_food_view == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            list_food_view = LayoutInflater.from(getContext()).inflate(R.layout.foods, parent, false);
        }
        FoodModel foodModel = getItem(position);
        TextView name = list_food_view.findViewById(R.id.food_name);
        ImageView image = list_food_view.findViewById(R.id.food_img);
        TextView price = list_food_view.findViewById(R.id.food_price);

        name.setText(foodModel.getFood_name());
        price.setText(foodModel.getFood_price());
        Glide.with(getContext())
                .load(foodModel.getFood_image())
                .into(image);
//        image.setImageBitmap(foodModel.getFood_image());


        return list_food_view;

    }
}
