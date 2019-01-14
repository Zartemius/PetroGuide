package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.data.clouddatabase.PlacesCloudDb;
import com.example.darte.petroguide.presenter.data.appdatabase.PlaceDao;
import com.example.darte.petroguide.presenter.data.appdatabase.PlacesAppDb;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PlacesDbModule {

    @Singleton
    @Provides
    PlacesAppDb providesPlacesDb(PlaceDao placeDao){
        PlacesAppDb placesAppDb = new PlacesAppDb(placeDao);
        return placesAppDb;
    }

    @Singleton
    @Provides
    PlacesCloudDb providePlacesCloudDb(){
        PlacesCloudDb placesCloudDb = new PlacesCloudDb();
        return placesCloudDb;
    }
}
