package com.example.chillersmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.chillersmarket.fragments.ChillersMallFragment;
import com.example.chillersmarket.fragments.AccountFragment;
import com.example.chillersmarket.fragments.EventsFragment;
import com.example.chillersmarket.fragments.HomeFragment;
import com.example.chillersmarket.fragments.ListingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private TextView tvnCartItems;

    public void setCartnItems(int nItems){
        tvnCartItems.setText(String.valueOf(nItems));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvnCartItems = findViewById(R.id.tvnCartItems);

        //Transparent Status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }else {

        }


        BottomNavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                    break;
                case R.id.nav_mall:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChillersMallFragment()).commit();
                    break;
                case R.id.nav_events:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EventsFragment()).commit();
                    break;
                case R.id.nav_listings:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListingsFragment()).commit();
                    break;
                case R.id.nav_account:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AccountFragment()).commit();
                    break;
            }
            return true;

        });


        if (savedInstanceState == null) {
            //Fragment that opens first
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }

    }


    public void cart(View view) {
        startActivity(new Intent(this, CartActivity.class));
    }
}