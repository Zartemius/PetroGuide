package com.example.darte.petroguide.presenter.domain.interactor;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.example.darte.petroguide.presenter.domain.repositories.AppRepository;
import com.example.darte.petroguide.presenter.domain.repositories.CloudRepository;
import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
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


    public Single<Boolean> synchronizeAppDbWithCloudDbAsync(){
        return Single.create(new SingleOnSubscribe<Boolean>() {
            @Override
            public void subscribe(final SingleEmitter<Boolean> emitter) throws Exception {
                mCloudRepository.getPlaces()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DisposableSingleObserver<List<Place>>() {
                            @Override
                            public void onSuccess(final List<Place> places) {
                                Log.i("SYNCHRONIZATION", "items_loaded");
                                List<String> placesId = new ArrayList<>();

                                for(Place place:places){
                                    placesId.add(place.getUniqueId());
                                }

                                deleteItemsFromAppDbThatDontExistInCLoudDb(placesId)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new DisposableCompletableObserver() {
                                            @Override
                                            public void onComplete() {
                                                Log.i("DATA_SOURCE", "works");
                                                Log.i("SYNCHRONIZATION", "items_deleted");
                                                addPlaceToAppDB(places)
                                                .subscribeOn(Schedulers.io())
                                                        .observeOn(AndroidSchedulers.mainThread())
                                                        .subscribe(new DisposableCompletableObserver() {
                                                            @Override
                                                            public void onComplete() {
                                                                Log.i("SYNCHRONIZATION", "items_added");
                                                                emitter.onSuccess(true);
                                                            }
                                                            @Override
                                                            public void onError(Throwable e) {
                                                                Log.i("SYNCHRONIZATION",
                                                                        "items_added_error "+ e);
                                                                emitter.onSuccess(true);
                                                            }
                                                        });
                                            }

                                            @Override
                                            public void onError(Throwable e) {
                                                Log.i("DATA_SOURCE", "no_works" + e);
                                            }
                                        });
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
                     }
                });
            }

    private Completable addPlaceToAppDB(final List<Place> places) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mAppRepository.insertPlace(places);
            }
        });
    }

    private Completable deleteItemsFromAppDbThatDontExistInCLoudDb(final List<String> places){
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mAppRepository.deletePlaces(places);
            }
        });
    }
}
