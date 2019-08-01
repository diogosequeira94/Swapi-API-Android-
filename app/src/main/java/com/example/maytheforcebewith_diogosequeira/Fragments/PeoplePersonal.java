package com.example.maytheforcebewith_diogosequeira.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maytheforcebewith_diogosequeira.R;



public class PeoplePersonal extends Fragment {

    public PeoplePersonal() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_people_personal, container, false);

        TextView name = v.findViewById(R.id.name);

        //TextView description = v.findViewById(R.id.);

      //  String description = getArguments().getString("Descricao");
        // description.setText(textDescri);

        String textName = getArguments().getString("Titulo");
        name.setText(textName);


        return v;
    }

    }


