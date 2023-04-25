package com.example.lutemon.domain;

import com.example.lutemon.Place;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;

import java.util.ArrayList;

public class TrainingField {

    private ArrayList<Lutemon> trainers = new ArrayList<>();

    private ArrayList<String> actions = new ArrayList<>();

    public TrainingField(ArrayList<Lutemon> trainers) {
        this.trainers = trainers;
    }

    public ArrayList<Lutemon> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<Lutemon> trainers) {
        this.trainers = trainers;
    }

    public void train(){
        for (Lutemon l : trainers){
            Lutemon storageLutemon = Storage.getInstance().getLutemon(l.getId());
            storageLutemon.setExperience(storageLutemon.getExperience()+2);
            actions.add(storageLutemon.getName() + " treenasi, kokemus on nyt " + storageLutemon.getExperience());
            storageLutemon.setPlace(Place.TRAININGFIELD);
        }

    }

    public ArrayList<String> getActions() {
        return actions;
    }
}
