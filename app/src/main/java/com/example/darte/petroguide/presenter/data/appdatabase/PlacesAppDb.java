package com.example.darte.petroguide.presenter.data.appdatabase;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.repositories.AppRepository;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

public class PlacesAppDb implements AppRepository {

    private PlaceDao mPlaceDao;

    @Inject
    public PlacesAppDb(PlaceDao placeDao){
        mPlaceDao = placeDao;
    }

    @Override
    public Single<List<Place>> getPlaces() {
        return mPlaceDao.getAllPlaces();
    }

    @Override
    public void insertPlace(List<Place> places) {
        mPlaceDao.insert(places);
    }

    @Override
    public void deletePlaces(List<String> placesList) {
        mPlaceDao.deletePlaceFromDb(placesList);
    }
}
