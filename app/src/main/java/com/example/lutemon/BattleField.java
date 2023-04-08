package com.example.lutemon;

import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;
import com.example.lutemon.domain.White;

import java.util.ArrayList;

public class BattleField {

    private Lutemon fighterA;
    private Lutemon fighterB;

    private static int battleCounter;

    private ArrayList<String> actions = new ArrayList<>();

    public BattleField(Lutemon fighterA, Lutemon fighterB) {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
        battleCounter++;
    }

    public void fight(){

        while (fighterA.getHealth() > 0 && fighterB.getHealth() > 0){
            fighterB = attack(fighterA, fighterB);
            if (fighterB.getHealth() != 0) {
                fighterA = attack(fighterB, fighterA);
            }
        }

        if (fighterA.getHealth() == 0){
            Storage.getInstance().getLutemon(fighterA.getId()).setDefeats(fighterA.getDefeats()+1);
            Storage.getInstance().getLutemon(fighterA.getId()).setPlace(Place.HOME);
            Storage.getInstance().getLutemon(fighterA.getId()).setHealth(fighterA.getMaxHealth());
            Storage.getInstance().getLutemon(fighterB.getId()).setPlace(Place.BATTLEFIELD);
            Storage.getInstance().getLutemon(fighterB.getId()).setExperience(fighterB.getExperience()+1);
        }


        if (fighterB.getHealth() == 0){
            Storage.getInstance().getLutemon(fighterB.getId()).setDefeats(fighterB.getDefeats()+1);
            Storage.getInstance().getLutemon(fighterB.getId()).setPlace(Place.HOME);
            Storage.getInstance().getLutemon(fighterB.getId()).setHealth(fighterB.getMaxHealth());
            Storage.getInstance().getLutemon(fighterA.getId()).setPlace(Place.BATTLEFIELD);
            Storage.getInstance().getLutemon(fighterA.getId()).setExperience(fighterA.getExperience()+1);
        }
    }

    public Lutemon attack (Lutemon A, Lutemon B){
        if (((A.getAttack() + A.getExperience()) - B.getDefence()) <= B.getHealth()){
            B.setHealth(B.getHealth() - ((A.getAttack() + A.getExperience()) - B.getDefence()));
            actions.add(A.getName() + " hyökkää, " + B.getName() + " puolustautuu: " + B.getName() + " jäi henkiin " + B.getHealth() + "/" + B.getMaxHealth());
        } else {
            actions.add(A.getName() + " hyökkää, " + B.getName() + " puolustautuu: " + B.getName() + " kuoli ");
            B.setHealth(0);
        }
        return B;
    }

    public ArrayList<String> getActions() {
        return actions;
    }
}
