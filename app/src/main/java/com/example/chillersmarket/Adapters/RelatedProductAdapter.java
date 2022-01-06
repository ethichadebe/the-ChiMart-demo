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

import java.util.ArrayList;

public class RelatedProductAdapter extends RecyclerView.Adapter<RelatedProductAdapter.RelatedProductViewHolder> {

    private ArrayList<MallItem> alRelatedProductItems;

    private static Context context;

    public static Context getContext() {
        return context;
    }

    private OnItemClickListener oiclListener;

    public interface OnItemClickListener {
        void onItemClick(int position, Context context);

        void onAddToCartClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        oiclListener = listener;
    }


    public static class RelatedProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivPreview;
        public CardView cvAddToCart;
        public TextView tvPrice, tvHeading, tvSeller;

        public RelatedProductViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            ivPreview = itemView.findViewById(R.id.ivPreview);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvHeading = itemView.findViewById(R.id.tvHeading);
            tvSeller = itemView.findViewById(R.id.tvSeller);
            cvAddToCart = itemView.findViewById(R.id.cvAddToCart);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position, getContext());
                        }
                    }
                }
            });

            cvAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onAddToCartClick(position);
                        }
                    }
                }
            });
        }
    }

    public RelatedProductAdapter(Context context, ArrayList<MallItem> mallItems) {
        this.context = context;
        alRelatedProductItems = mallItems;
    }

    @NonNull
    @Override
    public RelatedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.related_product_item, parent, false);
        RelatedProductViewHolder mvh = new RelatedProductViewHolder(v, oiclListener);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedProductViewHolder holder, int position) {
        MallItem currentItem = alRelatedProductItems.get(position);

        Glide
                .with(context)
                .load(currentItem.getStrPreview())
                .centerCrop()
                .placeholder(R.drawable.ic_shopping_bag)
                .into(holder.ivPreview);

        holder.tvPrice.setText(currentItem.getStrPrice());
        holder.tvHeading.setText(currentItem.getStrHeading());
        holder.tvSeller.setText(currentItem.getStrSeller());

    }

    @Override
    public int getItemCount() {
        return alRelatedProductItems.size();
    }
}
