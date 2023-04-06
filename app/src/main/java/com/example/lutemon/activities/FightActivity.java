package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lutemon.BattleField;
import com.example.lutemon.Place;
import com.example.lutemon.R;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;

import java.util.ArrayList;
import java.util.HashMap;

public class FightActivity extends AppCompatActivity {

    LinearLayout fightersLayout;
    LinearLayout actionsLayout;

    ArrayList<Lutemon> fighters = new ArrayList();
    ArrayList<String> actions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        fightersLayout = findViewById(R.id.llTwoFighters);
        actionsLayout = findViewById(R.id.llActions);


        Storage.getInstance().getLutemons().forEach((id, lutemon) -> {
            if (lutemon.getPlace() == Place.FIGHTING){
                fightersLayout.addView(makeTextView(id, lutemon));
                fighters.add(lutemon);
            }
        });
    }


    public void startFighting(View view){
        BattleField battleField = new BattleField(fighters.get(0),fighters.get(1));
        battleField.fight();
        actions = battleField.getActions();
        for (String action : actions){
            actionsLayout.addView(makeActionTextView(action));
        }
    }

    public TextView makeTextView(int id, Lutemon lutemon){
        TextView tw = new TextView(this);
        Lutemon l = Storage.getInstance().getLutemon(id);
        tw.setText(l.getName() + " h: " + l.getAttack() + " p: " + l.getDefence() +
                " elämä: " + l.getHealth() + "/" + l.getMaxHealth());
        return tw;
    }

    public TextView makeActionTextView(String action){
        TextView tw = new TextView(this);
        tw.setText(action);
        return tw;
    }
}