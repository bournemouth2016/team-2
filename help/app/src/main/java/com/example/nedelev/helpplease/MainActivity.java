package com.example.nedelev.helpplease;

import java.util.ArrayList;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> typeOfEmergency = new ArrayList<Integer>();

    private OnCheckedChangeListener sinking = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
            whatAlert(toggleButton,isChecked);
        }
    }) ;
    private OnCheckedChangeListener drowining = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
            whatAlert(toggleButton,isChecked);
        }
    }) ;
    private OnCheckedChangeListener medicine = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
            whatAlert(toggleButton,isChecked);
        }
    }) ;
    private OnCheckedChangeListener fire = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
            whatAlert(toggleButton,isChecked);
        }
    }) ;
    private OnCheckedChangeListener lost = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
            whatAlert(toggleButton,isChecked);
        }
    }) ;
    private OnCheckedChangeListener injury = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
            whatAlert(toggleButton,isChecked);
        }
    }) ;
    private OnCheckedChangeListener assault = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
            whatAlert(toggleButton,isChecked);
        }
    }) ;
    private OnCheckedChangeListener engine = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
            whatAlert(toggleButton,isChecked);
        }
    }) ;
    private OnClickListener send = new OnClickListener() {
        public void onClick(View v) {
            whatAlert(null,false);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        ToggleButton siking = (ToggleButton)findViewById(R.id.toggleButton);
        // Register the onClick listener with the implementation above
        sinking.setOnCheckedChangeListener(this.sinking);
        ToggleButton drowinig = (ToggleButton)findViewById(R.id.toggleButton2);
        // Register the onClick listener with the implementation above
        drowning.setOnCheckedChangeListener(this.drowining);
        ToggleButton medicine = (ToggleButton)findViewById(R.id.toggleButton3);
        // Register the onClick listener with the implementation above
        medicine.setOnCheckedChangeListener(this.medicine);
        ToggleButton fire = (ToggleButton)findViewById(R.id.toggleButton7);
        // Register the onClick listener with the implementation above
        fire.setOnCheckedChangeListener(this.fire);
        ToggleButton lost = (ToggleButton)findViewById(R.id.toggleButton8);
        // Register the onClick listener with the implementation above
        lost.setOnCheckedChangeListener(this.lost);
        ToggleButton injury = (ToggleButton)findViewById(R.id.toggleButton4);
        // Register the onClick listener with the implementation above
        injury.setOnCheckedChangeListener(this.injury);
        ToggleButton assault = (ToggleButton)findViewById(R.id.toggleButton5);
        // Register the onClick listener with the implementation above
        assault.setOnCheckedChangeListenerr(this.assault);
        ToggleButton engine = (ToggleButton)findViewById(R.id.toggleButton6);
        // Register the onClick listener with the implementation above
        engine.setOnCheckedChangeListener(this.engine);
        Button send = (Button)findViewById(R.id.button2);
        // Register the onClick listener with the implementation above
        send.setOnClickListener(this.send);

    }

    private void whatAlert(ToggleButton butt, boolean checked){
        if(checked) {
            switch (ToggleButton.getText()) {
                case "SINKING":
                    typeOfEmergency.add(1);
                    break;
                case "DROWNING":
                    typeOfEmergency.add(2);
                    break;
                case "MEDICINE":
                    typeOfEmergency.add(3);
                    break;
                case "INJURY":
                    typeOfEmergency.add(4);
                    break;
                case "FIRE":
                    typeOfEmergency.add(5);
                    break;
                case "ASSAULT":
                    typeOfEmergency.add(6);
                    break;
                case "LOST":
                    typeOfEmergency.add(7);
                    break;
                case "ENGINE":
                    typeOfEmergency.add(8);
                    break;
                default:
                    send();
                    break;
            }
        }

    }
    private send(){
        Intent intent = new Intent(this, Distress.class);
        startActivity(intent);
    }

}
