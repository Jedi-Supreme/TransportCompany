package com.jedit.transportcompany.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.jedit.transportcompany.R;
import com.jedit.transportcompany.common;

import java.lang.ref.WeakReference;

public class Dashboard extends AppCompatActivity {

    WeakReference<Dashboard> weak_dash;

    //==============================================ON CREATE=======================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        weak_dash = new WeakReference<>(this);

        String appState = common.app_pref(getApplicationContext()).getString(common.COMP_STATE,common.STATE_LOGIN);

        if (FirebaseAuth.getInstance().getCurrentUser() == null){
            toLogin();
        }else if (appState != null && appState.equals(common.STATE_LOGIN)) {
            toLogin();
            //TODO FIX LOGIN LOGIC
        }else if (appState!= null && appState.equals(common.STATE_COMPLETE)){
            init();
        }

    }
    //==============================================ON CREATE=======================================

    //---------------------------------------------DEFINED METHODS----------------------------------
    void init(){
        //TODO initialise everything here
    }
    //---------------------------------------------DEFINED METHODS----------------------------------

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=INTENTS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    void toLogin(){
        Intent login_intent = new Intent(getApplicationContext(), LoginActivity.class);
        login_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(login_intent);
        finish();
    }
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=INTENTS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}
