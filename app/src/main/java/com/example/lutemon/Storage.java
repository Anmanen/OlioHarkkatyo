package com.example.lutemon;

import java.util.HashMap;

public class Storage {

    protected String name;
    protected Lutemon lutemon;
    private HashMap<Integer, Lutemon> lutemons;
    private static Storage storage;

    private Storage(){

    }

    public static Storage getInstance(){
        return storage;
    }


    public void addLutemon(int key, Lutemon lutemon){
        lutemons.put(key, lutemon);
    }

    public HashMap<Integer, Lutemon> getLutemons(){
        return lutemons;
    }

    public void listLutemons(){

    }
}
