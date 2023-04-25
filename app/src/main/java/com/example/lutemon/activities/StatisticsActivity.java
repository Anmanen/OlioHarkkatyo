package com.example.lutemon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lutemon.BattleField;
import com.example.lutemon.R;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;

import java.util.List;


public class StatisticsActivity extends AppCompatActivity {

    private TextView battles;
    private LinearLayout wins;

    private LinearLayout defeats;

    private LinearLayout experiences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        battles = findViewById(R.id.txtBattles);
        battles.setText(String.valueOf(BattleField.getBattleCounter()));

        wins = findViewById(R.id.llWins);
        List<Lutemon> winners = Storage.getInstance().listLutemonsByWins();

        for (Lutemon lutemon : winners){
            TextView tw = new TextView(this);
            int battles = lutemon.getWins() + lutemon.getDefeats();
            tw.setText(lutemon.getName() + ": " + lutemon.getWins() + "/" + String.valueOf(battles));
            tw.setTextSize(16);
            wins.addView(tw);
        }

        defeats = findViewById(R.id.llDefeats);
        List<Lutemon> losers = Storage.getInstance().listLutemonsByDefeats();

        for (Lutemon lutemon : losers){
            TextView tw = new TextView(this);
            int battles = lutemon.getWins() + lutemon.getDefeats();
            tw.setText(lutemon.getName() + ": " + lutemon.getDefeats() + "/" + String.valueOf(battles));
            tw.setTextSize(16);
            defeats.addView(tw);
        }

        experiences = findViewById(R.id.llExperience);
        List<Lutemon> exps = Storage.getInstance().listLutemonsByExperience();

        for (Lutemon lutemon : exps){
            TextView tw = new TextView(this);
            tw.setText(lutemon.getName() + ": " + lutemon.getExperience());
            tw.setTextSize(16);
            experiences.addView(tw);
        }

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

    public void showBarGraphView(View view){
        Intent intent = new Intent(this, BarGraphActivity.class);
        startActivity(intent);
    }

    public void showColumnGraphView(View view){
        Intent intent = new Intent(this, ColumnGraphActivity.class);
        startActivity(intent);
    }
}