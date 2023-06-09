package com.example.lutemon.domain;

import com.example.lutemon.R;
import com.example.lutemon.domain.Lutemon;

public class Green extends Lutemon {

    private int attack = 6;
    private int defence = 3;
    private int maxHealth = 19;
    public Green(String name, String color) {
        super(name, color);
        super.attack = attack;
        super.defence = defence;
        super.maxHealth = maxHealth;
        super.health = maxHealth;
        super.image = R.drawable.green;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }
}
