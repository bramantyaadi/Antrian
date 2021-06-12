package com.example.antrian;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface userDAO {

    @Query("SELECT * FROM user")
    List<UserData> getAllUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserData... users);

    @Update
    void update(UserData... users);

    @Delete
    void delete(UserData user);

}
