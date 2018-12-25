package com.example.darte.petroguide.presenter.map;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.darte.petroguide.R;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mMapView;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if(mapViewBundle != null){
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY,mapViewBundle);
        }
        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.map_fragment,container,false);

        Bundle mapViewBundle = null;
        if(savedInstanceState != null){
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        initializeMap(view,mapViewBundle);

        return view;

    }

    private void initializeMap(View view,Bundle mapViewBundle){
        mMapView = view.findViewById(R.id.map_fragment__map_view);
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(12);
        //mMap.setMyLocationEnabled(true);

        LatLng building = new LatLng(59.96980441,30.30065453);
        LatLng buildingTwo = new LatLng(59.96595386,30.3096571);


        MarkerOptions markerOptions = new MarkerOptions();
        MarkerOptions markerOptions1 = new MarkerOptions();

        markerOptions.position(building);
        markerOptions1.position(buildingTwo);

        mMap.addMarker(markerOptions);
        mMap.addMarker(markerOptions1);

        /*UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setRotateGesturesEnabled(true);
        uiSettings.setScrollGesturesEnabled(true);
        uiSettings.setTiltGesturesEnabled(true);
        uiSettings.setZoomGesturesEnabled(true);*/

        LatLng spb = new LatLng(59.9386300,30.3141300);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(spb));
    }
}
