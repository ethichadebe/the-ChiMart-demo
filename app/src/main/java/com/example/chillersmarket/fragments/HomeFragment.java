package com.example.chillersmarket.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.Adapters.HomeAdapter;
import com.example.chillersmarket.Adapters.MallAdapter;
import com.example.chillersmarket.Adapters.RelatedProductAdapter;
import com.example.chillersmarket.Adapters.SliderAdapter;
import com.example.chillersmarket.CategoryDetailActivity;
import com.example.chillersmarket.DetailedMallItemActivity;
import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.HomeItem;
import com.example.chillersmarket.RecyclewViewItems.HomeSlider;
import com.example.chillersmarket.RecyclewViewItems.MallItem;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public static final String ITEM_PREVIEW = "com.example.chillersmarket.fragments.ITEM_PREVIEW";
    public static final String ITEM_PRICE = "com.example.chillersmarket.fragments.ITEM_PRICE";
    public static final String ITEM_HEADING = "com.example.chillersmarket.fragments.ITEM_HEADING";
    public static final String ITEM_SELLER = "com.example.chillersmarket.fragments.ITEM_SELLER";
    public static final String ITEM_CATEGORY = "com.example.chillersmarket.fragments.ITEM_CATEGORY";

    //Home Items RecyclerView components
    private RecyclerView rvHomeItems;
    private HomeAdapter rvHomeItemsAdapter;
    private RecyclerView.LayoutManager rvHomeItemsLayoutManager;
    private ArrayList<HomeItem> homeItems = new ArrayList<>();

    //RecentlyAdded Items RecyclerView components
    private RecyclerView rvRecentlyAdded;
    private RecyclerView.LayoutManager rvRecentlyAddedLayoutManager;
    private RelatedProductAdapter relatedProductAdapter;
    private ArrayList<MallItem> alMallItems = new ArrayList<>();


    // Urls of our images.
    String url1 = "https://chillersmarket.com/wp-content/uploads/2021/09/Chiller-Market-1-e1632735257569-300x266.png";
    String url2 = "https://chillersmarket.com/wp-content/uploads/2021/12/Untitled-design-e1639424477449.png";
    String url3 = "https://justnje.com/wp-content/uploads/2021/10/Podcast-and-Chill-with-MacG-EP290.jpg";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        //Setting up slider
        setUpSlider(view);

        homeItems.add(new HomeItem("Entertainment", R.drawable.ic_entertainment));
        homeItems.add(new HomeItem("Chillers Retail", R.drawable.ic_shopping_bag));
        homeItems.add(new HomeItem("Construction, Engineering, Transport, Logistics", R.drawable.ic_business));
        homeItems.add(new HomeItem("Consulting Services", R.drawable.ic_consulting));
        homeItems.add(new HomeItem("Professionals/Practitioners", R.drawable.ic_professionals));
        homeItems.add(new HomeItem("Agriculture, Manufacturing, Food, Tourism", R.drawable.ic_food));

        //Setup Home Item RecyclerView display
        rvHomeItems = view.findViewById(R.id.homeItemsRecycleView);
        buildHomeItemsRecyclerView();

        rvRecentlyAdded = view.findViewById(R.id.recentlyAddedRecycleView);

        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "R220.00", "Floral upside down earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/ONDISPLAY2019flipbook-01-300x300.png", "Free", "Lihawu b/w earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/09/Chiller-Market-1-e1632735257569-300x266.png", "R599.00", "Medium", "Sold By : Chillers Market"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/Flags_27-04-300x300.png", "R250.00 Free", "Orange 3D disk earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/pOP-uP-bANNER-05-300x300.jpg", "R250.00", "Rainbow/Floral headbands", "Sold By : nondumisomkhatshwa"));

        buildRecentlyAddedRecyclerView();

        return view;
    }

    private void buildHomeItemsRecyclerView(){
        rvHomeItems.setHasFixedSize(true);
        rvHomeItemsLayoutManager = new GridLayoutManager(getContext(), 2);
        rvHomeItemsAdapter = new HomeAdapter(getContext(), homeItems);

        rvHomeItems.setLayoutManager(rvHomeItemsLayoutManager);
        rvHomeItems.setAdapter(rvHomeItemsAdapter);

        rvHomeItemsAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position, Context c){
                Intent intent = new Intent(getContext(), CategoryDetailActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAddToCartClick(int position) {

            }
        });
    }

    /**
     * Setup RecycleView display
     */
    private void buildRecentlyAddedRecyclerView(){
        rvRecentlyAdded.setHasFixedSize(true);
        rvRecentlyAddedLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        relatedProductAdapter = new RelatedProductAdapter(getContext(), alMallItems);

        rvRecentlyAdded.setLayoutManager(rvRecentlyAddedLayoutManager);
        rvRecentlyAdded.setAdapter(relatedProductAdapter);

        //Implementing item on click methods
        relatedProductAdapter.setOnItemClickListener(new RelatedProductAdapter.OnItemClickListener() {
            //Mall Item on click
            @Override
            public void onItemClick(int position, Context c) {
                Intent intent = new Intent(getContext(), DetailedMallItemActivity.class);
                intent.putExtra(ITEM_PREVIEW, alMallItems.get(position).getStrPreview());
                intent.putExtra(ITEM_PRICE, alMallItems.get(position).getStrPrice());
                intent.putExtra(ITEM_HEADING, alMallItems.get(position).getStrHeading());
                intent.putExtra(ITEM_SELLER, alMallItems.get(position).getStrSeller());
                intent.putExtra(ITEM_CATEGORY, alMallItems.get(position).getStrPreview());
                startActivity(intent);
            }

            //Add to cart icon click  event
            @Override
            public void onAddToCartClick(int position) {

            }
        });
    }

    /**
     * Setup Slider
     * @param view
     */
    private void setUpSlider(View view){
        // we are creating array list for storing our image urls.
        ArrayList<HomeSlider> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = view.findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new HomeSlider(url2));
        sliderDataArrayList.add(new HomeSlider(url1));
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
    }
}
