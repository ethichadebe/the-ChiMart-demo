package com.example.chillersmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MallItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_item);
    }

    /**
     * Clicking back
     * @param view
     */
    public void back(View view) {
        finish();
    }
}