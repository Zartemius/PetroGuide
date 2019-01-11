package com.example.darte.petroguide.presenter.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.Single;

import java.util.List;

@Dao
public interface PlaceDao  {

    @Query(value="SELECT*FROM places")
    List<Place> getAllPlaces();

    @Insert
    Single<Long> insert(Place place);
}
