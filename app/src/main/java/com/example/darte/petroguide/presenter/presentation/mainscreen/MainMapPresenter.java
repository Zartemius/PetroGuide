package com.example.darte.petroguide.presenter.presentation.mainscreen;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.interactor.PlacesLoading;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.google.android.gms.maps.model.LatLng;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.List;

public class MainMapPresenter {

    private PlacesLoading mPlacesLoading;
    private MainMapScreenView mMainMapScreenView = null;
    private Disposable mDisposable;
    private LatLng mCityCoordinates = new LatLng(59.930070,30.318968);
    private float mZoom = 10;

    @Inject
    public MainMapPresenter(PlacesLoading placesLoading){
        mPlacesLoading = placesLoading;
    }

    void subscribe(MainMapScreenView view){
        mMainMapScreenView = view;

    }

    void unsubscribe(){
        mMainMapScreenView = null;
        if(mDisposable != null) {
            mDisposable.dispose();
        }
    }

    void callSheetWithShortInfoAboutPoint(String placeId){
        mMainMapScreenView.callBottomSheet(placeId);
    }

    void loadPlacesToMap(){
        Log.i("MAP_INITIALIZATION","loading_launched");
       mDisposable = mPlacesLoading.getPlaces()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Place>>() {
                    @Override
                    public void onSuccess(List<Place> places) {
                        mMainMapScreenView.loadDataInMap(places);
                        Log.i("MAP_INITIALIZATION","loading_launched_successful");
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.i("MAP_INITIALIZATION","loading_launched_error " + e);
                    }
        });
    }

    void setMapCamera(){
        LatLng coordinates = mCityCoordinates;
        float zoom = mZoom;
        mMainMapScreenView.setMapCamera(coordinates,zoom);
    }
}
