package com.example.chillersmarket.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.CartItem;
import com.example.chillersmarket.RecyclewViewItems.MallItem;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<CartItem> alCartItems;

    private static Context context;

    private OnItemClickListener oiclListener;

    public interface OnItemClickListener {
        void onAddClick(int position);

        void onSubtractClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        oiclListener = listener;
    }


    public static class CartViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon, ivAdd, ivSubtract;
        private TextView tvName, tvSeller, tvPrice, tvQuantity;
        private RelativeLayout rlCheckout;

        public CartViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvName = itemView.findViewById(R.id.tvName);
            tvSeller = itemView.findViewById(R.id.tvSeller);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            ivAdd = itemView.findViewById(R.id.ivAdd);
            ivSubtract = itemView.findViewById(R.id.ivSubtract);
            rlCheckout = itemView.findViewById(R.id.rlCheckout);

            ivAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onAddClick(position);
                        }
                    }
                }
            });

            ivSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onSubtractClick(position);
                        }
                    }
                }
            });
        }
    }

    public CartAdapter(Context context, ArrayList<CartItem> cartItems) {
        this.context = context;
        this.alCartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        CartViewHolder mvh = new CartViewHolder(v, oiclListener);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem currentItem = alCartItems.get(position);

        Glide
                .with(context)
                .load(currentItem.getStrIcon())
                .centerCrop()
                .placeholder(R.drawable.ic_shopping_bag)
                .into(holder.ivIcon);
        holder.tvName.setText(currentItem.getStrName());
        holder.tvSeller.setText(currentItem.getStrSeller());
        holder.tvPrice.setText(currentItem.getStrPrice());
        holder.tvQuantity.setText(String.valueOf(currentItem.getIntQuantity()));

        if (position == alCartItems.size() - 1) {
            holder.rlCheckout.setVisibility(View.VISIBLE);
        } else {
            holder.rlCheckout.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return alCartItems.size();
    }
}
