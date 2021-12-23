package com.example.chillersmarket.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.Adapters.MallAdapter;
import com.example.chillersmarket.MallItemActivity;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.MallItem;

import java.util.ArrayList;

public class ChillersMallFragment extends Fragment {

    //Recycleview components
    private RecyclerView rvMallItems;
    private MallAdapter rvMallItemsAdapter;
    private RecyclerView.LayoutManager rvMallItemsLayoutManager;
    private ArrayList<MallItem> alMallItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chillers_mall, container, false);

        rvMallItems = v.findViewById(R.id.recycleView);

        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "R220.00", "Floral upside down earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/ONDISPLAY2019flipbook-01-300x300.png", "Free", "Lihawu b/w earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/09/Chiller-Market-1-e1632735257569-300x266.png", "R599.00", "Medium", "Sold By : Chillers Market"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/Flags_27-04-300x300.png", "R250.00 Free", "Orange 3D disk earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/pOP-uP-bANNER-05-300x300.jpg", "R250.00", "Rainbow/Floral headbands", "Sold By : nondumisomkhatshwa"));

        buildRecyclerView();

        return v;
    }

    /**
     * Setup RecycleView display
     */
    private void buildRecyclerView() {
        rvMallItems.setHasFixedSize(true);
        rvMallItemsLayoutManager = new GridLayoutManager(getContext(), 2);
        rvMallItemsAdapter = new MallAdapter(getContext(), alMallItems);

        rvMallItems.setLayoutManager(rvMallItemsLayoutManager);
        rvMallItems.setAdapter(rvMallItemsAdapter);

        rvMallItemsAdapter.setOnItemClickListener(new MallAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(getContext(), MallItemActivity.class));
            }
        });
    }
}
