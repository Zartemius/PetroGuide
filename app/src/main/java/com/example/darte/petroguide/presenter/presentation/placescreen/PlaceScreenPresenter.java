package com.example.darte.petroguide.presenter.presentation.placescreen;

import com.example.darte.petroguide.presenter.domain.interactor.PlacesLoading;
import io.reactivex.disposables.CompositeDisposable;

public class PlaceScreenPresenter {

    private PlaceScreenView mPlaceScreenView;
    private PlacesLoading mPlaceLoading;
    private CompositeDisposable mCompositeDisposable;

    private void subscribe(PlaceScreenView placeScreenView, PlacesLoading placesLoading,
                           CompositeDisposable compositeDisposable){
        mPlaceScreenView = placeScreenView;
        mPlaceLoading = placesLoading;
        mCompositeDisposable = compositeDisposable;
    }

    private void unsubscribe(){
        mPlaceScreenView = null;
    }


}
