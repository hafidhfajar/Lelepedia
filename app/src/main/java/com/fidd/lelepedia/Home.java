package com.fidd.lelepedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.fidd.lelepedia.Valorant.MenuValorant;
import com.fidd.lelepedia.Dota.MenuDota;
import com.fidd.lelepedia.R6.MenuR6;

public class Home extends AppCompatActivity {


    ImageButton dota,cs,r6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dota = (ImageButton) findViewById(R.id.btn_dota);
        cs = (ImageButton) findViewById(R.id.btn_cs);
        r6 = (ImageButton) findViewById(R.id.btn_r6);

        dota.setOnClickListener (new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MenuDota.class);
                startActivity(intent);

            }
        });

        cs.setOnClickListener (new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MenuValorant.class);
                startActivity(intent);

            }
        });

        r6.setOnClickListener (new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MenuR6.class);
                startActivity(intent);

            }
        });
    }
}
