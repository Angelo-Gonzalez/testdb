package com.example.testdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoUser {
    @Query("SELECT * FROM user")
    List<User> obtenerUser();

    @Query("SELECT * FROM user WHERE user= :user")
    User obtenerUser(String user);

    @Insert
    void insertarUser(User...users);

    @Query("UPDATE User SET password = :password WHERE user = :user")
    void actualizaruser(String user, String password);

    @Query("DELETE FROM user WHERE user= :user")
    void borrarUser(String user);
}
