package com.example.darte.petroguide.presenter.presentation.mainscreen;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.darte.petroguide.R;
import com.example.darte.petroguide.presenter.PGApplication;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.inject.Inject;
import java.util.List;

public class MapScreen extends Fragment implements OnMapReadyCallback,MapScreenView {

    @Inject
    MapPresenter mapPresenter;
    private GoogleMap mMap;
    private MapView mMapView;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";
    private static final int REQ_CODE = 111;

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

        ((PGApplication) getActivity().getApplication()).getAppComponent().inject(this);

        Bundle mapViewBundle = null;
        if(savedInstanceState != null){
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        initializeMap(view,mapViewBundle);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
        mapPresenter.subscribe(this);
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
        mapPresenter.unsubscribe();
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

    private void initializeMap(View view,Bundle mapViewBundle){
        mMapView = view.findViewById(R.id.map_fragment__map_view);
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapPresenter.loadPlacesToMap();

        //mMap.setMyLocationEnabled(true);

        //mMap.setMinZoomPreference(12);

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(11);

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String placeId = marker.getTag().toString();
                mapPresenter.callSheetWithShortInfoAboutPoint(placeId);

                Log.i("MARKER", "id" + marker.getTag().toString());

            }
        });

        /*
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(getActivity(), R.string.app_name,Toast.LENGTH_SHORT).show();
            }
        });

        buildingByTheRiver.showInfoWindow();

        mMap.addMarker(new MarkerOptions().position(buildingTwo)
                .title("building")
                .icon(BitmapDescriptorFactory.fromBitmap(convertImageToBitmap(R.drawable.marker)))
                .rotation(20)
                .draggable(false));*/

        /*UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setRotateGesturesEnabled(true);
        uiSettings.setScrollGesturesEnabled(true);
        uiSettings.setTiltGesturesEnabled(true);
        uiSettings.setZoomGesturesEnabled(true);*/



        /*LatLng spb = new LatLng(59.9386300,30.3141300);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(buildingTwo));*/
    }


    @Override
    public void loadDataInMap(List<Place> listOfPlaces) {
        for(Place place:listOfPlaces){
            createMap(place);
        }
    }

    private void createMap(Place place){
        LatLng building = new LatLng(place.getLatitude(),place.getLongitude());
        String placeName = place.getName();
        String address = place.getAddress();
        String placeId  = place.getUniqueId();

        mMap.addMarker( new MarkerOptions().position(building)
                .title(placeName)
                .snippet(address)
                .icon(BitmapDescriptorFactory.fromBitmap(convertImageToBitmap(R.drawable.marker)))
                .rotation(20)
                .draggable(false))
                .setTag(placeId);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(building));
    }

    private Bitmap convertImageToBitmap(int drawable){
        Drawable myDrawable = getResources().getDrawable(drawable);
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(150,150,Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        myDrawable.setBounds(0,0,150,150);
        myDrawable.draw(canvas);

        return bitmap;
    }

    @Override
    public void checkPermissionForGettingUserLocation() {
        if(getActivity() != null) {
            if (ContextCompat.checkSelfPermission(
                    getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermission();
            }
        }
    }

    private void requestPermission(){
        if(getActivity() != null) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQ_CODE);
        }
    }

    @Override
    public void callBottomSheet(String id){

        BottomSheet bottomSheet = new BottomSheet();
        Bundle placeData = new Bundle();
        placeData.putString("placeId",id);
        bottomSheet.setArguments(placeData);

        try {
            bottomSheet.show(getActivity().getSupportFragmentManager(), "bottomSheet");
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
