package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.map.MapFragment;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class,
                      PresenterModule.class})

public interface AppComponent {
    void inject(MapFragment fragment);
}
