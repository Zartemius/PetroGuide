package com.example.darte.petroguide.presenter.presentation.mainscreen;

import com.example.darte.petroguide.presenter.domain.model.Place;

import java.util.List;

public interface MainMapScreenView {

    void loadDataInMap(List<Place> listOfPlaces);

    void callBottomSheet(String placeId);
}
