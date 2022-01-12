package com.example.chillersmarket;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.RecyclewViewItems.HomeItem;

import java.util.ArrayList;

public class CategoryDetailActivity extends AppCompatActivity {

    private RecyclerView rvHomeItems;
    private RecyclerView.LayoutManager rvHomeItemsLayoutManager;
    private ArrayList<HomeItem> homeItems = new ArrayList<>();



    private int nItems = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

    }


}
