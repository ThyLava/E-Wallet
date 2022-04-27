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
import com.canadia.e_wallet.models.BankModel;

import java.util.ArrayList;

public class BankGridViewAdapter  extends  ArrayAdapter<BankModel>  {
    public BankGridViewAdapter(@NonNull Context context, ArrayList<BankModel> bankModelArrayList) {
        super(context, 0, bankModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View list_bank_view = convertView;
        if (list_bank_view == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            list_bank_view = LayoutInflater.from(getContext()).inflate(R.layout.card_item_bank, parent, false);
        }
        BankModel bankModel = getItem(position);
        TextView name = list_bank_view.findViewById(R.id.bank_name);
        ImageView image = list_bank_view.findViewById(R.id.bank_img);
        name.setText(bankModel.getBank_name());
        image.setImageResource(bankModel.getBank_image());
        return list_bank_view;
    }
}
