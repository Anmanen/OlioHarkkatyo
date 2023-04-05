package com.example.lutemon;

public class Green extends Lutemon{

    private int attack = 6;
    private int defence = 3;
    private int maxHealth = 19;
    public Green(String name, String color) {
        super(name, color);
        super.attack = attack;
        super.defence = defence;
        super.maxHealth = maxHealth;
    }
}
