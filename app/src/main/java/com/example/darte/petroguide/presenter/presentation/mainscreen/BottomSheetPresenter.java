package com.example.darte.petroguide.presenter.presentation.mainscreen;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.interactor.PlacesLoading;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.example.darte.petroguide.presenter.navigation.BottomSheetRouter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Navigator;
import javax.inject.Inject;

public class BottomSheetPresenter {

    private PlacesLoading mPlaceLoading;
    private BottomSheetView mBottomSheetView;
    private Disposable mDisposable;
    private BottomSheetRouter mBottomSheetRouter;

    @Inject
    public BottomSheetPresenter(PlacesLoading placesLoading, BottomSheetRouter bottomSheetRouter){
        mPlaceLoading = placesLoading;
        mBottomSheetRouter = bottomSheetRouter;
    }

    void subscribe(BottomSheetView bottomSheetView){
        mBottomSheetView = bottomSheetView;
    }

    void unsubscribe(){
        mBottomSheetView = null;
        if(mDisposable != null) {
            mDisposable.dispose();
        }
    }

    void navigateForward(){
        String placeId = mBottomSheetView.getPlaceId();
        mBottomSheetRouter.navigateForward(placeId);
    }

    public void navigateBack(){
        mBottomSheetRouter.navigateBack();
    }

    void setNavigator(Navigator navigator){
        mBottomSheetRouter.setNavigator(navigator);
    }

    void removeNavigator(){
        mBottomSheetRouter.removeNavigator();
    }

    void displayInformationAboutPlace(){
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
