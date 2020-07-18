package com.example.lelepedia.R6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lelepedia.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragG2 extends Fragment {

   // DatabaseReference dbplayer;
    RecyclerView recyclerView;
    View view;
    ArrayList<Player> list;
    RecycleG2 adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.r6_g2, container, false);


        FragmentTeam fragment = new FragmentTeam();
        FragmentManager manager = getActivity().getSupportFragmentManager();

        manager.beginTransaction().add(R.id.r6_g2,fragment).commit();


        recyclerView = view.findViewById(R.id.MyRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<Player>();
        adapter = new RecycleG2(getActivity(),list);
        recyclerView.setAdapter(adapter);


       // dbplayer = FirebaseDatabase.getInstance().getReference().child("rainbow6");

        //Memilih semua antek2 G2
        Query query = FirebaseDatabase.getInstance().getReference("rainbow6")
                .orderByChild("PlayerTeam")
                .equalTo("G2 Esports");
        query.addListenerForSingleValueEvent(valueEventListener);



        return view;

    }
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            list.clear();
            if(dataSnapshot.exists()){
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Player player = snapshot.getValue(Player.class);
                    list.add(player);
                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getActivity(), "Ooopss... Ada Yang Salah nih", Toast.LENGTH_LONG).show();
        }
    };
}
