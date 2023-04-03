package com.example.lutemon;

public class Lutemon {

    protected String name;
    protected String color;
    protected int defence;
    protected int attack;
    protected int health;
    protected int maxHealth;
    protected int id;
    private int idCounter;

    public Lutemon(String name, String color, int defence, int attack, int maxHealth) {
        this.name = name;
        this.color = color;
        this.defence = defence;
        this.attack = attack;
        this.maxHealth = maxHealth;
    }

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

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }
}
