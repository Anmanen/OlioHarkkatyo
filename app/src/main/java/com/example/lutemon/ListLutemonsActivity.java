package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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