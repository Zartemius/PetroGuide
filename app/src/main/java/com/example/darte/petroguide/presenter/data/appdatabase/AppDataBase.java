package com.example.darte.petroguide.presenter.data.appdatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.darte.petroguide.presenter.domain.model.Place;

@Database(entities = {Place.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract PlaceDao placeDao();
}
