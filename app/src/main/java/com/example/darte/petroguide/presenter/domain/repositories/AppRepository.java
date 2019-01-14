package com.example.darte.petroguide.presenter.domain.repositories;

import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.Single;

import java.util.List;

public interface AppRepository {

    Single<List<Place>> getPlaces();
    Single<Long> insertPlace(Place place);
}
