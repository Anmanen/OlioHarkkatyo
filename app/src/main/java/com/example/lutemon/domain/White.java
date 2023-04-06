package com.example.lutemon.domain;

import com.example.lutemon.domain.Lutemon;

public class White extends Lutemon {

    private int attack = 5;
    private int defence = 4;
    private int maxHealth = 20;
    private int health = 20;
    public White(String name, String color) {
        super(name, color);
        super.attack = attack;
        super.defence = defence;
        super.maxHealth = maxHealth;
        super.health = maxHealth;

    }
}
