package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.domain.Lutemon;

import java.util.HashMap;

public class LutemonInfoAdapter extends RecyclerView.Adapter<LutemonInfoHolder> {

    private HashMap<Integer, Lutemon> lutemonHashMap;
    private Context context;

    public LutemonInfoAdapter(HashMap<Integer, Lutemon> lutemonHashMap, Context context) {
        this.lutemonHashMap = lutemonHashMap;
        this.context = context;
    }

    @NonNull
    @Override
    public LutemonInfoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lutemon_info, parent,false);
        LutemonInfoHolder holder = new LutemonInfoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonInfoHolder holder, int position) {
        holder.image.setImageResource(lutemonHashMap.get(position).getImage());
        holder.name.setText(lutemonHashMap.get(position).getName()+ " (" + lutemonHashMap.get(position).getColor() + ")");
        holder.attack.setText(String.valueOf(lutemonHashMap.get(position).getAttack()));
        holder.defence.setText(String.valueOf(lutemonHashMap.get(position).getDefence()));
        holder.health.setText(String.valueOf(lutemonHashMap.get(position).getHealth()) + "/" + String.valueOf(lutemonHashMap.get(position).getMaxHealth()));
        holder.experience.setText(String.valueOf((lutemonHashMap.get(position).getExperience())));
        switch (lutemonHashMap.get(position).getPlace()){
            case HOME:
                holder.place.setText("Kotona");
                break;
            case TRAININGFIELD:
                holder.place.setText("Treenikentällä");
                break;
            case TRAINING:
                holder.place.setText("Treenaamassa");
                break;
            case BATTLEFIELD:
                holder.place.setText("Taistelukentällä");
                break;
            case FIGHTING:
                holder.place.setText("Taistelemassa");
                break;
        }

    }

    @Override
    public int getItemCount() {
        return lutemonHashMap.size();
    }
}
