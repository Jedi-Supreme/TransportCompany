package com.jedit.transportcompany.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jedit.transportcompany.R;
import com.jedit.transportcompany.fragments.Login_credentials_fragment;
import com.jedit.transportcompany.models.Passenger;

public class LoginActivity extends AppCompatActivity {

    //============================================ON CREATE=========================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);

        load_credentialsFragment();
    }
    //============================================ON CREATE=========================================

    //-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-OVERRIDE METHODS-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    @Override
    protected void onResume() {
        super.onResume();

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
        frag_transact.replace(R.id.login_frag_container,loginCredentialsFragment);
        frag_transact.commit();
    }

    /*public void loadUser_frag(){
        User_Details_fragment userDetailsFragment = new User_Details_fragment();
        FragmentManager frag_manager = getSupportFragmentManager();
        frag_manager.popBackStack();
        FragmentTransaction frag_transact = frag_manager.beginTransaction();
        frag_transact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        frag_transact.replace(R.id.login_frag_container,userDetailsFragment);
        frag_transact.commit();
    }*/
    //-----------------------------------------------DEFINED METHODS--------------------------------

}
