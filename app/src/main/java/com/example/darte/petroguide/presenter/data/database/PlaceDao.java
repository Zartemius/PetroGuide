package com.example.darte.petroguide.presenter.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.example.darte.petroguide.presenter.domain.model.Place;

import java.util.List;

@Dao
public interface PlaceDao extends DataBaseDAO<Place> {

    @Query(value="SELECT*FROM places")
    List<Place> getAllPlaces();

}
