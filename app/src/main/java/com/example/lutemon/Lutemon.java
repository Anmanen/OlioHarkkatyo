package com.example.lutemon;

public class Lutemon {

    protected String name;
    protected String color;
    protected int defence;
    protected int attack;
    protected int health;
    protected int maxHealth;
    protected int id;

    protected int experience;
    private static int idCounter;

    public Lutemon(String name, String color) {
        this.name = name;
        this.color = color;
        this.id = idCounter;
        idCounter++;
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

    public int getIdCounter() {
        return idCounter;
    }
    public int getExperience() {
        return experience;
    }
}
