package com.example.lutemon;

public class White extends Lutemon{

    private int attack = 5;
    private int defence = 4;
    private int maxHealth = 20;
    public White(String name, String color) {
        super(name, color);
        super.attack = attack;
        super.defence = defence;
        super.maxHealth = maxHealth;
    }
}