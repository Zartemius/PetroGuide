package com.example.darte.petroguide.presenter.domain.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import com.google.android.gms.maps.model.LatLng;

@Entity(tableName = "places")
public class Place {

    @ColumnInfo(name="unique_id")
    String uniqueId;

    @ColumnInfo(name="name")
    String name;

    @ColumnInfo(name="description")
    String description;

    @ColumnInfo(name="location")
    LatLng location;

    @ColumnInfo(name="address")
    String address;

    @ColumnInfo(name="picture_url")
    String pictureUrl;
}
