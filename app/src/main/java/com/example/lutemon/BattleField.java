package com.example.lutemon;

import com.example.lutemon.domain.Lutemon;

import java.util.ArrayList;

public class BattleField {

    private Lutemon fighterA;
    private Lutemon fighterB;

    private ArrayList<String> actions = new ArrayList<>();

    public BattleField(Lutemon fighterA, Lutemon fighterB) {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
    }

    public void fight(){

        while (fighterA.getHealth() > 0 && fighterB.getHealth() > 0){
            fighterB = attack(fighterA, fighterB);
            if (fighterB.getHealth() != 0) {
                fighterA = attack(fighterB, fighterA);
            }
        }
    }

    public Lutemon attack (Lutemon A, Lutemon B){
        if ((A.getAttack() - B.getDefence()) <= B.getHealth()){
            B.setHealth(B.getHealth() - (A.getAttack() - B.getDefence()));
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
