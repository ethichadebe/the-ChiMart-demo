package com.example.chillersmarket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.Adapters.ListingAdapter;
import com.example.chillersmarket.Adapters.ReviewAdapter;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.ListingItem;
import com.example.chillersmarket.RecyclewViewItems.ReviewItem;

import java.util.ArrayList;

public class ReviewsFragment extends Fragment {

    //RecycleView components
    private RecyclerView rvReviewItems;
    private RecyclerView.Adapter rvReviewItemsAdapter;
    private RecyclerView.LayoutManager rvReviewItemsLayoutManager;
    private ArrayList<ReviewItem> alReviewItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reviews, container, false);
        alReviewItems.add(new ReviewItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_cover_image/2021/12/chillersm-150x150.jpg",
                "John", "December 15, 2021", "I like the black one but the price is a bit too much, R200.00?"));
        alReviewItems.add(new ReviewItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_cover_image/2021/12/chillersm-150x150.jpg",
                "John", "December 15, 2021", "I like the black one but the price is a bit too much, R200.00?"));
        alReviewItems.add(new ReviewItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_cover_image/2021/12/chillersm-150x150.jpg",
                "John", "December 15, 2021", "I like the black one but the price is a bit too much, R200.00?"));
        alReviewItems.add(new ReviewItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_cover_image/2021/12/chillersm-150x150.jpg",
                "John", "December 15, 2021", "I like the black one but the price is a bit too much, R200.00?"));
        alReviewItems.add(new ReviewItem("https://chillersmarket.com/wp-content/uploads/job-manager-uploads/job_cover_image/2021/12/chillersm-150x150.jpg",
                "John", "December 15, 2021", "I like the black one but the price is a bit too much, R200.00?"));

        //Setup RecycleView display
        rvReviewItems = v.findViewById(R.id.recycleView);
        rvReviewItems.setHasFixedSize(true);
        rvReviewItemsLayoutManager = new LinearLayoutManager(getActivity());
        rvReviewItemsAdapter = new ReviewAdapter(alReviewItems, getActivity());

        rvReviewItems.setLayoutManager(rvReviewItemsLayoutManager);
        rvReviewItems.setAdapter(rvReviewItemsAdapter);

        return v;
    }
}
