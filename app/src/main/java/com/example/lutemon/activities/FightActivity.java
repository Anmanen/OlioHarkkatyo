package com.example.lutemon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.lutemon.domain.BattleField;
import com.example.lutemon.Place;
import com.example.lutemon.R;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;

import java.util.ArrayList;
import java.util.HashMap;

public class FightActivity extends AppCompatActivity {

    LinearLayout fightersLayout;
    LinearLayout actionsLayout;

    ScrollView scrollView;

    ArrayList<Lutemon> fighters = new ArrayList();
    HashMap<Integer, ArrayList<Object>> actions = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        fightersLayout = findViewById(R.id.llTwoFighters);
        actionsLayout = findViewById(R.id.llActions);
        scrollView = findViewById(R.id.svActions);


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
        actions.forEach((index, action) -> actionsLayout.addView(makeActionRow(action)));
        scrollView.fullScroll(ScrollView.FOCUS_DOWN);

    }

    public void backToBattleField(View view){
        Intent intent = new Intent(this,TransferLutemonsActivity.class);
        intent.putExtra("position", 2);
        startActivity(intent);
    }

    public TextView makeTextView(int id, Lutemon lutemon){
        TextView tw = new TextView(this);
        Lutemon l = Storage.getInstance().getLutemon(id);
        tw.setText(l.getName() + " hyökkäys: " + l.getAttack() + " puolustus: " + l.getDefence() +
                " kokemus: " + l.getExperience() + " elämä: " + l.getHealth() + "/" + l.getMaxHealth());
        return tw;
    }

    public LinearLayout makeActionRow(ArrayList<Object> action){
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ImageView attacker = new ImageView(this);
        attacker.setImageResource((Integer) action.get(0));
        TextView attackPower = new TextView(this);
        attackPower.setText(String.valueOf(action.get(1)));
        ImageView attack = new ImageView(this);
        attack.setImageResource((Integer)action.get(2));
        ImageView defender = new ImageView(this);
        defender.setImageResource((Integer)action.get(3));
        TextView defencePower = new TextView(this);
        defencePower.setText(String.valueOf(action.get(4)));
        TextView result = new TextView(this);
        result.setText(String.valueOf(action.get(5)));
        result.setTypeface(null, Typeface.BOLD);
        result.setTextSize(16);
        ll.addView(attacker);
        ll.addView(attackPower);
        ll.addView(attack);
        ll.addView(defender);
        ll.addView(defencePower);
        ll.addView(result);
        return ll;
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