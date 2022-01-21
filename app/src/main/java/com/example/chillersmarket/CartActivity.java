package com.example.chillersmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chillersmarket.Adapters.CartAdapter;
import com.example.chillersmarket.Adapters.MallAdapter;
import com.example.chillersmarket.RecyclewViewItems.CartItem;
import com.example.chillersmarket.RecyclewViewItems.MallItem;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    //Recycleview components
    private RecyclerView rvCartItems;
    private CartAdapter rvCartItemsAdapter;
    private RecyclerView.LayoutManager rvCartItemsLayoutManager;
    private ArrayList<CartItem> alCartItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCartItems = findViewById(R.id.recycleView);

        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));
        alCartItems.add(new CartItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "Floral upside down earrings", "Sold By : nondumisomkhatshwa", "R220.00",5));

        buildRecyclerView();


    }

    /**
     * Setup RecycleView display
     */
    private void buildRecyclerView() {
        rvCartItems.setHasFixedSize(true);
        rvCartItemsLayoutManager = new LinearLayoutManager(this);
        rvCartItemsAdapter = new CartAdapter(this, alCartItems);

        rvCartItems.setLayoutManager(rvCartItemsLayoutManager);
        rvCartItems.setAdapter(rvCartItemsAdapter);

        //Implementing item on click methods
        rvCartItemsAdapter.setOnItemClickListener(new CartAdapter.OnItemClickListener() {
            @Override
            public void onAddClick(int position) {
                alCartItems.get(position).setIntQuantity(alCartItems.get(position).getIntQuantity()+1);
                rvCartItemsAdapter.notifyItemChanged(position);
            }

            @Override
            public void onSubtractClick(int position) {
                alCartItems.get(position).setIntQuantity(alCartItems.get(position).getIntQuantity()-1);
                rvCartItemsAdapter.notifyItemChanged(position);
            }
        });
    }


    public void back(View view) {
        finish();
    }
}