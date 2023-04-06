package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lutemon.BattleField;
import com.example.lutemon.Place;
import com.example.lutemon.R;
import com.example.lutemon.TrainingField;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;

import java.util.ArrayList;

public class TrainActivity extends AppCompatActivity {

    LinearLayout trainersLayout;
    LinearLayout trainActionsLayout;

    ArrayList<Lutemon> trainers = new ArrayList<>();
    ArrayList<String> trainingActions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        trainersLayout = findViewById(R.id.llTrainers);
        trainActionsLayout = findViewById(R.id.llTrainActions);

        Storage.getInstance().getLutemons().forEach((id, lutemon) -> {
            if (lutemon.getPlace() == Place.TRAINING){
                trainersLayout.addView(makeTextView(id, lutemon));
                trainers.add(lutemon);
            }
        });
    }
    public TextView makeTextView(int id, Lutemon lutemon){
        TextView tw = new TextView(this);
        Lutemon l = Storage.getInstance().getLutemon(id);
        tw.setText(l.getName() + " elämä: " + l.getHealth() + "/" + l.getMaxHealth() +
                " kokemus: " + l.getExperience() + " häviöt: " + l.getDefeats());
        return tw;
    }

    public void startTraining(View view){
        TrainingField trainingField = new TrainingField(trainers);
        trainingField.train();
        trainingActions = trainingField.getActions();
        for (String action : trainingActions){
            trainActionsLayout.addView(makeActionTextView(action));
        }
    }

    public TextView makeActionTextView(String action){
        TextView tw = new TextView(this);
        tw.setText(action);
        return tw;
    }
}