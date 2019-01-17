package com.example.darte.petroguide.presenter.domain.interactor;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.example.darte.petroguide.presenter.domain.repositories.AppRepository;
import com.example.darte.petroguide.presenter.domain.repositories.CloudRepository;
import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class DbSynchronization {

    private AppRepository mAppRepository;
    private CloudRepository mCloudRepository;

    @Inject
    public DbSynchronization(AppRepository appRepository, CloudRepository cloudRepository){
        mAppRepository = appRepository;
        mCloudRepository = cloudRepository;
    }

    public Completable synchronizeAppDbWithCloudDbAsync(final List<Place> places){

        final List<String> placesId = new ArrayList<>();

        for(Place place:places){
            placesId.add(place.getUniqueId());
        }

        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                deleteItemsFromAppDbThatDontExistInCLoudDbAsync(placesId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        Log.i("DATA_SOURCE", "works");
                        Log.i("SYNCHRONIZATION", "items_deleted");
                        for(Place place:places) {
                            Log.i("LOADED_PLACE", "resultList" + place.getName());
                        }
                        addPlaceToAppDBAsync(places)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new DisposableCompletableObserver() {
                                    @Override
                                    public void onComplete() {
                                        Log.i("SYNCHRONIZATION", "items_added");
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Log.i("SYNCHRONIZATION",
                                                "items_added_error " + e);
                                    }
                                });
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("DATA_SOURCE", "no_works" + e);
                    }
                });
            }
        });
    }



    private Completable addPlaceToAppDBAsync(final List<Place> places) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mAppRepository.insertPlace(places);
            }
        });
    }

    private Completable deleteItemsFromAppDbThatDontExistInCLoudDbAsync(final List<String> places){
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mAppRepository.deletePlaces(places);
            }
        });
    }

    public Single<List<Place>> loadPlacesFromServerAsync(){
        return mCloudRepository.getPlaces();
    }
}
