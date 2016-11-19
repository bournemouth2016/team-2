package com.example.nedelev.helpplease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dankoff on 19/11/2016.
 */

public class Incident extends AppCompatActivity {

    private int livesLost;
    private boolean vesselLost;

    public Incident(){
        livesLost = 0;
        vesselLost = false;
    }

    public int getLivesLost() {
        return livesLost;
    }

    public int getLivesSaved() {

    }

    public void setLivesSaved(int livesSaved) {

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

    }
}
