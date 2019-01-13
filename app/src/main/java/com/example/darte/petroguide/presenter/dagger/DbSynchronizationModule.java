package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.data.DbSynchronization;
import com.example.darte.petroguide.presenter.data.database.PlacesDb;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DbSynchronizationModule {

    @Singleton
    @Provides
    DbSynchronization provideDbSynchronization(PlacesDb placesDb){
        DbSynchronization dbSynchronization = new DbSynchronization(placesDb);
        return dbSynchronization;
    }
}
