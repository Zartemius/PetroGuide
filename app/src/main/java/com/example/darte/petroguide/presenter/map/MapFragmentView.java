package com.example.darte.petroguide.presenter.map;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface MapFragmentView {

    void loadDataInMap(List<LatLng> listOfCoordinats);



}
