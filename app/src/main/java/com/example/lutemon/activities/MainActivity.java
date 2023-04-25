package com.example.lutemon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.lutemon.LutemonLoadingError;
import com.example.lutemon.R;
import com.example.lutemon.domain.Storage;

import java.io.FileNotFoundException;
import java.util.zip.Inflater;

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


    public void loadSavedLutemons(View view){
        try {
            Storage.getInstance().loadLutemons(this);
            Toast.makeText(this, "Lutemonit ladattu", Toast.LENGTH_SHORT).show();
        } catch (LutemonLoadingError e){
            Toast.makeText(this, "Lutemoneja ei ole vielä tallennettu, lisää Lutemoneja ensin", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void openListLutemonView(View view){
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }

    public void openTransferLutemonsView(View view){
        Intent intent = new Intent(this, TransferLutemonsActivity.class);
        startActivity(intent);
    }

    public void openStatisticsView(View view){
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }
}