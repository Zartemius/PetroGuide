package com.example.darte.petroguide.presenter.presentation.mainscreen;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.interactor.PlacesLoading;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

public class BottomSheetPresenter {

    private PlacesLoading mPlaceLoading;
    private BottomSheetView mBottomSheetView;
    private Disposable mDisposable;

    @Inject
    public BottomSheetPresenter(PlacesLoading placesLoading){
        mPlaceLoading = placesLoading;
    }

    public void subscribe(BottomSheetView bottomSheetView){
        Log.i("BOTTOM_VIEW","result subscribed");
        mBottomSheetView = bottomSheetView;
        Log.i("BOTTOM_VIEW","result subscribed object" + mBottomSheetView.toString());

    }

    public void unsubscribe(){
        mBottomSheetView = null;
        Log.i("BOTTOM_VIEW","result unsubscribed");
        if(mDisposable != null) {
            mDisposable.dispose();
        }
    }

    public void displayInformationAboutPlace(){
        Log.i("BOTTOM_VIEW","result" + mBottomSheetView.toString());
        String placeId = mBottomSheetView.getPlaceId();

        mDisposable = mPlaceLoading.getCertainPlace(placeId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Place>() {
                            @Override
                            public void onSuccess(Place place) {
                                mBottomSheetView.displayInfoAboutThePlace(place);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                });
    }
}
