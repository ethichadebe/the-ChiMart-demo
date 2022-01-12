package com.example.chillersmarket.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.MallItem;
import com.example.chillersmarket.RecyclewViewItems.ReviewItem;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private ArrayList<ReviewItem> alReviewItems;

    private Context context;

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivIcon;
        public TextView tvName, tvDate, tvReview;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);

            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvName = itemView.findViewById(R.id.tvName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvReview = itemView.findViewById(R.id.tvReview);
        }
    }

    public ReviewAdapter(ArrayList<ReviewItem> ReviewItems, Context context) {
        alReviewItems = ReviewItems;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item, parent, false);
        ReviewViewHolder mvh = new ReviewViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        ReviewItem currentItem = alReviewItems.get(position);

        /*  Glide
            .with(context)
            .load(currentItem.getStrIcon())
            .centerCrop()
            .placeholder(R.drawable.ic_shopping_bag)
            .into(holder.ivIcon);*/

        holder.tvName.setText(currentItem.getStrName());
        holder.tvDate.setText(currentItem.getStrDate());
        holder.tvReview.setText(currentItem.getStrReview());

    }

    @Override
    public int getItemCount() {
        return alReviewItems.size();
    }
}
