package com.example.chillersmarket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.Adapters.HomeAdapter;
import com.example.chillersmarket.Adapters.MallAdapter;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.HomeItem;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    //RecyclerView components
    private RecyclerView rvHomeItems;
    private RecyclerView.Adapter rvHomeItemsAdapter;
    private RecyclerView.LayoutManager rvHomeItemsLayoutManager;
    private ArrayList<HomeItem> homeItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        homeItems.add(new HomeItem("Entertainment", R.drawable.ic_entertainment));
        homeItems.add(new HomeItem("Chillers Retail", R.drawable.ic_shopping_bag));
        homeItems.add(new HomeItem("Construction, Engineering, Transport, Logistics", R.drawable.ic_business));
        homeItems.add(new HomeItem("Consulting Services", R.drawable.ic_consulting));
        homeItems.add(new HomeItem("Professionals/Practitioners", R.drawable.ic_professionals));
        homeItems.add(new HomeItem("Agriculture, Manufacturing, Food, Tourism", R.drawable.ic_food));

        //Setup RecyclerView display
        rvHomeItems = view.findViewById(R.id.homeRecycleView);
        rvHomeItems.setHasFixedSize(true);
        rvHomeItemsLayoutManager = new GridLayoutManager(getContext(), 2);
        rvHomeItemsAdapter = new HomeAdapter(getContext(), homeItems);

        rvHomeItems.setLayoutManager(rvHomeItemsLayoutManager);
        rvHomeItems.setAdapter(rvHomeItemsAdapter);
        return view;
    }
}
