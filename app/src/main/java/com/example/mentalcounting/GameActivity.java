package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gamemenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Score:
                startActivity(new Intent(getApplicationContext(),ScoreActivity.class));
                break;
            case R.id.Reset:
                Toast.makeText(getApplicationContext(), getString(R.string.resetscore), Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }
}