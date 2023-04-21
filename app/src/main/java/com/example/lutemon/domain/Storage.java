package com.example.lutemon.domain;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;

public class Storage {

    protected String name;
    protected Lutemon lutemon;
    private HashMap<Integer, Lutemon> lutemons = new HashMap<>();

    private static Storage storage;

    private static final String LUTEMONDATA = "lutemondata.data";

    private boolean isSavedData;

    private Storage(){
        this.isSavedData = false;
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


    public Lutemon listLutemonsByWins(){

        List<Lutemon> lutemonList = new ArrayList<Lutemon>(lutemons.values());
        Collections.sort(lutemonList, (a, b) -> Integer.compare(b.getWins(), a.getWins()));

        return lutemonList.get(0);
    }

    public Lutemon listLutemonsByDefeats(){
        List<Lutemon> lutemonList = new ArrayList<Lutemon>(lutemons.values());
        Collections.sort(lutemonList, (a, b) -> Integer.compare(b.getDefeats(), a.getDefeats()));

        return lutemonList.get(0);
    }

    public void loadLutemons(Context context) throws FileNotFoundException {
        try {
            ObjectInputStream reader = new ObjectInputStream(context.openFileInput(LUTEMONDATA));
            lutemons = (HashMap<Integer, Lutemon>) reader.readObject();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveLutemons(Context context)  {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(context.openFileOutput(LUTEMONDATA, Context.MODE_PRIVATE));
            writer.writeObject(lutemons);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
