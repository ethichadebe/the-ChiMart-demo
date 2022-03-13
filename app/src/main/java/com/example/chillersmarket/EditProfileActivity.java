package com.example.chillersmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
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

    public void cart(View view) {
        startActivity(new Intent(this, CartActivity.class));
    }

}