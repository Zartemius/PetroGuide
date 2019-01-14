package com.example.darte.petroguide.presenter.data.appdatabase;

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
        return null;
    }

    @Override
    public Single<Long> insertPlace(Place place) {
        return mPlaceDao.insert(place);
    }
}
