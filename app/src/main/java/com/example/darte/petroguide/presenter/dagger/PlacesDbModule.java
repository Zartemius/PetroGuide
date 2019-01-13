package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.data.database.PlaceDao;
import com.example.darte.petroguide.presenter.data.database.PlacesDb;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PlacesDbModule {

    @Singleton
    @Provides
    PlacesDb providesPlacesDb(PlaceDao placeDao){
        PlacesDb placesDb = new PlacesDb(placeDao);
        return placesDb;
    }
}
