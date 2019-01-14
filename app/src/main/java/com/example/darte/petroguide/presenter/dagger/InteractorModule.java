package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.data.clouddatabase.PlacesCloudDb;
import com.example.darte.petroguide.presenter.data.appdatabase.PlacesAppDb;
import com.example.darte.petroguide.presenter.domain.interactor.DbSynchronization;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class InteractorModule {

    @Singleton
    @Provides
    DbSynchronization provideDbSynchronization(PlacesAppDb placesAppDb, PlacesCloudDb placesCloudDb){
        DbSynchronization dbSynchronization = new DbSynchronization(placesAppDb,placesCloudDb);
        return dbSynchronization;
    }
}
