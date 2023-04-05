package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lutemon.LutemonInfoAdapter;
import com.example.lutemon.R;
import com.example.lutemon.domain.Storage;

public class ListLutemonsActivity extends AppCompatActivity {

    private RecyclerView rw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);

        rw = findViewById(R.id.rwLutemonInfo);
        rw.setLayoutManager(new LinearLayoutManager(this));
        rw.setAdapter(new LutemonInfoAdapter(Storage.getInstance().getLutemons(), getApplicationContext()));
    }
}