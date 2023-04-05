package com.example.lutemon;

import java.util.HashMap;

public class Storage {

    protected String name;
    protected Lutemon lutemon;
    private HashMap<Integer, Lutemon> lutemons = new HashMap<>();
    private static Storage storage;

    private Storage(){

    }

    public static Storage getInstance(){
        if (storage == null){
            storage = new Storage();
        }
        return storage;
    }


    public void addLutemon(int key, Lutemon lutemon){
        lutemons.put(key, lutemon);
    }

    public HashMap<Integer, Lutemon> getLutemons(){
        return lutemons;
    }

    public Lutemon getLutemon(int id){
        return lutemons.get(id);
    }

    public void listLutemons(){

    }

    public void loadLutemons(){

    }

    public void saveLutemon(){

    }
}
