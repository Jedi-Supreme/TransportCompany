package com.jedit.transportcompany.models;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = Transport_company.TABLE,indices =
        {@Index(value = Transport_company.COLUMN_FIRE_ID,unique = true)})

public class Transport_company {

    public static final String TABLE = "TRANSPORT_COMPANY";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TRANS_TYPE = "transport_type";
    public static final String COLUMN_FIRE_ID = "firebase_id";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = COLUMN_NAME)
    private String company_name;

    @ColumnInfo(name = COLUMN_TRANS_TYPE)
    private int transport_type;

    @ColumnInfo(name = COLUMN_FIRE_ID)
    private String comp_fire_ID;

    @Embedded
    private Contact_details contact_details;

    public Transport_company() {
    }

    public Transport_company(String company_name, int transport_type, String comp_fire_ID) {
        this.company_name = company_name;
        this.transport_type = transport_type;
        this.comp_fire_ID = comp_fire_ID;
    }

    //Contact details constructor
    public Transport_company(String comp_fire_ID, Contact_details contact_details) {
        this.comp_fire_ID = comp_fire_ID;
        this.contact_details = contact_details;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(int transport_type) {
        this.transport_type = transport_type;
    }

    public String getComp_fire_ID() {
        return comp_fire_ID;
    }

    public void setComp_fire_ID(String comp_fire_ID) {
        this.comp_fire_ID = comp_fire_ID;
    }

    public Contact_details getContact_details() {
        return contact_details;
    }

    public void setContact_details(Contact_details contact_details) {
        this.contact_details = contact_details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
