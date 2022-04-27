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
import com.canadia.e_wallet.models.BillModel;

import java.util.ArrayList;

public class BillGridViewAdapter extends ArrayAdapter<BillModel> {
    public BillGridViewAdapter(@NonNull Context context, ArrayList<BillModel> billModelArrayList) {
        super(context, 0, billModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View list_bill_view = convertView;
        if (list_bill_view == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            list_bill_view = LayoutInflater.from(getContext()).inflate(R.layout.grid_bill, parent, false);
        }
        BillModel billModel = getItem(position);
        TextView name = list_bill_view.findViewById(R.id.bill_name);
        ImageView image = list_bill_view.findViewById(R.id.bill_img);
        name.setText(billModel.getBill_name());
        image.setImageResource(billModel.getBill_image());
        return list_bill_view;
    }
}

