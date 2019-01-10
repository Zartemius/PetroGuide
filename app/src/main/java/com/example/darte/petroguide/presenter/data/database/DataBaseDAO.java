package com.example.darte.petroguide.presenter.data.database;

import android.arch.persistence.room.*;

@Dao
interface DataBaseDAO<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(T t);

    @Delete
    void delete(T t);

    @Update
    void update(T t);
}
