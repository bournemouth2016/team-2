package com.example.nedelev.helpplease;

import java.util.ArrayList;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainAction extends AppCompatActivity {
    private OnClickListener help = new OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
        }
    };
    private OnClickListener reg = new OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button helpMe = (Button)findViewById(R.id.helpButton);
        // Register the onClick listener with the implementation above
        helpme.setOnClickListener(this.help);
        Button regme = (Button)findViewById(R.id.button5);
        // Register the onClick listener with the implementation above
        regMe.setOnClickListener(this.reg);

    }
}