package com.example.darte.petroguide.presenter.presentation.mainscreen;

import com.example.darte.petroguide.presenter.domain.model.Place;

import java.util.List;

public interface MapFragmentView {

    void loadDataInMap(List<Place> listOfPlaces);

    void checkPermissionForGettingUserLocation();

    void callBottomSheet();
}
