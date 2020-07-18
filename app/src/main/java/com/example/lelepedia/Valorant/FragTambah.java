package com.example.lelepedia.Valorant;

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

import com.example.lelepedia.Dota.Player;
import com.example.lelepedia.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragTambah extends Fragment {

    View view;
    EditText TextNama, TextNickname, TextTanggal;
    Spinner spinner;
    Button tambah;
    DatabaseReference databasePlayer;

    public FragTambah() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tambah_valorant, container, false);

        databasePlayer = FirebaseDatabase.getInstance().getReference("valorant");

        TextNama = view.findViewById(R.id.TextNama);
        TextNickname = view.findViewById(R.id.TextNickname);
        TextTanggal = view.findViewById(R.id.TextTanggal);
        spinner = view.findViewById(R.id.Spinner);
        tambah = view.findViewById(R.id.button);


        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPlayer();
            }
        });

        return view;
    }

    private void addPlayer() {
        String playerName = TextNama.getText().toString().trim();
        String playerNickname = TextNickname.getText().toString().trim();
        String playerJoin = TextTanggal.getText().toString().trim();
        String playerTeam = spinner.getSelectedItem().toString();

        if (!TextUtils.isEmpty(playerName)) {

            String playerId = databasePlayer.push().getKey();

            com.example.lelepedia.Dota.Player player = new Player(playerId, playerName, playerNickname, playerJoin, playerTeam);

            databasePlayer.child(playerId).setValue(player);
            Toast.makeText(getActivity(), "Player Baru Berhasil Ditambahkan", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getActivity(), "Nama Harus Diisi", Toast.LENGTH_LONG).show();
        }
    }
}