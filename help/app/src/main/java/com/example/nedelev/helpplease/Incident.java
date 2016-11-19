package com.example.nedelev.helpplease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseObject;

/**
 * Created by Dankoff on 19/11/2016.
 */

public class Incident extends AppCompatActivity {

    private int livesLost;
    private boolean vesselLost;
    private int peopleOnBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_distress);
        vesselLost = false;
        peopleOnBoard = getIntent().getIntExtra("peopleNum", 0);
        livesLost = 0;
        Button btnSubmit = (Button) findViewById(R.id.submit);
        btnSubmit.setOnClickListener(submit);
        updateLives();
    }

    public int getLivesLost() {
        return livesLost;
    }

    public int getLivesSaved() {
<<<<<<< HEAD
        return peopleOnBoard - livesLost;
=======
        return 0;
    }

    public void setLivesSaved(int livesSaved) {

>>>>>>> da9030ce6e4d95a474200745b9936cd209b284eb
    }

    public void setVesselLost(boolean lost) {
        vesselLost = lost;
    }

    public void setLivesLost(int livesLost) {
        this.livesLost = livesLost;
    }

    private View.OnClickListener livesUp = new View.OnClickListener() {
        public void onClick(View v) {
            livesLost++;
        }
    };

    private View.OnClickListener livesDown = new View.OnClickListener() {
        public void onClick(View v) {
            livesLost--;
        }
    };

    private View.OnClickListener submit = new View.OnClickListener() {
        public void onClick(View v) {
            updateServer();
            Intent intent = new Intent(v.getContext(), MainAction.class);
            startActivity(intent);
        }
    };

    private void updateLives() {
        Button btnUp = (Button)findViewById(R.id.increment_death);
        // Register the onClick listener with the implementation above
        btnUp.setOnClickListener(livesUp);
        Button btnDown = (Button)findViewById(R.id.decrement_death);
        // Register the onClick listener with the implementation above
        btnUp.setOnClickListener(livesDown);
    }

    private void updateServer() {
        ParseObject incidentReport = new ParseObject("Incident");
        incidentReport.put("casulties", livesLost);
        incidentReport.put("boatSaved", !vesselLost);
        incidentReport.saveInBackground();
    }
}
