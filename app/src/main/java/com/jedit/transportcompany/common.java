package com.jedit.transportcompany;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class common {

    public static String COMP_STATE = "Comp_state";
    public static String STATE_LOGIN = "logging_in";
    public static String STATE_SETUP = "setting_up";
    public static String STATE_COMPLETE = "completed_setup";

    public static String time_to_date(String timeMillis){

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(Long.parseLong(timeMillis));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());

        return  simpleDateFormat.format(calendar.getTime());
    }

    public static SharedPreferences app_pref(Context context){
        return context.getSharedPreferences("Trans_comp_pref",Context.MODE_PRIVATE);
    }

    public static Snackbar Mysnackbar(View parent_view, String message, int lenght) {

        final Snackbar snackbar = Snackbar.make(parent_view, message, lenght);
        snackbar.setActionTextColor(parent_view.getContext().getResources().getColor(R.color.colorPrimary));
        snackbar.setAction("Close", v -> snackbar.dismiss());

        return snackbar;
    }
}
