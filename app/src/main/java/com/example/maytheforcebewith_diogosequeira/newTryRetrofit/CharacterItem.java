package com.example.maytheforcebewith_diogosequeira.newTryRetrofit;

public class CharacterItem {

    private String name;
    private String birthyear;
    private String eyeColor;
    private String gender;
    private String hairColor;
    private String mass;
    private String height;
    private String skinColor;
    private String homeWorld;

    public CharacterItem(String name, String birthyear, String eyeColor, String gender, String hairColor, String mass, String height, String skinColor, String homeWorld) {

        this.name = name;
        this.birthyear = birthyear;
        this.eyeColor = eyeColor;
        this.gender = gender;
        this.hairColor = hairColor;
        this.mass = mass;
        this.height = height;
        this.skinColor = skinColor;
        this.homeWorld = homeWorld;
    }

    public String getName() {
        return name;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getMass() {
        return mass;
    }

    public String getHeight() {
        return height;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getHomeWorld() {
        return homeWorld;
    }
}
