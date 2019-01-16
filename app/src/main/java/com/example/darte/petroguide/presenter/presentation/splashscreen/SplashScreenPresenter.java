package com.example.darte.petroguide.presenter.presentation.splashscreen;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.interactor.DbSynchronization;
import com.example.darte.petroguide.presenter.domain.model.Place;
import com.example.darte.petroguide.presenter.navigation.SplashScreenRouter;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Navigator;
import javax.inject.Inject;
import java.util.List;

public class SplashScreenPresenter {

    private DbSynchronization mDbSynchronization;
    private SplashActivityView mSplashActivityView = null;
    private Disposable mDisposable;
    private SplashScreenRouter mSplashScreenRouter;

    @Inject
    public SplashScreenPresenter(DbSynchronization dbSynchronization, SplashScreenRouter splashScreenRouter) {
        mDbSynchronization = dbSynchronization;
        mSplashScreenRouter = splashScreenRouter;
    }

    void subscribe(SplashActivityView splashActivityView) {
        mSplashActivityView = splashActivityView;
    }

    void unsubscribe() {
        mSplashActivityView = null;
        mDisposable.dispose();
    }

    void setNavigator(Navigator navigator) {
        mSplashScreenRouter.setNavigator(navigator);
    }

    void removeNavigator() {
        mSplashScreenRouter.removeNavigator();
    }

    void onBackPressed() {
        mSplashScreenRouter.navigateBack();
    }

    void updateDataInDb() {
        mDisposable = mDbSynchronization.loadPlacesFromServer()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Place>>() {
                    @Override
                    public void onSuccess(List<Place> places) {
                        mDbSynchronization.synchronizeAppDbWithCloudDbAsyn(places).subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableCompletableObserver() {
                            @Override
                            public void onComplete() {
                                mSplashScreenRouter.navigateForward();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }
}

