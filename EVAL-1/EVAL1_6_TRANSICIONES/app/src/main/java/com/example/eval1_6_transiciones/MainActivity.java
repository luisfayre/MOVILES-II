package com.example.eval1_6_transiciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeScroll;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    Intent inLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setEnterTransition(new Slide().setDuration(500));
        setContentView(R.layout.activity_main);
        inLlamar = new Intent(this,Main2Activity.class);
    }

    public void onClick(View v){
        startActivity(inLlamar, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }
}
