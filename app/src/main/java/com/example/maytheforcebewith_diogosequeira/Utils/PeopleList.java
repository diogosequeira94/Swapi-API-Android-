package com.example.maytheforcebewith_diogosequeira.Utils;

import com.example.maytheforcebewith_diogosequeira.R;
import com.example.maytheforcebewith_diogosequeira.RecyclerView.PeopleItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PeopleList {

    private ArrayList<PeopleItem> displayPeople = new ArrayList<>();


    private void populateArray(){

        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Diogo Sequeira"));
        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Tiago Valente"));
        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Pedro Lima"));
        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Rui Frade"));
        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Tiago Santos"));
        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Amilcar Sequeira"));
        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Rodolfo Valente"));
        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Junior Lima"));
        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Miguel Gaspar"));
        displayPeople.add(new PeopleItem(R.drawable.ic_launcher_foreground, "Zori Lemar"));


        Collections.sort(displayPeople, new Comparator<PeopleItem>() {
            @Override
            public int compare(PeopleItem person1, PeopleItem person2) {
                return person1.getName().compareTo(person2.getName());
            }
        });


    }

    public ArrayList<PeopleItem> giveArray(){

        populateArray();

        return displayPeople;
    }

    public ArrayList<PeopleItem> getDisplayPeople() {
        return displayPeople;
    }
}