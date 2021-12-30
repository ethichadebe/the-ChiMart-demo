package com.example.chillersmarket;

import static com.example.chillersmarket.fragments.ChillersMallFragment.ITEM_HEADING;
import static com.example.chillersmarket.fragments.ChillersMallFragment.ITEM_PREVIEW;
import static com.example.chillersmarket.fragments.ChillersMallFragment.ITEM_PRICE;
import static com.example.chillersmarket.fragments.ChillersMallFragment.ITEM_SELLER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailedMallItemActivity extends AppCompatActivity {

    private TextView tvHeadingTop, tvPrice, tvHeading, tvSeller, tvAddToCart, tvCart;
    private ImageView ivPreview;

    private int nItems = 0;                                                                             //Demo variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_mall_item);

        tvHeadingTop = findViewById(R.id.tvHeadingTop);                                             //Item name on action bar
        tvPrice = findViewById(R.id.tvPrice);
        tvHeading = findViewById(R.id.tvHeading);                                                   //Item name on below image
        tvSeller = findViewById(R.id.tvSeller);
        ivPreview = findViewById(R.id.ivPreview);
        tvAddToCart = findViewById(R.id.tvAddToCart);                                               //Add to cart button
        tvCart = findViewById(R.id.tvCart);                                                         //Number of Items in cart displayed in topLeft corner

        Bundle extras = getIntent().getExtras();

        tvHeadingTop.setText(extras.getString(ITEM_HEADING));
        tvPrice.setText(extras.getString(ITEM_PRICE));
        tvHeading.setText(extras.getString(ITEM_HEADING));
        tvSeller.setText(extras.getString(ITEM_SELLER));

        //Display image using image url
        Glide
            .with(this)
            .load(extras.getString(ITEM_PREVIEW))
            .centerCrop()
            .placeholder(R.drawable.logo)
            .into(ivPreview);

    }

    /**
     * Clicking back
     *
     * @param view
     */
    public void back(View view) {
        finish();
    }

    /**
     * Clicking add to cart
     * @param view
     */
    public void AddToCart(View view) {
        tvCart.setText(String.valueOf(nItems++));
    }
}