package com.example.maytheforcebewith_diogosequeira.Retrofit;

import android.widget.ImageView;

public class CharacterRecycler {

    private String name;
    private int image;

    public CharacterRecycler(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
