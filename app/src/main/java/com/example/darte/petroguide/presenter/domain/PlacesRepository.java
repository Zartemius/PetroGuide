package com.example.darte.petroguide.presenter.domain;

import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.Single;

import java.util.List;

public interface PlacesRepository {

    Single<List<Place>> getPlaces();
}
