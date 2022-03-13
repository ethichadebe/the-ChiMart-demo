package com.example.chillersmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
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
     *
     * @param view
     */

    public void cart(View view) {
        startActivity(new Intent(this, CartActivity.class));
    }
}