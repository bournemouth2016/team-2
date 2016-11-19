package com.example.nedelev.helpplease;

import java.util.ArrayList;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;


public class MainAction extends AppCompatActivity {
    private View.OnClickListener help = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener reg = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("MyAppId")
                        .server("http://178.62.115.151:1337/parse")
                        .build());
        Button helpMe = (Button)findViewById(R.id.helpButton);
        // Register the onClick listener with the implementation above
        helpme.setOnClickListener(this.help);
        Button regme = (Button)findViewById(R.id.button5);
        // Register the onClick listener with the implementation above
        regMe.setOnClickListener(this.reg);

    }
}