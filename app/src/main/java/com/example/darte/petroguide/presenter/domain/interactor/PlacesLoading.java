package com.example.darte.petroguide.presenter.domain.interactor;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.example.darte.petroguide.presenter.domain.repositories.AppRepository;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.List;

public class PlacesLoading {

    private AppRepository mAppRepository;

    @Inject
    public PlacesLoading(AppRepository appRepository){
        mAppRepository = appRepository;
    }

    public Single<List<Place>> getPlaces(){
        return Single.create(new SingleOnSubscribe<List<Place>>() {
            @Override
            public void subscribe(final SingleEmitter<List<Place>> emitter) throws Exception {
                mAppRepository.getPlaces()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DisposableSingleObserver<List<Place>>() {
                            @Override
                            public void onSuccess(List<Place> places) {
                                emitter.onSuccess(places);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
                }
            }).subscribeOn(Schedulers.io());
        }
}
