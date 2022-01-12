package com.example.chillersmarket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.Adapters.ListingAdapter;
import com.example.chillersmarket.Adapters.MallAdapter;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.ListingItem;
import com.example.chillersmarket.RecyclewViewItems.MallItem;

import java.util.ArrayList;

public class ListingsFragment extends Fragment {

    //RecycleView components
    private RecyclerView rvListingItems;
    private RecyclerView.Adapter rvListingItemsAdapter;
    private RecyclerView.LayoutManager rvListingItemsLayoutManager;
    private ArrayList<ListingItem> alListingItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listings,container,false);
        alListingItems.add(new ListingItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_cover_image/2021/12/chillersm-150x150.jpg",
                "Expressive Boutique","Hottest Fashion Destination","","+27658855417",
                "Chillers Retail (Brands, Products, Clothing, Electronic & More)","Closed"));
        alListingItems.add(new ListingItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_cover_image/2021/12/9FA1DFC4-592F-42A9-9065-B38866CB419E-150x150.jpg",
                "Nondis Creations","Made with love from our hands to you","","+27 64 680 3488","Other","Open"));
        alListingItems.add(new ListingItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_logo/2021/12/Coachleo-Institute-Logo-2022-150x150.png",
                "Coachleo Institute","Real Sustainable Results","Gauteng","083369241","Professionals/Practitioners",
                "Open"));
        alListingItems.add(new ListingItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_cover_image/2021/12/A60487EF-9EFE-42C9-8116-AAE909E7DC20-150x150.jpeg",
                "SABALI South Africa","","Gauteng","+27825923100",

                "Chillers Retail (Brands, Products, Clothing, Electronic & More)","Open"));
        alListingItems.add(new ListingItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_cover_image/2021/12/gugulethu-150x150.png",
                "Mxolisi","Lets sing for the people","Gauteng"," ","Rainbow/Floral headbands","Sold By : nondumisomkhatshwa"));

        //Setup RecycleView display
        rvListingItems = v.findViewById(R.id.recycleView);
        rvListingItems.setHasFixedSize(true);
        rvListingItemsLayoutManager = new LinearLayoutManager(getContext());
        rvListingItemsAdapter = new ListingAdapter(getContext(), alListingItems);

        rvListingItems.setLayoutManager(rvListingItemsLayoutManager);
        rvListingItems.setAdapter(rvListingItemsAdapter);

        return v;
    }
}
