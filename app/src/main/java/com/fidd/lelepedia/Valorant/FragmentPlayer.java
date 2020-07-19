package com.fidd.lelepedia.Valorant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fidd.lelepedia.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragmentPlayer extends Fragment {

    DatabaseReference reference;
    RecyclerView recyclerView;
    View view;
    ArrayList<Player> list;
    RecycleAdapter adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_valorant_player, container, false);

        recyclerView = view.findViewById(R.id.MyRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<Player>();

        reference = FirebaseDatabase.getInstance().getReference().child("valorant");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Player p = dataSnapshot1.getValue(Player.class);
                    list.add(p);

                }
                adapter = new RecycleAdapter(getActivity(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Ooopss... Ada Yang Salah nih", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
