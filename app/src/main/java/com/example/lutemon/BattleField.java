package com.example.lutemon;

import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;
import com.example.lutemon.domain.White;

import java.util.ArrayList;
import java.util.HashMap;

public class BattleField {

    private Lutemon fighterA;
    private Lutemon fighterB;

    private static int battleCounter;
    private int attackCounter;

    private HashMap<Integer, ArrayList<Object>> actions = new HashMap<>();

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
            Storage.getInstance().getLutemon(fighterB.getId()).setWins(fighterB.getWins()+1);
        }

        if (fighterB.getHealth() == 0){
            Storage.getInstance().getLutemon(fighterB.getId()).setDefeats(fighterB.getDefeats()+1);
            Storage.getInstance().getLutemon(fighterB.getId()).setPlace(Place.HOME);
            Storage.getInstance().getLutemon(fighterB.getId()).setHealth(fighterB.getMaxHealth());
            Storage.getInstance().getLutemon(fighterA.getId()).setPlace(Place.BATTLEFIELD);
            Storage.getInstance().getLutemon(fighterA.getId()).setExperience(fighterA.getExperience()+1);
            Storage.getInstance().getLutemon(fighterA.getId()).setWins(fighterA.getWins()+1);
        }
    }

    public Lutemon attack (Lutemon A, Lutemon B){

        if (((A.getAttack() + A.getExperience()) - B.getDefence()) < B.getHealth()){
            B.setHealth(B.getHealth() - ((A.getAttack() + A.getExperience()) - B.getDefence()));
            ArrayList<Object> temp = new ArrayList<>();
            temp.add(0,A.getImage());
            temp.add(1, R.drawable.attack);
            temp.add(2, B.getImage());
            temp.add(3, " : " + B.getName() + " jäi henkiin " + B.getHealth() + "/" + B.getMaxHealth());
            actions.put(attackCounter, temp);
        } else {
            ArrayList<Object> temp = new ArrayList<>();
            temp.add(0, A.getImage());
            temp.add(1, R.drawable.attack);
            temp.add(2, B.getImage());
            temp.add(3, " : " + B.getName() + " kuoli");
            actions.put(attackCounter, temp);
            B.setHealth(0);
        }
        attackCounter++;
        return B;
    }

    public HashMap<Integer, ArrayList<Object>> getActions() {
        return actions;
    }

    public static int getBattleCounter() {
        return battleCounter;
    }
}
