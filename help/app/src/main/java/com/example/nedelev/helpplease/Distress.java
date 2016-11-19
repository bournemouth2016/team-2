package com.example.nedelev.helpplease;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Distress extends AppCompatActivity  {
    private boolean helpArrived = false;
    private int numOfRes = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_distress);
        Button btnHelp = (Button)findViewById(R.id.button);
        // Register the onClick listener with the implementation above
        btnHelp.setOnClickListener(help);
        //new Distress().run();
    }

    public int comming(){
        numOfRes++;
        return numOfRes;
    }

    private View.OnClickListener help = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), Incident.class);
            startActivity(intent);
        }
    };

    private void helpArrived(){
        helpArrived = true;
        generateReport();
    }
    private void generateReport(){

    }

//    @Override
//    public void run(){
//        View.OnClickListener helpArrived = new View.OnClickListener() {
//            public void onClick(View v) {
//              helpArrived();
//            }
//        };
//        Button help = (Button)findViewById(R.id.button);
//        // Register the onClick listener with the implementation above
//        help.setOnClickListener(helpArrived);
//        TextView editText = (TextView)findViewById(R.id.rescuers_coming);
//        while (!this.helpArrived){
//            editText.setText(String.valueOf(numOfRes));
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                // ignore
//            }
//
//        }
//    }


}