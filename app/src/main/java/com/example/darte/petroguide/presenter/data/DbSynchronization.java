package com.example.darte.petroguide.presenter.data;

import android.app.Application;
import com.example.darte.petroguide.presenter.data.database.PlacesDb;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

public class DbSynchronization {

    @Inject private Application mApplication;

    void synchronizeDb(){
        PlacesDb placeDb = new PlacesDb(mApplication);

        Place place = new Place();

        placeDb.insertPlace(place)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Long>() {
                    @Override
                    public void onSuccess(Long o) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
