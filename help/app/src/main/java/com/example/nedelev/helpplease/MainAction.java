package com.example.nedelev.helpplease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;


public class MainAction extends AppCompatActivity {

    private ParseObject journeyObject;
    private Boat boat;
    private Journey journey;

    private View.OnClickListener help = new View.OnClickListener() {
        public void onClick(View v) {
            ParseObject distressObject = new ParseObject("Distress");
            distressObject.put("journey", journeyObject.getObjectId());
            distressObject.saveInBackground();
            RequestHandler distressHandler = new RequestHandler(distressObject);
            Intent intent = new Intent(v.getContext(), Help.class);
            //intent.putExtra("distress", distressHandler);
            intent.putExtra("people",journey.getNumberOfPassengers());
            startActivity(intent);
        }
    };
    private View.OnClickListener reg = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), Register.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Default configuration
        boat = new Boat(0, Boat.Size.MEDIUM, 3);
        journey = new Journey(boat, 2, this.getApplicationContext());
        //Connect to the Parse server
        Parse.initialize(new Parse.Configuration.Builder(this.getApplicationContext())
                        .applicationId("myAppId")
                        .server("http://178.62.115.151:1337/parse")
                        .build());
        //Setup default statsggit
        journeyObject = new ParseObject("Journey");
        //journeyObject.put("boat", boat);
        journeyObject.put("numPassengers", journey.getNumberOfPassengers());
        //journeyObject.put("currentLocation", new ParseGeoPoint(journey.getLocationList().get(0).getLatitude(), journey.getLocationList().get(1).getLatitude()));
        journeyObject.saveInBackground();
        Button helpMe = (Button)findViewById(R.id.helpButton);
        // Register the onClick listener with the implementation above
        helpMe.setOnClickListener(this.help);
        Button regMe = (Button)findViewById(R.id.button5);
        // Register the onClick listener with the implementation above
        regMe.setOnClickListener(this.reg);

    }
}