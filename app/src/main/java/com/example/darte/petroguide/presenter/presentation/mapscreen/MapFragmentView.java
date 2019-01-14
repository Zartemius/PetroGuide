package com.example.darte.petroguide.presenter.presentation.mapscreen;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface MapFragmentView {

    void loadDataInMap(List<LatLng> listOfCoordinates);

    void checkPermissionForGettingUserLocation();

    void callBottomSheet();
}
