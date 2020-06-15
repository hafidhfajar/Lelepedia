package com.example.lelepedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                }   catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashScreen.this, Home.class));
                }
            }
        };
        thread.start();
    }
}
