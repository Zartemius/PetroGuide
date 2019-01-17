package com.example.darte.petroguide.presenter.presentation.mainscreen;

import com.example.darte.petroguide.presenter.domain.interactor.PlacesLoading;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.List;

public class MapPresenter {

    private PlacesLoading mPlacesLoading;
    private MapScreenView mapScreenView = null;
    private Disposable mDisposable;

    @Inject
    public MapPresenter(PlacesLoading placesLoading){
        mPlacesLoading = placesLoading;
    }

    void subscribe(MapScreenView view){
        mapScreenView = view;
        mapScreenView.checkPermissionForGettingUserLocation();
    }

    void unsubscribe(){
        mapScreenView = null;
        if(mDisposable != null) {
            mDisposable.dispose();
        }
    }

    void callSheetWithShortInfoAboutPoint(String placeId){
        mapScreenView.callBottomSheet(placeId);
    }

    void loadPlacesToMap(){
       mDisposable = mPlacesLoading.getPlaces()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Place>>() {
                    @Override
                    public void onSuccess(List<Place> places) {
                        mapScreenView.loadDataInMap(places);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
        });
    }
}
