package com.example.darte.petroguide.presenter.domain.repositories;

import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.Single;

import java.util.List;

public interface AppRepository {
    Single<List<Place>> getPlaces();
    void insertPlace(List<Place> places);
    void deletePlaces(List<String> placesList);
    Single<Place> getPlace(String id);
}
