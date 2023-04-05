package com.example.lutemon;

public class Black extends Lutemon{

    private int attack = 9;
    private int defence = 0;
    private int maxHealth = 16;
    public Black(String name, String color) {
        super(name, color);
        super.attack = attack;
        super.defence = defence;
        super.maxHealth = maxHealth;
    }
}
