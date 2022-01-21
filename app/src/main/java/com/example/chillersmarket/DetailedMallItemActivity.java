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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.chillersmarket.Adapters.RelatedProductAdapter;
import com.example.chillersmarket.Adapters.ViewPagerAdapter;
import com.example.chillersmarket.RecyclewViewItems.MallItem;
import com.example.chillersmarket.fragments.ProductDescriptionFragment;
import com.example.chillersmarket.fragments.ProductRatingsFragment;
import com.example.chillersmarket.fragments.ReviewsFragment;
import com.example.chillersmarket.fragments.VendorPoliciesFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DetailedMallItemActivity extends AppCompatActivity {

    //Recycleview components
    private RecyclerView rvMallItems;
    private RelatedProductAdapter rvMallItemsAdapter;
    private RecyclerView.LayoutManager rvMallItemsLayoutManager;
    private ArrayList<MallItem> alMallItems = new ArrayList<>();

    private TextView tvHeadingTop, tvPrice, tvHeading, tvSeller, tvAddToCart, tvCart;
    private ImageView ivPreview;
    private TabLayout tlTabs;
    private ViewPager vpViewPager;

    private int nItems = 0;                                                                             //Demo variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_mall_item);

        tvHeadingTop = findViewById(R.id.tvHeadingTop);                                             //Item name on action bar
        tvPrice = findViewById(R.id.tvPrice);
        tvHeading = findViewById(R.id.tvHeading);                                                   //Item name on below image
        tvSeller = findViewById(R.id.tvSeller);
        ivPreview = findViewById(R.id.ivPreview);
        tvAddToCart = findViewById(R.id.tvAddToCart);                                               //Add to cart button
        tvCart = findViewById(R.id.tvCart);                                                         //Number of Items in cart displayed in topLeft corner
        tlTabs = findViewById(R.id.tlTabs);                                               //Add to cart button
        vpViewPager = findViewById(R.id.vpViewPager);                                                         //Number of Items in cart displayed in topLeft corner
        rvMallItems = findViewById(R.id.recycleView);

        //Data passed from ChillersMallFragment
        Bundle extras = getIntent().getExtras();

        tvHeadingTop.setText(extras.getString(ITEM_HEADING));
        tvPrice.setText(extras.getString(ITEM_PRICE));
        tvHeading.setText(extras.getString(ITEM_HEADING));
        tvSeller.setText(extras.getString(ITEM_SELLER));

        //Display image using image url
        Glide
            .with(this)
            .load(extras.getString(ITEM_PREVIEW))
            .centerCrop()
            .placeholder(R.drawable.logo)
            .into(ivPreview);


        //Tab layout
        tlTabs.setupWithViewPager(vpViewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPagerAdapter.addFragment(new ProductDescriptionFragment(), "Description");
        viewPagerAdapter.addFragment(new ReviewsFragment(), "Reviews");
        viewPagerAdapter.addFragment(new ProductRatingsFragment(), "Product ratings");
        viewPagerAdapter.addFragment(new VendorPoliciesFragment(), "Vendor Policies");
        vpViewPager.setAdapter(viewPagerAdapter);

        //Related Items
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/woocommerce-placeholder-300x300.png", "R220.00", "Floral upside down earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/ONDISPLAY2019flipbook-01-300x300.png", "Free", "Lihawu b/w earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/09/Chiller-Market-1-e1632735257569-300x266.png", "R599.00", "Medium", "Sold By : Chillers Market"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/Flags_27-04-300x300.png", "R250.00 Free", "Orange 3D disk earrings", "Sold By : nondumisomkhatshwa"));
        alMallItems.add(new MallItem("https://chillersmarket.com/wp-content/uploads/2021/12/pOP-uP-bANNER-05-300x300.jpg", "R250.00", "Rainbow/Floral headbands", "Sold By : nondumisomkhatshwa"));

        buildRecyclerView();

    }

    /**
     * Setup RecycleView display
     */
    private void buildRecyclerView() {
        rvMallItems.setHasFixedSize(true);
        rvMallItemsLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rvMallItemsAdapter = new RelatedProductAdapter(this, alMallItems);

        rvMallItems.setLayoutManager(rvMallItemsLayoutManager);
        rvMallItems.setAdapter(rvMallItemsAdapter);

        //Implementing item on click methods
        rvMallItemsAdapter.setOnItemClickListener(new RelatedProductAdapter.OnItemClickListener() {
            //Mall Item on click
            @Override
            public void onItemClick(int position, Context context) {
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
    public void AddToCart(View view) {
        tvCart.setText(String.valueOf(nItems++));
    }

    public void cart(View view) {
        startActivity(new Intent(this, CartActivity.class));
    }
}