package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.lutemon.BattleField;
import com.example.lutemon.R;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;

public class StatisticsActivity extends AppCompatActivity {

    private TextView battles;
    private TextView mostWins;

    private TextView mostDefences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        battles = findViewById(R.id.txtBattles);
        battles.setText(String.valueOf(BattleField.getBattleCounter()));

        mostWins = findViewById(R.id.txtMostWins);
        Lutemon winner = Storage.getInstance().listLutemonsByWins();
        mostWins.setText(winner.getName() + " " + winner.getColor() + ": " + winner.getWins());

        mostDefences = findViewById(R.id.txtMostDefences);
        Lutemon loser = Storage.getInstance().listLutemonsByDefeats();
        mostDefences.setText(loser.getName() + " " + loser.getColor() + ": " + loser.getDefeats());
    }






}