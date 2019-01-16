package com.example.darte.petroguide.presenter.presentation.mapscreen;

import com.example.darte.petroguide.presenter.domain.model.Place;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface MapFragmentView {

    void loadDataInMap(List<Place> listOfCoordinates);

    void checkPermissionForGettingUserLocation();

    void callBottomSheet();
}
