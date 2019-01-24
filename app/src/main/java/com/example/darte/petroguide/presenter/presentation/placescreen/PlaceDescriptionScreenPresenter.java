package com.example.darte.petroguide.presenter.presentation.placescreen;

public class PlaceDescriptionScreenPresenter {

    private PlaceDescriptionScreenView mPlaceDescriptionScreenView;

    public void subscribe(PlaceDescriptionScreenView placeDescriptionScreenView){
        mPlaceDescriptionScreenView = placeDescriptionScreenView;
    }

    public void unsubscribe(){
        mPlaceDescriptionScreenView = null;
    }
}
