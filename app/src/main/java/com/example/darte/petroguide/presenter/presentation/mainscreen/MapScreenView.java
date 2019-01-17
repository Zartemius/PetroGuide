package com.example.darte.petroguide.presenter.presentation.mainscreen;

import com.example.darte.petroguide.presenter.domain.model.Place;

import java.util.List;

public interface MapScreenView {

    void loadDataInMap(List<Place> listOfPlaces);

    void checkPermissionForGettingUserLocation();

    void callBottomSheet(String placeId);
}
