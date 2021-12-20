package com.example.chillersmarket.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.ListingItem;

import java.util.ArrayList;

import info.androidhive.fontawesome.FontTextView;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListingViewHolder> {

    private ArrayList<ListingItem> alListingItems;

    private Context context;

    public static class ListingViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivPreview;
        public TextView tvBusinessName, tvShrtDescript, tvLocation,tvNumber,tvCategory,tvStatus;
        public FontTextView ftvCategory,ftvLocation;

        public ListingViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPreview = itemView.findViewById(R.id.ivPreview);
            tvBusinessName = itemView.findViewById(R.id.tvBusinessName);
            tvShrtDescript = itemView.findViewById(R.id.tvShrtDescript);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvStatus = itemView.findViewById(R.id.tvStatus);

            ftvCategory = itemView.findViewById(R.id.ftvCategory);
            ftvLocation = itemView.findViewById(R.id.ftvLocation);
        }
    }

    public ListingAdapter(Context context, ArrayList<ListingItem> listingItems) {
        this.context = context;
        alListingItems = listingItems;
    }

    @NonNull
    @Override
    public ListingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_item, parent, false);
        ListingViewHolder mvh = new ListingViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListingViewHolder holder, int position) {
        ListingItem currentItem = alListingItems.get(position);

        Glide
            .with(context)
            .load(currentItem.getStrPreview())
            .centerCrop()
            .placeholder(R.drawable.ic_mall_24)
            .into(holder.ivPreview);

        holder.tvBusinessName.setText(currentItem.getStrBusinessName());
        holder.tvShrtDescript.setText(currentItem.getStrShrtDescript());

        if (currentItem.getStrLocation().isEmpty()){
            holder.ftvLocation.setVisibility(View.GONE);
        }else {
            holder.ftvLocation.setVisibility(View.VISIBLE);
            holder.tvLocation.setText(currentItem.getStrLocation());
        }

        holder.tvNumber.setText(currentItem.getStrNumber());
        holder.tvCategory.setText(currentItem.getStrCategory());
        if (currentItem.getStrStatus().equals("Open")){
            holder.tvStatus.setText(currentItem.getStrStatus());
            holder.tvStatus.setTextColor(Color.parseColor("#000000"));
        }else {
            holder.tvStatus.setText(currentItem.getStrStatus());
            holder.tvStatus.setTextColor(Color.parseColor("#FFFF0000"));

        }

    }

    @Override
    public int getItemCount() {
        return alListingItems.size();
    }
}
