package com.example.darte.petroguide.presenter.map;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface MapFragmentView {

    void loadDataInMap(List<LatLng> listOfCoordinates);

    void checkPermissionForGettingUserLocation();

    void callBottomSheet();
}
