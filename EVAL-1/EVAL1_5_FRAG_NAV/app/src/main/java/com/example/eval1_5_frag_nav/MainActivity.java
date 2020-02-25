package com.example.eval1_5_frag_nav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ButtonFragment buttonFragement = new ButtonFragment();
        buttonFragement.setMiClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                FragmentTwo blackFragment = new FragmentTwo();
                ft2.replace(R.id.fragment, blackFragment);
                ft2.commit();
            }
        });
        ft.replace(R.id.fra,buttonFragement);
        ft.commit();

    }

}
