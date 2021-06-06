package com.igu.pepperprofesor.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.navigation.Navigation;

import com.igu.pepperprofesor.R;


public class TitleFragment extends Fragment implements  View.OnClickListener{

  ImageButton logo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
       @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_titlefragment, container, false);
        logo = view.findViewById(R.id.logo);
        logo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_titlefragment_to_questionfragment);
    }
}
