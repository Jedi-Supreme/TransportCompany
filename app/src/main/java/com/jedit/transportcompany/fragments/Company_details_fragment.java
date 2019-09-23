package com.jedit.transportcompany.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.jedit.transportcompany.R;

public class Company_details_fragment extends Fragment {

    private View view;
    private TextInputEditText et_comp_name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null){

            view = inflater.inflate(R.layout.frag_comp_details,container,false);
            et_comp_name = view.findViewById(R.id.et_comp_name);

            //Todo complete saving data to fire base
        }

        return view;
    }
}
