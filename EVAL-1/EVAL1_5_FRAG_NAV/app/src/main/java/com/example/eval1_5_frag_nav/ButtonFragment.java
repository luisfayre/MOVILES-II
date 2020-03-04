package com.example.eval1_5_frag_nav;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {
    private View.OnClickListener miClick;

    public void setMiClick(View.OnClickListener miClick) {
        this.miClick = miClick;
    }

    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.button_fragement, container, false);
        Button btn = ll.findViewById(R.id.btn_frag);
        btn.setOnClickListener(miClick);

        return ll;

    }



}
