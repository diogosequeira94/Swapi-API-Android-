package com.example.maytheforcebewith_diogosequeira.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.Retrofit.CharacterRecycler;
import com.example.maytheforcebewith_diogosequeira.Utils.FavouritesFragment;


public class CharacterPersonalPage extends Fragment {

    private TextView name, eye, birth, mass, height, skin, gender, hair, homeworld;
    private ImageView favouriteIcon, backButton;
    private Button sendPost;
    private boolean isToggle;
    private String novoNome;

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

                    // I need to get all the favourite Chars in Favourites Fragment and display them in a list

                    if(!sameName(novoNome)){

                        FavouritesFragment.getFavourists().add(new CharacterRecycler(R.drawable.yoda, novoNome));
                        System.out.println(novoNome);
                        System.out.println(FavouritesFragment.getFavourists().size());
                        isToggle = true;

                    } else {

                        Toast.makeText(getContext(), "Already added before!", Toast.LENGTH_SHORT);
                    }


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

        Bundle bundle = getArguments();

        if(bundle != null){


            //Here I check if bundle is coming via search or recyclerView index

                if(bundle.size() == 2){

                    String nome = getArguments().getString("newname");
                    name.setText(nome);

                    String details = getArguments().getString("details");
                    birth.setText("Full details:\n\n" + details);

                    invisible();

                } else {

                    String nome = getArguments().getString("Titulo");
                    novoNome = getArguments().getString("Titulo");
                    name.setText(nome);

                    String birthday = getArguments().getString("birth");
                    birth.setText("Birthday: " + birthday);

                    String eyeColor = getArguments().getString("eyecolor");
                    eye.setText("Eye Color: " + eyeColor);

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


    }


    private void backTransaction(){

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.main_container, new ListFragment());
        fragmentTransaction.commit();

    }

    private void invisible(){

        eye.setVisibility(View.GONE);
        mass.setVisibility(View.GONE);
        height.setVisibility(View.GONE);
        skin.setVisibility(View.GONE);
        gender.setVisibility(View.GONE);
        hair.setVisibility(View.GONE);
        homeworld.setVisibility(View.GONE);

    }


    // Method to check if there is an object with same name on the ArrayList
    private boolean sameName(String name){

        if(FavouritesFragment.getFavourists().size() != 0){
            for(int i = 0; i < FavouritesFragment.getFavourists().size(); i++){

                if(FavouritesFragment.getFavourists().get(i).getName().equals(name)){

                    System.out.println("It has the same name");
                    return true;
                }
            }
        }


        return false;
    }


    }


