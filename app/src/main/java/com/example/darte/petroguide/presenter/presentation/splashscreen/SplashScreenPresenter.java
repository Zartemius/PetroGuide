package com.example.darte.petroguide.presenter.presentation.splashscreen;

import com.example.darte.petroguide.presenter.domain.interactor.DbSynchronization;
import com.example.darte.petroguide.presenter.navigation.SplashScreenRouter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ru.terrakok.cicerone.Navigator;
import javax.inject.Inject;

public class SplashScreenPresenter {

    private DbSynchronization mDbSynchronization;
    private SplashActivityView mSplashActivityView = null;
    private Disposable mDisposable;
    private SplashScreenRouter mSplashScreenRouter;

    @Inject
    public SplashScreenPresenter(DbSynchronization dbSynchronization, SplashScreenRouter splashScreenRouter){
       mDbSynchronization = dbSynchronization;
       mSplashScreenRouter = splashScreenRouter;
    }

    void subscribe(SplashActivityView splashActivityView){
        mSplashActivityView = splashActivityView;
    }

    void unsubscribe(){
        mSplashActivityView = null;
        mDisposable = null;
    }

    void setNavigator(Navigator navigator){
        mSplashScreenRouter.setNavigator(navigator);
    }

    void removeNavigator(){
        mSplashScreenRouter.removeNavigator();
    }

    void onBackPressed(){
        mSplashScreenRouter.navigateBack();
    }

    void updateDataInDb(){
       mDisposable = mDbSynchronization.synchronizeAppDbWithCloudDbAsync()
               .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Boolean>() {
           @Override
           public void accept(Boolean result) throws Exception {
                boolean dataWasSynchronized = result;
                if(dataWasSynchronized){
                    mSplashScreenRouter.navigateForward();
                }
           }
       });
    }
}


