package com.example.darte.petroguide.presenter.domain.interactor;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.example.darte.petroguide.presenter.domain.repositories.AppRepository;
import com.example.darte.petroguide.presenter.domain.repositories.CloudRepository;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.List;

public class DbSynchronization {

    private AppRepository mAppRepository;
    private CloudRepository mCloudRepository;
    public static String placerr;

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
                            public void onSuccess(List<Place> places) {
                                for(Place place:places) {
                                    addPlaceToAppDB(place);
                                    Log.i("PLACES", "name: " + places.get(0).getName());
                                    placerr = "no";
                                }
                                emitter.onSuccess(true);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
            }
        }).subscribeOn(Schedulers.io());
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
