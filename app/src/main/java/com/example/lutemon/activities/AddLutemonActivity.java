package com.example.lutemon.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lutemon.domain.Black;
import com.example.lutemon.domain.Green;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Orange;
import com.example.lutemon.domain.Pink;
import com.example.lutemon.R;
import com.example.lutemon.domain.Storage;
import com.example.lutemon.domain.White;

public class AddLutemonActivity extends AppCompatActivity {

    RadioButton color = null;
    Lutemon lutemon = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
    }

    public void addLutemon(View view ){
        EditText name = findViewById(R.id.etxtName);
        RadioGroup colorChoice = findViewById(R.id.rgColorChoice);

        switch (colorChoice.getCheckedRadioButtonId()){
            case (R.id.rbWhite):
                color = findViewById(R.id.rbWhite);
                lutemon = new White(name.getText().toString(), color.getText().toString());
                break;
            case (R.id.rbGreen):
                color = findViewById(R.id.rbGreen);
                lutemon = new Green(name.getText().toString(), color.getText().toString());
                break;
            case (R.id.rbPink):
                color = findViewById(R.id.rbPink);
                lutemon = new Pink(name.getText().toString(), color.getText().toString());
                break;
            case (R.id.rbOrange):
                color = findViewById(R.id.rbOrange);
                lutemon = new Orange(name.getText().toString(), color.getText().toString());
                break;
            case (R.id.rbBlack):
                color = findViewById(R.id.rbBlack);
                lutemon = new Black(name.getText().toString(), color.getText().toString());
                break;
        }

        Storage.getInstance().addLutemon(lutemon.getId(), lutemon);
        Storage.getInstance().saveLutemons(this);

        name.setText("");
        colorChoice.clearCheck();

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