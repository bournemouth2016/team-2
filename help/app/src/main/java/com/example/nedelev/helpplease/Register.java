package com.example.nedelev.helpplease;

import java.util.ArrayList;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Register extends AppCompatActivity {
    private View.OnClickListener help = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), Help.class);
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

        Button helpMe = (Button)findViewById(R.id.helpButton);
        // Register the onClick listener with the implementation above
        helpMe.setOnClickListener(this.help);
        Button regMe = (Button)findViewById(R.id.button5);
        // Register the onClick listener with the implementation above
        regMe.setOnClickListener(this.reg);

    }
}