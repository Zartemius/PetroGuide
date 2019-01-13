package com.example.darte.petroguide.presenter.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
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
