package com.jedit.transportcompany.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;

import com.jedit.transportcompany.models.Passenger;
import com.jedit.transportcompany.models.Transport_company;

@Dao
public interface company_DAO {

    //TODO Complete queries

    @Insert
    void insert_company(Transport_company company);

    @Insert
    void insert_passenger(Passenger passenger);
}
