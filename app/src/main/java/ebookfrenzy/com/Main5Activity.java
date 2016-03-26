package ebookfrenzy.com;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.ebookfrenzy.assignment.MainActivity;
import com.ebookfrenzy.assignment.R;

public class Main5Activity extends AppCompatActivity {

    private Chronometer chrono; //initialize a Chronometer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        chrono = (Chronometer) findViewById(R.id.chronometer); //maps to chronometer

        Button button4 = (Button) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {//button on click
            @Override
            public void onClick(View view5) {
                chrono.start();//starts the timer
            }
        });

        Button button5 = (Button) findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {//button on click
            @Override
            public void onClick(View view5) {
                chrono.stop();//stops the timer
            }
        });

    }


}
