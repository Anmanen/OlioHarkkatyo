package com.example.lutemon;

public class Pink extends Lutemon{

    private int attack = 7;
    private int defence = 2;
    private int maxHealth = 18;
    public Pink(String name, String color) {
        super(name, color);
        super.attack = attack;
        super.defence = defence;
        super.maxHealth = maxHealth;
    }
}
