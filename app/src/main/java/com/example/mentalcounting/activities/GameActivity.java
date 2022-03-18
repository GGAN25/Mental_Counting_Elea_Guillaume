package com.example.mentalcounting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mentalcounting.R;
import com.example.mentalcounting.models.OperationModel;
import com.example.mentalcounting.models.exceptions.OperatorException;
import com.example.mentalcounting.services.OperationService;
import com.example.mentalcounting.services.ResolutionService;

public class GameActivity extends AppCompatActivity {

    private EditText et;
    private OperationModel om;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        et = findViewById(R.id.Reponse);
        TextView tw = findViewById(R.id.Operation);

        OperationService os = new OperationService();
        om = os.operation();

        String operation = om.getNumber1() + "   " + om.getOperator() + "   " + om.getNumber2();
        tw.setText(operation);

        Button SubmitButton = findViewById(R.id.Valider);
        Button ResetButton = findViewById(R.id.ResetButton);

        SubmitButton.setOnClickListener(view -> {
            try {
                Submit();
            } catch(OperatorException e) {
                e.printStackTrace();
            }

        });



        ResetButton.setOnClickListener(view -> {
            try {
                Reset();
            } catch (OperatorException e) {
                e.printStackTrace();
            }
        });

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
    private void Submit() throws OperatorException {
        int result = Integer.parseInt(et.getText().toString());
        verification(result);
    }

    private void Reset() throws OperatorException{
        finish();
        startActivity(getIntent());
    }




    @SuppressLint("ResourceAsColor")
    private void verification(int result) throws OperatorException {
        ResolutionService vs = new ResolutionService();

        TextView resultTextView = findViewById(R.id.Result);
        TextView goodanswerTextView = findViewById(R.id.GoodResult);
        TextView wronganswerTextView = findViewById(R.id.WrongResult);
        if(vs.Verif(om, result)){

            goodanswerTextView.setVisibility(View.VISIBLE);
            wronganswerTextView.setVisibility(View.INVISIBLE);
            resultTextView.setVisibility(View.INVISIBLE);


        } else{
            wronganswerTextView.setVisibility(View.VISIBLE);
            goodanswerTextView.setVisibility(View.INVISIBLE);
            resultTextView.setVisibility(View.INVISIBLE);

        }
    }

}