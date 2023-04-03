package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonInfoHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView name, attack, defence, health, experience;

    public LutemonInfoHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.ivImage);
        name = itemView.findViewById(R.id.txtName);
        attack = itemView.findViewById(R.id.txtAttack);
        defence = itemView.findViewById(R.id.txtDefence);
        health = itemView.findViewById(R.id.txtHealth);
        experience = itemView.findViewById(R.id.txtExperience);


    }
}
