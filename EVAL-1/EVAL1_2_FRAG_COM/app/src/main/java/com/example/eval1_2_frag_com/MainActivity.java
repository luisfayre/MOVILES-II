package com.example.eval1_2_frag_com;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    ButtonFragment btnFragment;
    ListFragment listFragment;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment.getClass() == ButtonFragment.class) {
            btnFragment = (ButtonFragment) fragment;
        } else {
            listFragment = (ListFragment) fragment;
        }
    }

    public void onMessageFromFragmentToMain(String sender, String param) {
        if (sender.equals("List")) {
            textView.setText("Lista: " + param);
            btnFragment.onMessageFromMainToFrag(param);
        } else if (sender.equals("Button")) {
            textView.setText("Boton: " + param);
        }
    }

}
