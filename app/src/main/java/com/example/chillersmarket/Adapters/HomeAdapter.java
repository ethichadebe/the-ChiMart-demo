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

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<HomeItem> homeItems;
    private Context context;

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivRetail;
        public TextView tvRetail;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRetail = itemView.findViewById(R.id.tvRetail);
            ivRetail = itemView.findViewById(R.id.ivRetail);
        }
    }

    public HomeAdapter(Context context, ArrayList<HomeItem> homeItems) {
        this.context = context;
        this.homeItems = homeItems;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        HomeViewHolder homeViewHolder = new HomeViewHolder(view);

        return homeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HomeItem currentHomeItem = homeItems.get(position);

        Glide.with(context).load(currentHomeItem.getStrRetail())
                .centerCrop().placeholder(currentHomeItem.getIcon())
                .into(holder.ivRetail);

        holder.tvRetail.setText(currentHomeItem.getStrRetail());
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

}
