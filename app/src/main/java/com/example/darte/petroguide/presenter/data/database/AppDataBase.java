package com.example.darte.petroguide.presenter.data.database;


import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

//add database identifier
public abstract class AppDataBase extends RoomDatabase {

    public abstract PlaceDao placeDao();

    private static volatile AppDataBase INSTANCE;

    public static AppDataBase getDataBase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDataBase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,"app_data_base").build();
                }
            }
        }

        return INSTANCE;
    }

}
