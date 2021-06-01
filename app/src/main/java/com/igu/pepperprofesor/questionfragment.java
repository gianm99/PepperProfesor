package com.igu.pepperprofesor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class questionfragment extends Fragment {


    public questionfragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_question, container, false);
        TextView tv = (TextView) view.findViewById(R.id.preguntaAbierta);
        String strtext = getArguments().getString("edttext");
        tv.setText(strtext);
        return view;
    }
}