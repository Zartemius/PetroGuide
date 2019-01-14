package com.example.darte.petroguide.presenter.domain.interactor;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.example.darte.petroguide.presenter.domain.repositories.AppRepository;
import com.example.darte.petroguide.presenter.domain.repositories.CloudRepository;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.List;

public class DbSynchronization {

    private AppRepository mAppRepository;
    private CloudRepository mCloudRepository;

    @Inject
    public DbSynchronization(AppRepository appRepository, CloudRepository cloudRepository){
        mAppRepository = appRepository;
        mCloudRepository = cloudRepository;
    }

    public void synchronizeAppDbWithCloudDb(){

        mCloudRepository.getPlaces()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Place>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Place> places) {
                        for(Place place:places) {
                            addPlaceToAppDB(place);
                            Log.i("PLACES", "name: " + places.get(0).getName());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private void addPlaceToAppDB(Place place) {
        mAppRepository.insertPlace(place)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Long>() {
                    @Override
                    public void onSuccess(Long o) {
                        Log.i("LOADING_IN_DB", "success"+ o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOADING_IN_DB", "error");
                    }
                });
    }
}
