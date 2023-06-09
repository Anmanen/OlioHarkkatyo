package com.example.lutemon.domain;

import com.example.lutemon.Place;

import java.io.Serializable;

public abstract class Lutemon implements Serializable {

    protected String name;
    protected String color;
    protected int defence;
    protected int attack;
    protected int health;
    protected int maxHealth;
    protected int id;

    protected int experience;
    protected Place place;

    protected int image;

    protected int wins;
    protected int defeats;
    private static int idCounter;

    public Lutemon(String name, String color) {
        this.name = name;
        this.color = color;
        this.place = Place.HOME;
        if (Storage.getInstance().getLutemons().size() == 0){
            this.id = 0;
        } else {
            this.id = Storage.getInstance().getLutemons().size();
        }
    }

    public abstract int getMaxHealth();


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public int getIdCounter() {
        return idCounter;
    }
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
