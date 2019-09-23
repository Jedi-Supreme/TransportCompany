package com.jedit.transportcompany.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jedit.transportcompany.fragments.Company_details_fragment;
import com.jedit.transportcompany.interfaces.company_DAO;
import com.jedit.transportcompany.models.Passenger;
import com.jedit.transportcompany.models.Transport_company;

@Database(entities = {Passenger.class, Transport_company.class},exportSchema = false, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "Company_DB";

    private static AppDatabase appDB_instance;

    public static AppDatabase getInstance(Context context){

        if (appDB_instance == null){

            appDB_instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return appDB_instance;
    }

    public abstract company_DAO companyDao();

}
