package com.example.maytheforcebewith_diogosequeira.Fragments;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerViewCharacters;
import com.example.maytheforcebewith_diogosequeira.Utils.Favourites;
import com.example.maytheforcebewith_diogosequeira.newTryRetrofit.CharacterItem;
import com.example.maytheforcebewith_diogosequeira.newTryRetrofit.CharacterRecycler;

import org.w3c.dom.Text;


public class CharacterPersonalPage extends Fragment {

    private TextView name, eye, birth, mass, height, skin, gender, hair, homeworld;
    private ImageView favouriteIcon, backButton;
    private Button sendPost;
    private boolean isToggle;
    private Favourites favourites = new Favourites();

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

        favouriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!isToggle){
                    favouriteIcon.setImageResource(R.drawable.ic_star_black_24dp);
                    Toast.makeText(getContext(), "Added to your favourites!", Toast.LENGTH_SHORT).show();
                    favourites.getFavouritesList().add(new CharacterRecycler(name.toString()));
                    isToggle = true;
                } else {
                    favouriteIcon.setImageResource(R.drawable.ic_star_border_black_24dp);
                    Toast.makeText(getContext(), "Removed from your favourites", Toast.LENGTH_SHORT).show();
                    isToggle = false;
                }
            }
        });

        sendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Post Sent", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            backTransaction();
            }
        });


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
        favouriteIcon = v.findViewById(R.id.favourite);
        sendPost = v.findViewById(R.id.postButton);
        backButton = v.findViewById(R.id.backButton);
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


    private void backTransaction(){

        FragmentManager manager = getActivity().getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.main_container, new ListFragment());
        fragmentTransaction.commit();





    }



    }


