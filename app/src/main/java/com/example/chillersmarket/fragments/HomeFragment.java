package com.example.chillersmarket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.Adapters.HomeAdapter;
import com.example.chillersmarket.Adapters.MallAdapter;
import com.example.chillersmarket.Adapters.SliderAdapter;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.HomeItem;
import com.example.chillersmarket.RecyclewViewItems.HomeSlider;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    //RecyclerView components
    private RecyclerView rvHomeItems;
    private RecyclerView.Adapter rvHomeItemsAdapter;
    private RecyclerView.LayoutManager rvHomeItemsLayoutManager;
    private ArrayList<HomeItem> homeItems = new ArrayList<>();

    // Urls of our images.
    String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
    String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
    String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";


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

        // we are creating array list for storing our image urls.
        ArrayList<HomeSlider> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = rootView.findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new HomeSlider(url1));
        sliderDataArrayList.add(new HomeSlider(url2));
        sliderDataArrayList.add(new HomeSlider(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(getContext(), sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();

        //Setup RecyclerView display
        rvHomeItems = view.findViewById(R.id.homeItemsRecycleView);
        rvHomeItems.setHasFixedSize(true);
        rvHomeItemsLayoutManager = new GridLayoutManager(getContext(), 2);
        rvHomeItemsAdapter = new HomeAdapter(getContext(), homeItems);

        rvHomeItems.setLayoutManager(rvHomeItemsLayoutManager);
        rvHomeItems.setAdapter(rvHomeItemsAdapter);
        return view;
    }
}
