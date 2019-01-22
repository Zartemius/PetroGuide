package com.example.darte.petroguide.presenter.presentation.mainscreen;

import android.os.Bundle;
import android.view.View;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface MainMapScreenView {

    void loadDataInMap(List<Place> listOfPlaces);

    void callBottomSheet(String placeId);

    void setMapCamera(LatLng coordinates, float zoom);
}
