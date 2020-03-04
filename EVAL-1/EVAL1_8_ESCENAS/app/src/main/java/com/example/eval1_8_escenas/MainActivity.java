package com.example.eval1_8_escenas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    Scene sceneA, sceneB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup remp = findViewById(R.id.linearLayout); //Contenedor que contendra todos

        sceneA = Scene.getSceneForLayout(remp, R.layout.esena_a, this);
        sceneB = Scene.getSceneForLayout(remp, R.layout.esena_b, this);
        Transition fade = new Fade();
        TransitionManager.go(sceneB, fade);
    }

    public void miboton(View v) {
        Transition sl = new Slide();
        TransitionManager.go(sceneA, sl);
    }

}
