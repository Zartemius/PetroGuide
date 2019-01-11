package com.example.darte.petroguide.presenter.data.database;

import android.app.Application;
import com.example.darte.petroguide.presenter.domain.PlacesRepository;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

import java.util.List;

public class PlacesDb implements PlacesRepository {

    private PlaceDao mPlaceDao;

    public PlacesDb(Application application){
        AppDataBase appDataBase = AppDataBase.getDataBase(application);
        mPlaceDao = appDataBase.placeDao();

    }

    @Override
    public Single<List<Place>> getPlaces() {
        return null;
    }

    public Single<Long> insertPlace(Place place) {
        return mPlaceDao.insert(place);
    }
}
