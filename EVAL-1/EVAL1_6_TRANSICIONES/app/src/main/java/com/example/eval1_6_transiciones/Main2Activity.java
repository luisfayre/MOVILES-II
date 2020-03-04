package com.example.eval1_6_transiciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeScroll;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Window;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setEnterTransition(new Explode().setDuration(500));
        setContentView(R.layout.activity_main2);
    }
}
