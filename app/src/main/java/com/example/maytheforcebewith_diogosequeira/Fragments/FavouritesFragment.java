package com.example.maytheforcebewith_diogosequeira.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterItem;
import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterRecycler;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritesFragment extends Fragment {

    private static ArrayList<CharacterRecycler> favourits = new ArrayList<>();


    public FavouritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourites, container, false);
    }

    public static ArrayList<CharacterRecycler> getFavourists() {
        return favourits;
    }
}
