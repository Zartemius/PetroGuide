package com.example.darte.petroguide.presenter.data.appdatabase;

import androidx.room.*;
import com.example.darte.petroguide.presenter.domain.model.Place;
import io.reactivex.Completable;
import io.reactivex.Single;

import java.util.List;

@Dao
public interface PlaceDao  {

    @Query(value="SELECT*FROM places")
    Single<List<Place>> getAllPlaces();

    @Query("DELETE from places WHERE unique_id NOT IN (:placesIdList)")
    void deletePlaceFromDb(List<String> placesIdList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Place> places);
}
