package com.example.chillersmarket;

import static com.example.chillersmarket.fragments.ChillersMallFragment.ITEM_CATEGORY;
import static com.example.chillersmarket.fragments.ChillersMallFragment.ITEM_HEADING;
import static com.example.chillersmarket.fragments.ChillersMallFragment.ITEM_PREVIEW;
import static com.example.chillersmarket.fragments.ChillersMallFragment.ITEM_PRICE;
import static com.example.chillersmarket.fragments.ChillersMallFragment.ITEM_SELLER;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.Adapters.HomeAdapter;
import com.example.chillersmarket.Adapters.RelatedProductAdapter;
import com.example.chillersmarket.RecyclewViewItems.HomeItem;
import com.example.chillersmarket.RecyclewViewItems.MallItem;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.mapbox.android.core.permissions.PermissionsListener;

import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.ArrayList;
import java.util.List;


public class CategoryDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String ITEM_PREVIEW = "com.example.chillersmarket.fragments.ITEM_PREVIEW";
    public static final String ITEM_PRICE = "com.example.chillersmarket.fragments.ITEM_PRICE";
    public static final String ITEM_HEADING = "com.example.chillersmarket.fragments.ITEM_HEADING";
    public static final String ITEM_SELLER = "com.example.chillersmarket.fragments.ITEM_SELLER";
    public static final String ITEM_CATEGORY = "com.example.chillersmarket.fragments.ITEM_CATEGORY";

    private MapView mapView;
    private MapboxMap mapboxMap;
    private BottomSheetBehavior bottomSheetBehavior;

    //RecentlyAdded Items RecyclerView components
    private RecyclerView rvRecentlyAdded, rvOnOfferItems;
    private RecyclerView.LayoutManager rvRecentlyAddedLayoutManager, rvOnOfferItemsLayoutManager;
    private RelatedProductAdapter relatedProductAdapter, relatedProductAdapterOnOfferItems;
    private ArrayList<MallItem> alMallItems = new ArrayList<>();

    //Home Items RecyclerView components
    private RecyclerView rvHomeItems;
    private HomeAdapter rvHomeItemsAdapter;
    private RecyclerView.LayoutManager rvHomeItemsLayoutManager;
    private ArrayList<HomeItem> homeItems = new ArrayList<>();

    private int nItems = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(CategoryDetailActivity.this, getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_category_detail);

        //Setup mapView
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.getMapAsync(this);

        //Set up bottom sheet
        View bottomSheet = findViewById(R.id.category_detail_bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        //Set up Items in bottom sheet
        rvRecentlyAdded = findViewById(R.id.popularItemsRecycleView);
        rvOnOfferItems = findViewById(R.id.OnOfferItemsRecycleView);

        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "R220.00", "Floral upside down earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/ONDISPLAY2019flipbook-01-300x300.png", "Free", "Lihawu b/w earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/09/Chiller-Market-1-e1632735257569-300x266.png", "R599.00", "Medium", "Sold By : Chillers Market"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/Flags_27-04-300x300.png", "R250.00 Free", "Orange 3D disk earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/pOP-uP-bANNER-05-300x300.jpg", "R250.00", "Rainbow/Floral headbands", "Sold By : nondumisomkhatshwa"));

        homeItems.add(new HomeItem("Entertainment", R.drawable.ic_entertainment));
        homeItems.add(new HomeItem("Chillers Retail", R.drawable.ic_shopping_bag));
        homeItems.add(new HomeItem("Construction, Engineering, Transport, Logistics", R.drawable.ic_business));
        homeItems.add(new HomeItem("Consulting Services", R.drawable.ic_consulting));
        homeItems.add(new HomeItem("Professionals/Practitioners", R.drawable.ic_professionals));
        homeItems.add(new HomeItem("Agriculture, Manufacturing, Food, Tourism", R.drawable.ic_food));

        //Setup Home Item RecyclerView display
        rvHomeItems = findViewById(R.id.morePopularCategoriesRecycleView);
        buildPopularCategoriesRecycleView();


        buildPopularItemsRecyclerView();
        buildOnOfferItemsRecyclerView();
    }

    /**
     * Setup RecycleView display for PopularCategories
     */
    private void buildPopularCategoriesRecycleView(){
        rvHomeItems.setHasFixedSize(true);
        rvHomeItemsLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvHomeItemsAdapter = new HomeAdapter(this, homeItems);

        rvHomeItems.setLayoutManager(rvHomeItemsLayoutManager);
        rvHomeItems.setAdapter(rvHomeItemsAdapter);

        rvHomeItemsAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position, Context c){
                finish();

                startActivity(getIntent());
            }

            @Override
            public void onAddToCartClick(int position) {

            }
        });
    }


    /**
     * Setup RecycleView display for PopularItems
     */
    private void buildPopularItemsRecyclerView(){
        rvRecentlyAdded.setHasFixedSize(true);
        rvRecentlyAddedLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        relatedProductAdapter = new RelatedProductAdapter(this, alMallItems);

        rvRecentlyAdded.setLayoutManager(rvRecentlyAddedLayoutManager);
        rvRecentlyAdded.setAdapter(relatedProductAdapter);

        //Implementing item on click methods
        relatedProductAdapter.setOnItemClickListener(new RelatedProductAdapter.OnItemClickListener() {
            //Mall Item on click
            @Override
            public void onItemClick(int position, Context c) {
                finish();
                getIntent().putExtra(ITEM_PREVIEW, alMallItems.get(position).getStrPreview());
                getIntent().putExtra(ITEM_PRICE, alMallItems.get(position).getStrPrice());
                getIntent().putExtra(ITEM_HEADING, alMallItems.get(position).getStrHeading());
                getIntent().putExtra(ITEM_SELLER, alMallItems.get(position).getStrSeller());
                getIntent().putExtra(ITEM_CATEGORY, alMallItems.get(position).getStrPreview());
                startActivity(getIntent());
            }
            //Add to cart icon click  event
            @Override
            public void onAddToCartClick(int position) {

            }
        });
    }


    /**
     * Setup RecycleView display for OnOfferItems
     */
    private void buildOnOfferItemsRecyclerView(){
        rvOnOfferItems.setHasFixedSize(true);
        rvOnOfferItemsLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        relatedProductAdapterOnOfferItems = new RelatedProductAdapter(this, alMallItems);

        rvOnOfferItems.setLayoutManager(rvOnOfferItemsLayoutManager);
        rvOnOfferItems.setAdapter(relatedProductAdapterOnOfferItems);

        //Implementing item on click methods
        relatedProductAdapterOnOfferItems.setOnItemClickListener(new RelatedProductAdapter.OnItemClickListener() {
            //Mall Item on click
            @Override
            public void onItemClick(int position, Context c) {
                finish();
                getIntent().putExtra(ITEM_PREVIEW, alMallItems.get(position).getStrPreview());
                getIntent().putExtra(ITEM_PRICE, alMallItems.get(position).getStrPrice());
                getIntent().putExtra(ITEM_HEADING, alMallItems.get(position).getStrHeading());
                getIntent().putExtra(ITEM_SELLER, alMallItems.get(position).getStrSeller());
                getIntent().putExtra(ITEM_CATEGORY, alMallItems.get(position).getStrPreview());
                startActivity(getIntent());
            }
            //Add to cart icon click  event
            @Override
            public void onAddToCartClick(int position) {

            }
        });
    }


    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        CategoryDetailActivity.this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {

            }
        });
    }

    @Override
    @SuppressWarnings({"MissingPermission"})
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }
}
