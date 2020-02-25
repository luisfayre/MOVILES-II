package com.example.eval1_1_fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlueFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.wtf("Blue", "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.wtf("Blue", "Oncreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.wtf("Blue", "onAttach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.wtf("Blue", "onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.wtf("Blue", "onstart");
    }

}
