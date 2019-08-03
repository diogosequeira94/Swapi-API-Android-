package com.example.maytheforcebewith_diogosequeira.Utils;


import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.maytheforcebewith_diogosequeira.Fragments.HomeFragment;
import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerViewAdapter;
import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterItem;
import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterRecycler;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritesFragment extends Fragment {

    private static ArrayList<CharacterRecycler> favourits = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView backButtonFav;


    public FavouritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);

            recyclerView = view.findViewById(R.id.favrecyclerView);
            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getContext());
            adapter = new RecyclerViewAdapter(favourits);

            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setAdapter(adapter);

            backButtonFav = view.findViewById(R.id.backButtonfav);

            backButtonFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    homeFragment();
                }
            });

        return  view;


    }


    public static ArrayList<CharacterRecycler> getFavourists() {
        return favourits;
    }

    private void homeFragment(){

        FragmentTransaction fragmentTransaction5 = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction5.addToBackStack(null);
        fragmentTransaction5.replace(R.id.main_container, new HomeFragment());
        fragmentTransaction5.commit();

    }
}
