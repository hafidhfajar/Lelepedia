package com.fidd.lelepedia.Dota;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fidd.lelepedia.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OG extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleOG adapter;
    private ArrayList<Player> list;

    @Override
    public void onCreate(  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dota_og);

        recyclerView = findViewById(R.id.MyRecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new RecycleOG(this,list);
        recyclerView.setAdapter(adapter);

        //Memilih semua antek2
        Query query = FirebaseDatabase.getInstance().getReference("dota")
                .orderByChild("playerTeam")
                .equalTo("OG");
        query.addListenerForSingleValueEvent(value);

    }

    ValueEventListener value = new ValueEventListener() {
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
            //Toast.makeText(this, "Ooopss... Ada Yang Salah nih", Toast.LENGTH_LONG).show();
        }
    };
}