package com.example.darte.petroguide.presenter.domain.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import com.google.android.gms.maps.model.LatLng;
import org.jetbrains.annotations.NotNull;

@Entity(tableName = "places")
public class Place {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name="unique_id")
    private String uniqueId;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="description")
    private String description;

    @ColumnInfo(name="location")
    private LatLng location;

    @ColumnInfo(name="address")
    private String address;

    @ColumnInfo(name="picture_url")
    private String pictureUrl;

    @NotNull
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(@NotNull String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
