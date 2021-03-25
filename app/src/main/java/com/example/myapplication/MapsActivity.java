package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button shoppage = findViewById(R.id.shoppage);
        shoppage.setOnClickListener(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng HK = new LatLng(22.3063201, 114.1860866);
        mMap.addMarker(getMarker(HK,R.drawable.maplogo));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(HK));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HK, 15));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16),2000,null);
    }
    public MarkerOptions getMarker(LatLng point, int drawableId)
    {
        return new MarkerOptions()
                .position(point)
                .icon(BitmapDescriptorFactory.fromResource(drawableId));
    }

    public void onClick (View v){
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.shoppage:
                it.setClass(MapsActivity.this,shop.class);
                startActivity(it);
                finish();
                break;
        }
    }
}