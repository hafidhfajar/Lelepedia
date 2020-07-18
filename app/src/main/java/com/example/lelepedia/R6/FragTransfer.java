package com.example.lelepedia.R6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lelepedia.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FragTransfer extends Fragment {
    View view;
    EditText TextNickname, TextTanggal;
    Spinner spinner;
    Button transfer;
    public FragTransfer(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.transfer_r6,container,false);

        TextNickname = view.findViewById(R.id.TextNickname);
        TextTanggal = view.findViewById(R.id.TextTanggal);
        spinner = view.findViewById(R.id.Spinner);
        transfer = view.findViewById(R.id.button);


        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferPlayer();
            }
        });

        return view;
    }
    private void transferPlayer(){

        final String playerNickname = TextNickname.getText().toString();
        final String playerJoin = TextTanggal.getText().toString();
        final String playerTeam = spinner.getSelectedItem().toString();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("rainbow6").child(playerNickname);

        if (!TextUtils.isEmpty(playerNickname)) {
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    dataSnapshot.getRef().child("playerTeam").setValue(playerTeam);
                    dataSnapshot.getRef().child("playerJoin").setValue(playerJoin);

                    Toast.makeText(getActivity(), "Transfer "+playerNickname+" Berhasil !", Toast.LENGTH_LONG).show();
                    TextNickname.setText("");
                    TextTanggal.setText("");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else {
            Toast.makeText(getActivity(), "Nickname Harus Diisi", Toast.LENGTH_LONG).show();
        }
    }
}