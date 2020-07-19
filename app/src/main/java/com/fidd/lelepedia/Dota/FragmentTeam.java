package com.fidd.lelepedia.Dota;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.fidd.lelepedia.R;

public class FragmentTeam extends Fragment implements View.OnClickListener {
    View view;
    ImageButton b1,b2,b3,b4,b5,b6;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dota_team, container, false);

        b1 = view.findViewById(R.id.imageButton1);
        b2 = view.findViewById(R.id.imageButton2);
        b3 = view.findViewById(R.id.imageButton3);
        b4 = view.findViewById(R.id.imageButton4);
        b5 = view.findViewById(R.id.imageButton5);
        b6 = view.findViewById(R.id.imageButton6);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);

        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton1:
                startActivity(new Intent(getActivity(), Navi.class));
                break;
            case R.id.imageButton2:
                startActivity(new Intent(getActivity(), Nigma.class));
                break;
            case R.id.imageButton3:
                startActivity(new Intent(getActivity(), Secret.class));
                break;
            case R.id.imageButton4:
                startActivity(new Intent(getActivity(), VP.class));
                break;
            case R.id.imageButton5:
                startActivity(new Intent(getActivity(), OG.class));
                break;
            case R.id.imageButton6:
                startActivity(new Intent(getActivity(), Boom.class));
                break;
            default:
                break;
        }

    }

}
