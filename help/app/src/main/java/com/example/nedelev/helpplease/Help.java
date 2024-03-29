package com.example.nedelev.helpplease;

import java.util.ArrayList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


public class Help extends AppCompatActivity {

    private RequestHandler distressObject;
    private ArrayList<String> typeOfEmergency = new ArrayList<String>();

    private CompoundButton.OnCheckedChangeListener sinking = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            whatAlert(button, isChecked);
        }
    };
    private CompoundButton.OnCheckedChangeListener drowning = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            whatAlert(button,isChecked);
        }
    };
    private CompoundButton.OnCheckedChangeListener medicine = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            whatAlert(button,isChecked);
        }
    };
    private CompoundButton.OnCheckedChangeListener fire = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            whatAlert(button,isChecked);
        }
    };
    private CompoundButton.OnCheckedChangeListener lost = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            whatAlert(button,isChecked);
        }
    };
    private CompoundButton.OnCheckedChangeListener injury = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            whatAlert(button,isChecked);
        }
    };
    private CompoundButton.OnCheckedChangeListener assault = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            whatAlert(button,isChecked);
        }
    };
    private CompoundButton.OnCheckedChangeListener engine = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            whatAlert(button,isChecked);
        }
    };
    private View.OnClickListener send = new View.OnClickListener() {
        public void onClick(View v) {
            whatAlert(null,false);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        distressObject =(RequestHandler) getIntent().getSerializableExtra("distress");
        ToggleButton sinking = (ToggleButton)findViewById(R.id.toggleButton);
        // Register the onClick listener with the implementation above
        sinking.setOnCheckedChangeListener(this.sinking);
        ToggleButton drowning = (ToggleButton)findViewById(R.id.toggleButton2);
        // Register the onClick listener with the implementation above
        drowning.setOnCheckedChangeListener(this.drowning);
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
        assault.setOnCheckedChangeListener(this.assault);
        ToggleButton engine = (ToggleButton)findViewById(R.id.toggleButton6);
        // Register the onClick listener with the implementation above
        engine.setOnCheckedChangeListener(this.engine);
        Button send = (Button)findViewById(R.id.button2);
        // Register the onClick listener with the implementation above
        send.setOnClickListener(this.send);

    }

    private void whatAlert(CompoundButton butt, boolean checked){
        if(checked) {
            switch (butt.getText().toString()) {
                case "SINKING":
                    typeOfEmergency.add("Sinking");
                    break;
                case "DROWNING":
                    typeOfEmergency.add("Drowning");
                    break;
                case "MEDICINE":
                    typeOfEmergency.add("Medicine");
                    break;
                case "INJURY":
                    typeOfEmergency.add("Injury");
                    break;
                case "FIRE":
                    typeOfEmergency.add("Fire");
                    break;
                case "ASSAULT":
                    typeOfEmergency.add("Assault");
                    break;
                case "LOST":
                    typeOfEmergency.add("Lost");
                    break;
                case "ENGINE":
                    typeOfEmergency.add("Engine");
                    break;
                default:
                    send();
                    break;
            }
        } else {
            if (butt == null) {
                send();
            }
        }

    }
    private void send(){
        for(int i = 0 ; typeOfEmergency.size()<i; i++){
            distressObject.put("incidentType", typeOfEmergency.get(i));
        }
        Intent intent = new Intent(this, Distress.class);
        intent.putExtra("peopleNum", getIntent().getIntExtra("people",0));
        startActivity(intent);
    }

}
