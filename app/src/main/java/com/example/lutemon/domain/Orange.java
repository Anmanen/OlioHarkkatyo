package com.example.lutemon.domain;

import com.example.lutemon.domain.Lutemon;

public class Orange extends Lutemon {

    private int attack = 8;
    private int defence = 1;
    private int maxHealth = 17;
    public Orange(String name, String color) {
        super(name, color);
        super.attack = attack;
        super.defence = defence;
        super.maxHealth = maxHealth;
        super.health = maxHealth;
    }
}
