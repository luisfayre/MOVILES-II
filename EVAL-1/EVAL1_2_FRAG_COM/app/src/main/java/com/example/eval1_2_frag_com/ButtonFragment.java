package com.example.eval1_2_frag_com;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {

    MainActivity main;
    Button boton;

    public ButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_button, container, false);

        boton = linearLayout.findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.onMessageFromFragmentToMain("Button", "Button Fragment");
            }
        });

        // Inflate the layout for this fragment
        return linearLayout;
    }

    public void onMessageFromMainToFrag(String param) {
        boton.setText(param);
    }
}
