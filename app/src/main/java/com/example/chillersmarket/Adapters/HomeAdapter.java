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
    private static Context context;

    public static Context getContext() {
        return context;
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position, Context context);
        void onAddToCartClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivRetail;
        public TextView tvRetail;

        public HomeViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            tvRetail = itemView.findViewById(R.id.tvRetail);
            ivRetail = itemView.findViewById(R.id.ivRetail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAbsoluteAdapterPosition();

                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position, getContext());
                        }
                    }
                }
            });
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
        HomeViewHolder homeViewHolder = new HomeViewHolder(view, onItemClickListener);

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
