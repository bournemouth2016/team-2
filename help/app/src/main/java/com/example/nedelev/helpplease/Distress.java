import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.*;


public class Distress extends AppCompatActivity implements Runnable {
    private boolean helpArrived = false;
    private int numOfRes = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_distress);
        new Thread.run();
    }

    public int comming(){
        numOfRes++;
        return numOfRes;
    }

    private void helpArrived(){
        helpArrived = true;
        generateReport();
    }
    private void generateReport(){

    }

    @Orverride
    public void run(){
        private OnClickListener halpArrived = new OnClickListener() {
            public void onClick(View v) {
              helpArrived()  ;
            }
        };
        Button help = (Button)findViewById(R.id.button);
        // Register the onClick listener with the implementation above
        help.setOnClickListener(this.send);
        TextView editText = (TextView)findViewById(R.id.rescuers_coming);
        while (helpArrived == false){
            editText.setText(numOfRes.toString());
            Thread.sleep(3000)
        }
    }


}