package com.example.lutemon.domain;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

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


    public void listLutemons(){

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
