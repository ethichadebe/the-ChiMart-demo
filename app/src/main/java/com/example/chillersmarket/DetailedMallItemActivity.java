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

    private TextView tvHeadingTop, tvPrice, tvHeading, tvSeller;
    private ImageView ivPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_mall_item);

        tvHeadingTop = findViewById(R.id.tvHeadingTop);
        tvPrice = findViewById(R.id.tvPrice);
        tvHeading = findViewById(R.id.tvHeading);
        tvSeller = findViewById(R.id.tvSeller);
        ivPreview = findViewById(R.id.ivPreview);

        Bundle extras = getIntent().getExtras();

        tvHeadingTop.setText(extras.getString(ITEM_HEADING));
        tvPrice.setText(extras.getString(ITEM_PRICE));
        tvHeading.setText(extras.getString(ITEM_HEADING));
        tvSeller.setText(extras.getString(ITEM_SELLER));

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
}