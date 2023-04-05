package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

        name.setText("");
        colorChoice.clearCheck();

    }







}