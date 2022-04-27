package com.canadia.e_wallet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.models.PayModel;

import java.util.ArrayList;

public class PayGridViewAdapter extends ArrayAdapter<PayModel> {

    public PayGridViewAdapter(@NonNull Context context, ArrayList<PayModel> payModelArrayList) {
        super(context, 0, payModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View list_pay_view = convertView;
        if (list_pay_view == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            list_pay_view = LayoutInflater.from(getContext()).inflate(R.layout.grid_pay, parent, false);
        }
        PayModel payModel = getItem(position);
        TextView name = list_pay_view.findViewById(R.id.pay_name);
        ImageView image = list_pay_view.findViewById(R.id.pay_img);
        name.setText(payModel.getPay_name());
        image.setImageResource(payModel.getPay_image());
        return list_pay_view;

    }
}
