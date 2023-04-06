package com.example.lutemon.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.lutemon.Place;
import com.example.lutemon.R;
import com.example.lutemon.activities.FightActivity;
import com.example.lutemon.activities.TrainActivity;
import com.example.lutemon.activities.TransferLutemonsActivity;
import com.example.lutemon.domain.Lutemon;
import com.example.lutemon.domain.Storage;

public class TrainFieldFragment extends Fragment {

    public TrainFieldFragment() {
        // Required empty public constructor
    }
    private LinearLayout linearLayoutTrain;
    private RadioGroup radioGroupTrain;
    private Button transferFromTrain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train_field, container, false);
        linearLayoutTrain = view.findViewById(R.id.llTrain);
        Storage.getInstance().getLutemons().forEach((id, lutemon) -> {
            if (lutemon.getPlace() == Place.TRAININGFIELD) {
                linearLayoutTrain.addView(makeCheckbox(id, lutemon));
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        transferFromTrain = view.findViewById((R.id.btnTrainTransfer));
        radioGroupTrain = view.findViewById(R.id.rgBattle);
        transferFromTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = linearLayoutTrain.getChildCount();
                Place transferPlace = Place.TRAININGFIELD;

                switch (radioGroupTrain.getCheckedRadioButtonId()){
                    case R.id.rbTrainToTrain:
                        transferPlace = Place.TRAINING;
                        break;
                    case R.id.rbFightToTrain:
                        transferPlace = Place.BATTLEFIELD;
                        break;
                    case R.id.rbFightToHome:
                        transferPlace = Place.HOME;
                }
                for (int i = 0; i<amount; i++){
                    CheckBox cb = (CheckBox)linearLayoutTrain.getChildAt(i);
                    if (cb.isChecked()) {
                        Storage.getInstance().getLutemon(cb.getId()).setPlace(transferPlace);
                    }
                }

                if (transferPlace == Place.BATTLEFIELD){
                    ((TransferLutemonsActivity)getActivity()).getViewPager().setCurrentItem(2);
                } else if (transferPlace == Place.HOME){
                    ((TransferLutemonsActivity)getActivity()).getViewPager().setCurrentItem(0);
                } else {
                    Intent intent = new Intent(getActivity(), TrainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public CheckBox makeCheckbox(int id, Lutemon lutemon){
        CheckBox checkBox = new CheckBox(getActivity());
        checkBox.setId(id);
        checkBox.setText(lutemon.getName() + " " + lutemon.getColor());
        return checkBox;
    }
}