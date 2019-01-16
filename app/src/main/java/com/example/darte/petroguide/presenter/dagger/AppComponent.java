package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.presentation.splashscreen.SplashScreenActivity;
import com.example.darte.petroguide.presenter.presentation.mainscreen.MapFragment;
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
    void inject(MapFragment fragment);
    void inject(SplashScreenActivity splashScreenActivity);
}
