package com.example.lutemon.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lutemon.Place;
import com.example.lutemon.R;
import com.example.lutemon.activities.FightActivity;
import com.example.lutemon.activities.TrainActivity;
import com.example.lutemon.activities.TransferLutemonsActivity;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;


public class BattleFieldFragment extends Fragment {

    private LinearLayout linearLayoutBattle;
    private RadioGroup radioGroupBattle;
    private Button transferFromBattle;

    private boolean isFound;

    public BattleFieldFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle_field, container, false);
        linearLayoutBattle = view.findViewById(R.id.llBattle);

        Storage.getInstance().getLutemons().forEach((id, lutemon) -> {
            if (lutemon.getPlace() == Place.BATTLEFIELD) {
                linearLayoutBattle.addView(makeCheckbox(id, lutemon));
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        transferFromBattle = view.findViewById((R.id.btnBattleTransfer));
        radioGroupBattle = view.findViewById(R.id.rgBattle);
        transferFromBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = linearLayoutBattle.getChildCount();
                Place transferPlace = Place.BATTLEFIELD;
                int fighterCounter = 0;

                switch (radioGroupBattle.getCheckedRadioButtonId()){
                    case R.id.rbFightToFight:
                        transferPlace = Place.FIGHTING;
                        break;
                    case R.id.rbFightToTrain:
                        transferPlace = Place.TRAININGFIELD;
                        break;
                    case R.id.rbFightToHome:
                        transferPlace = Place.HOME;
                }
                for (int i = 0; i<amount; i++){
                    CheckBox cb = (CheckBox)linearLayoutBattle.getChildAt(i);
                    if ((cb.isChecked()) && transferPlace == Place.FIGHTING){
                        fighterCounter++;
                        Storage.getInstance().getLutemon(cb.getId()).setPlace(transferPlace);
                        isFound = true;
                    } else if (cb.isChecked()){
                        Storage.getInstance().getLutemon(cb.getId()).setPlace(transferPlace);
                        isFound = true;
                    }
                }


                if ((transferPlace == Place.TRAININGFIELD) && isFound){
                    clearSelections();
                    Intent intent = new Intent(getActivity().getApplicationContext(), TransferLutemonsActivity.class);
                    startActivity(intent);

                } else if ((transferPlace == Place.HOME) && isFound){
                    clearSelections();
                    Intent intent = new Intent(getActivity().getApplicationContext(), TransferLutemonsActivity.class);
                    startActivity(intent);

                } else if (isFound){
                    if (fighterCounter == 2) {
                        clearSelections();
                        Intent intent = new Intent(getActivity(), FightActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(),"Valitse kaksi Lutemonia",Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });


    }

    public CheckBox makeCheckbox(int id, Lutemon lutemon){
        CheckBox checkBox = new CheckBox(getActivity());
        checkBox.setId(id);
        checkBox.setText(lutemon.getName() + " " + lutemon.getColor() + ": elämä " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());
        return checkBox;
    }

    public void clearSelections(){

        linearLayoutBattle.removeAllViews();
        ((TransferLutemonsActivity)getActivity()).getViewPagerAdapter().notifyDataSetChanged();
        Storage.getInstance().getLutemons().forEach((id, lutemon) -> {
            if (lutemon.getPlace() == Place.BATTLEFIELD) {
                linearLayoutBattle.addView(makeCheckbox(id, lutemon));
            }
        });

        radioGroupBattle.clearCheck();;
    }

}