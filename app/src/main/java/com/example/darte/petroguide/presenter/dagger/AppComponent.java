package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.presentation.splashscreen.SplashActivity;
import com.example.darte.petroguide.presenter.presentation.mapscreen.MapFragment;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class,
                      PresenterModule.class,
                      DaoModule.class,
                      PlacesDbModule.class,
                      InteractorModule.class,
                      AppDataBaseModule.class})

public interface AppComponent {
    void inject(MapFragment fragment);
    void inject(SplashActivity splashActivity);
}
