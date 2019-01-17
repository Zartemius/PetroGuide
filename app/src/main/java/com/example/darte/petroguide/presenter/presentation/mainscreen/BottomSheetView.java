package com.example.darte.petroguide.presenter.presentation.mainscreen;

import com.example.darte.petroguide.presenter.domain.model.Place;

public interface BottomSheetView {

    String getPlaceId();
    void displayInfoAboutThePlace(Place place);
}
