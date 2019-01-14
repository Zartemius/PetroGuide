package com.example.darte.petroguide.presenter.dagger;

import android.content.Context;
import androidx.room.Room;
import com.example.darte.petroguide.presenter.data.appdatabase.AppDataBase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class AppDataBaseModule {

    private static volatile AppDataBase DB_INSTANCE;

    @Singleton
    @Provides
    AppDataBase provideAppDataBase(Context application){
        if(DB_INSTANCE == null){
            synchronized (AppDataBase.class){
                if(DB_INSTANCE == null){
                    DB_INSTANCE = Room.databaseBuilder(application,
                            AppDataBase.class,"app_data_base").build();
                }
            }
        }

        return DB_INSTANCE;
    }
}
