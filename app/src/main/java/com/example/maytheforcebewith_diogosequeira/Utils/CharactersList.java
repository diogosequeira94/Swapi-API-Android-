package com.example.maytheforcebewith_diogosequeira.Utils;

import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.RecyclerViewCharacters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CharactersList {

    private ArrayList<RecyclerViewCharacters> displayPeople = new ArrayList<>();


    private void populateArray(){

        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Diogo Sequeira"));
        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Tiago Valente"));
        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Pedro Lima"));
        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Rui Frade"));
        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Tiago Santos"));
        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Amilcar Sequeira"));
        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Rodolfo Valente"));
        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Junior Lima"));
        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Miguel Gaspar"));
        displayPeople.add(new RecyclerViewCharacters(R.drawable.ic_launcher_foreground, "Zori Lemar"));


        Collections.sort(displayPeople, new Comparator<RecyclerViewCharacters>() {
            @Override
            public int compare(RecyclerViewCharacters person1, RecyclerViewCharacters person2) {
                return person1.getName().compareTo(person2.getName());
            }
        });


    }

    public ArrayList<RecyclerViewCharacters> giveArray(){

        populateArray();

        return displayPeople;
    }

    public ArrayList<RecyclerViewCharacters> getDisplayPeople() {
        return displayPeople;
    }
}