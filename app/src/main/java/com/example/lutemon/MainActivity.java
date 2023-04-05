package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAddLutemonView(View view){
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void openListLutemonView(View view){
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }

    public void openTransferLutemonsView(View view){
        Intent intent = new Intent(this, TransferLutemonsActivity.class);
        startActivity(intent);
    }

    public void openFightView(View view){
        Intent intent = new Intent(this, FightActivity.class);
        startActivity(intent);
    }
}