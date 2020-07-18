package com.example.lelepedia.R6;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.lelepedia.R;

public class MenuR6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_r6);
        BottomNavigationView bottomnav = findViewById(R.id.bot_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new FragmentPlayer()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.nav_player :
                    selectedFragment = new FragmentPlayer();
                    break;
                case R.id.nav_team :
                    selectedFragment = new FragmentTeam();
                    break;
                case R.id.nav_transfer :
                    selectedFragment = new FragmentTransfer();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedFragment).commit();

            return true;
        }
    };
}
