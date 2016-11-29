package com.example.sergey.simpleplayer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sergey.simpleplayer.services.PlayBackService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent playBackIntent = PlayBackService.newInstanse(this);
        startService(playBackIntent);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stopService(PlayBackService.newInstanse(MainActivity.this));
            }
        }, 5000);
    }
}
