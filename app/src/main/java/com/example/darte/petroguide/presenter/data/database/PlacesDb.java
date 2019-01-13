package com.example.darte.petroguide.presenter.data.database;

import android.app.Application;
import com.example.darte.petroguide.presenter.domain.PlacesRepository;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.List;

public class PlacesDb implements PlacesRepository {

    private PlaceDao mPlaceDao;

    @Inject
    public PlacesDb(PlaceDao placeDao){
        mPlaceDao = placeDao;
    }

    @Override
    public Single<List<Place>> getPlaces() {
        return null;
    }

    public Single<Long> insertPlace(Place place) {
        return mPlaceDao.insert(place);
    }
}
