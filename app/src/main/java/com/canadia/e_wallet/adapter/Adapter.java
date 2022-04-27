package com.canadia.e_wallet.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.models.Model;
import com.canadia.e_wallet.views.PaymentInformationActivity;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyAdapter> {
    Context context;
    List<Model> list;
    int size;

    public Adapter(Context context, List<Model> list, int size) {
        this.context = context;
        this.list = list;
        this.size = size;
    }

    @NonNull
    @Override
    public Adapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bank_payment, parent, false);
        return new MyAdapter(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyAdapter holder, @SuppressLint("RecyclerView") int position) {
        CardView choosing_bank;
        String Key, Value;
        Model model = list.get(position);
        holder.logo.setImageResource(model.getBank_image());
        holder.name.setText(model.getBank_name());
        holder.desc.setText(model.getBank_desc());
        holder.choosing_bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PaymentInformationActivity.class);
                intent.putExtra("logo",list.get(position).getBank_image());
                intent.putExtra("name",list.get(position).getBank_name());
                intent.putExtra("desc",list.get(position).getBank_desc());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        CardView choosing_bank;
        ImageView logo;
        TextView name, desc;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.img_bank);
            name = itemView.findViewById(R.id.bank_name);
            desc = itemView.findViewById(R.id.desc_bank);
            choosing_bank= itemView.findViewById(R.id.choosing_bank);
        }
    }
}