package com.example.eva2_4_file_resources;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView tv_Lorem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Lorem = findViewById(R.id.tv_lorem);
    }

    @Override
    protected void onStart() {
        super.onStart();

        InputStream inputStream = getResources().openRawResource(R.raw.lorem);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String sCade;

        try {
            while ((sCade = bufferedReader.readLine()) != null) {
                tv_Lorem.append(sCade + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
