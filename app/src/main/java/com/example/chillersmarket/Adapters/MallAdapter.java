package com.example.chillersmarket.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.MallItem;

import java.util.ArrayList;

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.MallViewHolder> {

    private ArrayList<MallItem> alMallItems;

    private Context context;

    public static class MallViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivPreview;
        public TextView tvPrice, tvHeading, tvSeller;

        public MallViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPreview = itemView.findViewById(R.id.ivPreview);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvHeading = itemView.findViewById(R.id.tvHeading);
            tvSeller = itemView.findViewById(R.id.tvSeller);
        }
    }

    public MallAdapter(Context context, ArrayList<MallItem> mallItems) {
        this.context = context;
        alMallItems = mallItems;
    }

    @NonNull
    @Override
    public MallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mall_item, parent, false);
        MallViewHolder mvh = new MallViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MallViewHolder holder, int position) {
        MallItem currentItem = alMallItems.get(position);

        Glide
            .with(context)
            .load(currentItem.getStrPreview())
            .centerCrop()
            .placeholder(R.drawable.ic_mall_24)
            .into(holder.ivPreview);

        holder.tvPrice.setText(currentItem.getStrPrice());
        holder.tvHeading.setText(currentItem.getStrHeading());
        holder.tvSeller.setText(currentItem.getStrSeller());

    }

    @Override
    public int getItemCount() {
        return alMallItems.size();
    }
}