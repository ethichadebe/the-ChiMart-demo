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
import com.example.chillersmarket.RecyclewViewItems.HomeItem;

import java.util.ArrayList;

public class PopularCategoryAdapter extends RecyclerView.Adapter<PopularCategoryAdapter.PopularCategoryViewHolder> {

    private ArrayList<HomeItem> homeItems;
    private static Context context;

    public static Context getContext() {
        return context;
    }

    private OnItemClickListener onClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position, Context context);

        void onAddToCartClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onClickListener = listener;
    }

    public static class PopularCategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivPopularCategory;
        public TextView tvPopularCategory;

        public PopularCategoryViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            tvPopularCategory = itemView.findViewById(R.id.tvPopularCategory);
            ivPopularCategory = itemView.findViewById(R.id.ivPopularCategory);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position, getContext());
                        }
                    }
                }
            });
        }
    }

    public PopularCategoryAdapter(Context context, ArrayList<HomeItem> homeItems) {
        this.context = context;
        this.homeItems = homeItems;
    }

    @NonNull
    @Override
    public PopularCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_category_item, parent, false);
        PopularCategoryViewHolder popularCategoryViewHolder = new PopularCategoryViewHolder(view, onClickListener);
        return popularCategoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularCategoryViewHolder holder, int position) {
        HomeItem currentHomeItem = homeItems.get(position);

        Glide.with(context).load(currentHomeItem.getStrRetail())
                .centerCrop().placeholder(currentHomeItem.getIcon())
                .into(holder.ivPopularCategory);
        holder.tvPopularCategory.setText(currentHomeItem.getStrRetail());
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

}
