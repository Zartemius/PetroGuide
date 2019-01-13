package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.SplashActivity;
import com.example.darte.petroguide.presenter.data.database.PlacesDb;
import com.example.darte.petroguide.presenter.map.MapFragment;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class,
                      PresenterModule.class,
                      RoomModule.class,
                      PlacesDbModule.class,
                      DbSynchronizationModule.class,
                      AppDataBaseModule.class})

public interface AppComponent {

    void inject(MapFragment fragment);
    void inject(SplashActivity splashActivity);
}
