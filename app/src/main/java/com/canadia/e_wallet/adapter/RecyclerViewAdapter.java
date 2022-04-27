package com.canadia.e_wallet.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.canadia.e_wallet.MainActivity;
import com.canadia.e_wallet.R;
import com.canadia.e_wallet.models.notificationModel;
import com.canadia.e_wallet.views.TransactionDetailActivity;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private ArrayList<notificationModel> data;
    public Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle, date,status;
        public ImageView payment_image;
        public Chip status_color;
        RelativeLayout detail_info;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.txtTitle);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
            payment_image = itemView.findViewById(R.id.payment_img);
            detail_info = itemView.findViewById(R.id.relativeLayout);
            status_color = itemView.findViewById(R.id.status);

        }
    }

    public RecyclerViewAdapter(ArrayList<notificationModel> data,Context context) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
         RelativeLayout detail_info;
        notificationModel model = data.get(position);
        holder.mTitle.setText(data.get(position).getTitle());
        holder.date.setText(data.get(position).getDate());
        holder.status.setText(data.get(position).getChip());
//        holder.status_color.setChipBackgroundColorResource(data.get(position).getStatus_color());
        holder.payment_image.setImageResource(data.get(position).getPayment_image());
                holder.detail_info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TransactionDetailActivity.class);
                intent.putExtra("title",data.get(position).getTitle());
                intent.putExtra("date",data.get(position).getDate());
                intent.putExtra("image",data.get(position).getPayment_image());
                intent.putExtra("status",data.get(position).getChip());
//                intent.putExtra("color",data.get(position).getStatus_color());
                context.startActivity(intent);
            }
        });
        switch (data.get(position).getStatus_color()) {
            case 0:
                holder.status_color.setChipBackgroundColorResource(R.color.status_1);
                holder.status.setTextColor(R.color.white);
                break;
            case 1:
                holder.status_color.setChipBackgroundColorResource(R.color.status_2);
                holder.status.setTextColor(R.color.white);
                break;
            default:
                holder.status_color.setChipBackgroundColorResource(R.color.status_3);
                holder.status.setTextColor(R.color.white);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void removeItem(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(notificationModel item, int position) {
        data.add(position, item);
        notifyItemInserted(position);
    }

    public ArrayList<notificationModel> getData() {
        return data;
    }
}
