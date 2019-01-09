package com.example.darte.petroguide.presenter.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MapPresenter {

    private MapFragmentView mapFragmentView = null;

    void subscribe(MapFragmentView view){
        mapFragmentView = view;
        mapFragmentView.checkPermissionForGettingUserLocation();
    }

    void unsubscribe(){
        mapFragmentView = null;
    }

    void onMapReady(){

        List list = new ArrayList<LatLng>();

        LatLng buildingOne = new LatLng(59.96980441,30.30065453);
        LatLng buildingtwo = new LatLng(59.96595386,30.3096571);
        LatLng buildingThree = new LatLng(59.94119134,30.3139143);
        LatLng buildingFour = new LatLng(59.93996605,30.27490854);
        LatLng buildingFive = new LatLng(59.94585345,30.27430773);
        LatLng buildingSix = new LatLng(59.96226343,30.28320837);
        LatLng buildingSeven = new LatLng(60.0282477,30.41184497);

        list.add(buildingOne);
        list.add(buildingtwo);
        list.add(buildingThree);
        list.add(buildingFour);
        list.add(buildingFive);
        list.add(buildingSix);
        list.add(buildingSeven);

        mapFragmentView.loadDataInMap(list);
    }

    void callSheetWithShortInfoAboutPoint(){
        mapFragmentView.callBottomSheet();
    }

}
