package com.example.track;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDao {

    @Query("select * from data")
    List<Data> getalldata();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert  (Data data);

    @Delete
    void delete(Data data);
}
