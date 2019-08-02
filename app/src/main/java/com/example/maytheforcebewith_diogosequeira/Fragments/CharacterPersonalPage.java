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

import org.w3c.dom.Text;


public class CharacterPersonalPage extends Fragment {

    private TextView name, eye, birth, mass, height, skin, gender, hair, homeworld;

    public CharacterPersonalPage() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_people_personal, container, false);



        initViews(v);
        bundleSetters();


        return v;
    }

    private void initViews(View v){
        name = v.findViewById(R.id.name);
        eye = v.findViewById(R.id.eyeColor);
        birth = v.findViewById(R.id.birthyear);
        mass = v.findViewById(R.id.mass);
        height = v.findViewById(R.id.height);
        skin = v.findViewById(R.id.skinColor);
        gender = v.findViewById(R.id.gender);
        hair = v.findViewById(R.id.hairCol);
        homeworld = v.findViewById(R.id.hometown);
    }

    private void bundleSetters(){
        String textName = getArguments().getString("Titulo");
        name.setText(textName);

        String eyeColor = getArguments().getString("eyecolor");
        eye.setText("Eye Color: " + eyeColor);

        String birthday = getArguments().getString("birth");
        birth.setText("Birthday: " + birthday);

        String massa = getArguments().getString("mass");
        mass.setText("Mass: " + massa);

        String heightChar = getArguments().getString("height");
        height.setText("Height " + heightChar);

        String skinChar = getArguments().getString("skin");
        skin.setText("Skin Color: " + skinChar);

        String genderChar = getArguments().getString("gender");
        gender.setText("Gender: " + genderChar);

        String hairChar = getArguments().getString("hair");
        hair.setText("Hair: " + hairChar);

        String homeChar = getArguments().getString("homeworld");
        homeworld.setText("Home: " + homeChar);

    }

    }


