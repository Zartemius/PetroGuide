package com.example.darte.petroguide.presenter.data;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.example.darte.petroguide.presenter.PGApplication;
import com.example.darte.petroguide.presenter.data.database.PlacesDb;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

public class DbSynchronization {

    private PlacesDb mPlacesDb;

    @Inject
    public DbSynchronization(PlacesDb placesDb){
        mPlacesDb = placesDb;
    }

    public void synchronizeDb() {

        Place place = new Place();

        place.setAddress("test_address");
        place.setDescription("test_description");
        place.setLatitude(22);
        place.setLongitude(11);
        place.setName("test_name");
        place.setPictureUrl("picture_url");
        place.setUniqueId("002 ");
        mPlacesDb.insertPlace(place)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Long>() {
                    @Override
                    public void onSuccess(Long o) {
                        Log.i("LOADING_IN_DB", "success");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOADING_IN_DB", "error");
                    }
                });
    }
}
