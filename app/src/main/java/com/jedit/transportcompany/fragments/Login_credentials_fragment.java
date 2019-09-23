package com.jedit.transportcompany.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.jedit.transportcompany.R;
import com.jedit.transportcompany.activities.Dashboard;
import com.jedit.transportcompany.activities.LoginActivity;
import com.jedit.transportcompany.common;

import java.util.Objects;

public class Login_credentials_fragment extends Fragment implements View.OnClickListener{

    private View view;
    private TextInputEditText et_login_email, et_login_password;
    private ProgressBar probar_cred_login;
    private TextInputLayout input_login_password;


    //==========================================ON CREATE===========================================
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null){
            view = inflater.inflate(R.layout.frag_credentials_input,container,false);

            probar_cred_login = view.findViewById(R.id.probar_cred_login);
            et_login_password = view.findViewById(R.id.et_login_password);
            et_login_email = view.findViewById(R.id.et_login_email);
            input_login_password = view.findViewById(R.id.input_login_password);

            et_login_password.setOnFocusChangeListener((v, hasFocus)
                    -> input_login_password.setPasswordVisibilityToggleEnabled(hasFocus));

            Button bt_login = view.findViewById(R.id.bt_login);

            bt_login.setOnClickListener(this);
        }



        return view;
    }
    //==========================================ON CREATE===========================================

    //----------------------------------------------OVERRIDE METHODS--------------------------------
    @Override
    public void onClick(View v) {
        test_input();
    }
    //----------------------------------------------OVERRIDE METHODS--------------------------------

    //==-=-=-=-=-=-=-=-==-=-=-=-=-=-=-==-=-=-=-=-=-DEFINED METHODS-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    private void test_input(){

        if (et_login_email.getText() != null &&
                (!et_login_email.getText().toString().contains("@") || et_login_email.getText().toString().isEmpty())){
            common.Mysnackbar(getView(),"Enter Valid Email", Snackbar.LENGTH_SHORT).show();
        }else if (et_login_password.getText() != null &&
                (et_login_password.getText().toString().isEmpty() || et_login_password.getText().toString().equals(""))){
            common.Mysnackbar(getView(),"Enter Password", Snackbar.LENGTH_SHORT).show();
        }else {
            login_with_credentials(et_login_email.getText().toString(),et_login_password.getText().toString());
        }
    }

    private void login_with_credentials(final String email, String password) {

        probar_cred_login.setVisibility(View.VISIBLE);

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(Objects.requireNonNull(getActivity()), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        if (getActivity() instanceof LoginActivity){
                            SharedPreferences.Editor prefEditor = common.app_pref(getActivity().getApplicationContext()).edit();
                            prefEditor.putString(common.COMP_STATE,common.STATE_SETUP).apply();
                            ((LoginActivity) getActivity()).loadCompDetails_frag();
                        }
                        //Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        probar_cred_login.setVisibility(View.INVISIBLE);
                        probar_cred_login.clearAnimation();

                    } else {

                        // If sign in fails, display a message to the user.
                        if (task.getException() instanceof FirebaseAuthInvalidUserException) {

                            common.Mysnackbar(getView(), "Invalid Email Address",
                                    Snackbar.LENGTH_SHORT).show();

                            probar_cred_login.setVisibility(View.INVISIBLE);
                            probar_cred_login.clearAnimation();

                        } else if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {

                            common.Mysnackbar(getView(), "Wrong Password",
                                    Snackbar.LENGTH_SHORT).show();

                            probar_cred_login.setVisibility(View.INVISIBLE);
                            probar_cred_login.clearAnimation();
                        }


                    }

                });

    }

    //==-=-=-=-=-=-=-=-==-=-=-=-=-=-=-==-=-=-=-=-=-DEFINED METHODS-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private void toDashboard() {
        Intent dash_intent = new Intent(getContext(), Dashboard.class);
        startActivity(dash_intent);

        if (getActivity() != null){
            getActivity().finish();
        }
    }
}
