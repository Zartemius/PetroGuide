package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.presentation.mainscreen.BottomSheet;
import com.example.darte.petroguide.presenter.presentation.mainscreen.MainMapScreen;
import com.example.darte.petroguide.presenter.presentation.splashscreen.SplashScreenActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class,
                      PresenterModule.class,
                      DaoModule.class,
                      PlacesDbModule.class,
                      InteractorModule.class,
                      AppDataBaseModule.class,
                      NavigationModule.class,})

public interface AppComponent {
    void inject(MainMapScreen fragment);
    void inject(SplashScreenActivity splashScreenActivity);
    void inject(BottomSheet bottomSheetFragment);
}
