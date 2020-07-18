package com.example.lelepedia.R6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.lelepedia.R;

public class FragmentTeam extends Fragment implements View.OnClickListener {
    View view;
    ImageButton b1,b2,b3,b4,b5,b6;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_r6_team, container, false);

        b2 = view.findViewById(R.id.imageButton2);
        b2.setOnClickListener(this);
        return view;
    }

            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imageButton2:
                        startActivity(new Intent(getActivity(),G2.class));
                        break;
                    default:
                        break;
                }

            }

    }
