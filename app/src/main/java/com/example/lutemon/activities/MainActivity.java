package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lutemon.R;

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


}