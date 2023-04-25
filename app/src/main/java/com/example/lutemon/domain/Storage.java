package com.example.lutemon.domain;

import android.content.Context;

import com.example.lutemon.LutemonLoadingError;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Storage {

    protected String name;
    protected Lutemon lutemon;
    private HashMap<Integer, Lutemon> lutemons = new HashMap<>();
    private HashMap<Integer, Lutemon> lutemonsToLoad = new HashMap<>();

    private static Storage storage;

    private static final String LUTEMONDATA = "lutemondata.data";

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
        lutemonsToLoad.put(key, lutemon);
    }

    public HashMap<Integer, Lutemon> getLutemons(){
        return lutemons;
    }

    public Lutemon getLutemon(int id){
        return lutemons.get(id);
    }


    public List<Lutemon> listLutemonsByWins(){

        List<Lutemon> lutemonList = new ArrayList<Lutemon>(lutemons.values());
        Collections.sort(lutemonList, (a, b) -> Integer.compare(b.getWins(), a.getWins()));

        return lutemonList;
    }

    public List<Lutemon> listLutemonsByDefeats(){
        List<Lutemon> lutemonList = new ArrayList<Lutemon>(lutemons.values());
        Collections.sort(lutemonList, (a, b) -> Integer.compare(b.getDefeats(), a.getDefeats()));

        return lutemonList;
    }

    public List<Lutemon> listLutemonsByExperience(){
        List<Lutemon> lutemonList = new ArrayList<Lutemon>(lutemons.values());
        Collections.sort(lutemonList, (a, b) -> Integer.compare(b.getExperience(), a.getExperience()));

        return lutemonList;
    }

    public void loadLutemons(Context context) throws LutemonLoadingError {
        try {
            ObjectInputStream reader = new ObjectInputStream(context.openFileInput(LUTEMONDATA));
            lutemons = (HashMap<Integer, Lutemon>) reader.readObject();
            reader.close();
        } catch (FileNotFoundException e){
            throw new LutemonLoadingError(e);
        } catch (IOException e) {
            throw new LutemonLoadingError(e);
        } catch (ClassNotFoundException e) {
            throw new LutemonLoadingError(e);
        }
    }

    public void saveLutemons(Context context)  {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(context.openFileOutput(LUTEMONDATA, Context.MODE_PRIVATE));
            writer.writeObject(lutemonsToLoad);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
