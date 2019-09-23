package com.jedit.transportcompany.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jedit.transportcompany.R;
import com.jedit.transportcompany.common;
import com.jedit.transportcompany.fragments.Company_details_fragment;
import com.jedit.transportcompany.fragments.Login_credentials_fragment;
import com.jedit.transportcompany.models.Passenger;

public class LoginActivity extends AppCompatActivity {

    //============================================ON CREATE=========================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);
        //load_credentialsFragment();
    }
    //============================================ON CREATE=========================================

    //-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-OVERRIDE METHODS-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    @Override
    protected void onResume() {
        super.onResume();

        String appState = common.app_pref(getApplicationContext()).getString(common.COMP_STATE,common.STATE_LOGIN);

        if (appState != null && appState.equals(common.STATE_LOGIN)){
            load_credentialsFragment();
        }else if (appState != null && appState.equals(common.STATE_SETUP)) {
            loadCompDetails_frag();
        }

    }

    //-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-OVERRIDE METHODS-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    //-----------------------------------------------DEFINED METHODS--------------------------------
    public void pass_data_toFragment(Fragment fragment, String phoneNumber){
        Bundle bundle = new Bundle();
        bundle.putString(Passenger.COLUMN_PHONE_NUMBER,phoneNumber);
        fragment.setArguments(bundle);

        FragmentManager frag_manager = getSupportFragmentManager();
        FragmentTransaction frag_transact = frag_manager.beginTransaction();
        frag_transact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        frag_transact.replace(R.id.login_frag_container,fragment);
        frag_transact.addToBackStack(null);
        frag_transact.commit();
    }

    public void load_credentialsFragment(){
        Login_credentials_fragment loginCredentialsFragment = new Login_credentials_fragment();
        FragmentManager frag_manager = getSupportFragmentManager();
        FragmentTransaction frag_transact = frag_manager.beginTransaction();
        frag_transact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        frag_transact.replace(R.id.login_frag_container,loginCredentialsFragment,"credentials");
        frag_transact.commit();
    }

    public void loadCompDetails_frag(){
        Company_details_fragment compDetailsFragment = new Company_details_fragment();
        FragmentManager frag_manager = getSupportFragmentManager();
        frag_manager.popBackStack();
        FragmentTransaction frag_transact = frag_manager.beginTransaction();
        frag_transact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        frag_transact.replace(R.id.login_frag_container,compDetailsFragment,"details");
        frag_transact.commit();
    }
    //-----------------------------------------------DEFINED METHODS--------------------------------

}
