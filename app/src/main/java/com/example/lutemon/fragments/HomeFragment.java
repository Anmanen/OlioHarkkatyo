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

import java.util.concurrent.Callable;


public class HomeFragment extends Fragment {

    private LinearLayout linearLayoutHome;
    private RadioGroup radioGroupHome;

    private Button transferFromHome;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        linearLayoutHome = view.findViewById(R.id.llHome);
        Storage.getInstance().getLutemons().forEach((id, lutemon) -> {
            if (lutemon.getPlace() == Place.HOME) {
                linearLayoutHome.addView(makeCheckbox(id, lutemon));
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        transferFromHome = view.findViewById((R.id.btnHomeTransfer));
        radioGroupHome = view.findViewById(R.id.rgHome);
        transferFromHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = linearLayoutHome.getChildCount();
                Place transferPlace = Place.HOME;

                switch (radioGroupHome.getCheckedRadioButtonId()){
                    case R.id.rbHomeToTrain:
                        transferPlace = Place.TRAININGFIELD;
                        break;
                    case R.id.rbHomeToFight:
                        transferPlace = Place.BATTLEFIELD;
                }
                for (int i = 0; i<amount; i++){
                    CheckBox cb = (CheckBox)linearLayoutHome.getChildAt(i);
                    if (cb.isChecked()) {
                        Storage.getInstance().getLutemon(cb.getId()).setPlace(transferPlace);
                    }
                }

                if (transferPlace == Place.TRAININGFIELD){
                    ((TransferLutemonsActivity)getActivity()).getViewPager().setCurrentItem(1);
                } else if (transferPlace == Place.BATTLEFIELD){
                    ((TransferLutemonsActivity)getActivity()).getViewPager().setCurrentItem(2);
                }

                for (int i = 0; i<amount; i++){
                    CheckBox cb = (CheckBox)linearLayoutHome.getChildAt(i);
                    cb.setChecked(false);
                }
                radioGroupHome.clearCheck();;
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