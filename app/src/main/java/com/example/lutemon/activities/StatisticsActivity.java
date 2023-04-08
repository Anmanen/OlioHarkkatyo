package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.lutemon.BattleField;
import com.example.lutemon.R;

public class StatisticsActivity extends AppCompatActivity {

    private TextView battles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        battles = findViewById(R.id.txtBattles);
        int temp = BattleField.getBattleCounter();
        battles.setText(String.valueOf(BattleField.getBattleCounter()));

    }






}