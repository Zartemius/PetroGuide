package com.example.darte.petroguide.presenter.dagger;

import android.app.Application;
import androidx.room.Room;
import com.example.darte.petroguide.presenter.data.DbSynchronization;
import com.example.darte.petroguide.presenter.data.database.AppDataBase;
import com.example.darte.petroguide.presenter.data.database.PlaceDao;
import com.example.darte.petroguide.presenter.data.database.PlacesDb;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Singleton;

@Module
public class RoomModule {



   /* @Singleton
    @Provides
    AppDataBase provideAppDataBase(){
        return DB_INSTANCE;
    }*/

    @Singleton
    @Provides
    PlaceDao providePlaceDao(AppDataBase appDataBase){
        return appDataBase.placeDao();
    }
}
