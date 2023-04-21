package com.example.lutemon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuHome){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

}