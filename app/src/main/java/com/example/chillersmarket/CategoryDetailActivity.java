package com.example.chillersmarket;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.RecyclewViewItems.HomeItem;
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

    private MapView mapView;
    private MapboxMap mapboxMap;
    private BottomSheetBehavior bottomSheetBehavior;

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
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        CategoryDetailActivity.this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded(){
            @Override
            public void onStyleLoaded(@NonNull Style style) {

            }
        });
    }

    @Override
    @SuppressWarnings( {"MissingPermission"})
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
