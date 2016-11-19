package com.example.nedelev.helpplease;

import java.util.ArrayList;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Register extends AppCompatActivity {

    private Button.OnClickListener submitPress = new Button.OnClickListener() {
        @Override public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), MainAction.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button submit = (Button)findViewById(R.id.submitButton);
        submit.setOnClickListener(this.submitPress);
    }
}