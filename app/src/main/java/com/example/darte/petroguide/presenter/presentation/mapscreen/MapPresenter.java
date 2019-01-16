package com.example.darte.petroguide.presenter.presentation.mapscreen;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.interactor.PlacesLoading;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import java.util.List;

public class MapPresenter {

    private PlacesLoading mPlacesLoading;
    private Disposable mDisposable;
    private MapFragmentView mapFragmentView = null;

    @Inject
    public MapPresenter(PlacesLoading placesLoading){
        mPlacesLoading = placesLoading;
    }

    void subscribe(MapFragmentView view){
        mapFragmentView = view;
        mapFragmentView.checkPermissionForGettingUserLocation();
    }

    void unsubscribe(){
        mapFragmentView = null;
        mDisposable = null;
    }

    void onMapReady(){

       /* List list = new ArrayList<LatLng>();

        LatLng buildingOne = new LatLng(59.96980441,30.30065453);
        LatLng buildingtwo = new LatLng(59.96595386,30.3096571);
        LatLng buildingThree = new LatLng(59.94119134,30.3139143);
        LatLng buildingFour = new LatLng(59.93996605,30.27490854);
        LatLng buildingFive = new LatLng(59.94585345,30.27430773);
        LatLng buildingSix = new LatLng(59.96226343,30.28320837);
        LatLng buildingSeven = new LatLng(60.0282477,30.41184497);

        list.add(buildingOne);
        list.add(buildingtwo);
        list.add(buildingThree);
        list.add(buildingFour);
        list.add(buildingFive);
        list.add(buildingSix);
        list.add(buildingSeven);

        mapFragmentView.loadDataInMap(list);*/
    }

    void callSheetWithShortInfoAboutPoint(){
        mapFragmentView.callBottomSheet();
    }

    void loadPlacesToMap(){
        mDisposable = mPlacesLoading.getPlaces().observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Place>>() {
            @Override
            public void accept(List<Place> places) throws Exception {
                for(Place place:places){
                    Log.i("PLACE_INFO","result " + place.getName());
                }
            }
        });
    }
}
