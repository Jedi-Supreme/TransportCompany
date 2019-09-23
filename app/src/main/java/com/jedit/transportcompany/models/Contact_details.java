package com.jedit.transportcompany.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;


public class Contact_details {

    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_WEBSITE = "website";
    public static final String COLUMN_NUMBER = "phone_number";
    public static final String COLUMN_EMAIL = "email_address";

    @ColumnInfo(name = COLUMN_DESCRIPTION)
    private String comp_description;

    @ColumnInfo(name = COLUMN_WEBSITE)
    private String comp_website;

    @ColumnInfo(name = COLUMN_NUMBER)
    private String comp_number;

    @ColumnInfo(name = COLUMN_EMAIL)
    private String comp_email;

    public Contact_details(String comp_description, String comp_website, String comp_number, String comp_email) {
        this.comp_description = comp_description;
        this.comp_website = comp_website;
        this.comp_number = comp_number;
        this.comp_email = comp_email;
    }

    public String getComp_description() {
        return comp_description;
    }

    public void setComp_description(String comp_description) {
        this.comp_description = comp_description;
    }

    public String getComp_website() {
        return comp_website;
    }

    public void setComp_website(String comp_website) {
        this.comp_website = comp_website;
    }

    public String getComp_number() {
        return comp_number;
    }

    public void setComp_number(String comp_number) {
        this.comp_number = comp_number;
    }

    public String getComp_email() {
        return comp_email;
    }

    public void setComp_email(String comp_email) {
        this.comp_email = comp_email;
    }
}
