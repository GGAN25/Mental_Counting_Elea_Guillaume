package com.example.mentalcounting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mentalcounting.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoGame(View v){
        startActivity(new Intent(MainActivity.this,    GameActivity.class));
    }

    public void GoScore(View v){
        startActivity(new Intent(MainActivity.this,    ScoreActivity.class));
    }
}