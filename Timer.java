package ebookfrenzy.com;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.ebookfrenzy.assignment.R;

public class Timer extends AppCompatActivity {

    private Chronometer chrono; //initialize a Chronometer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        // switchButton (button6 in activity_timer) starts RecommendedWorkout
        Button switchButton = (Button)findViewById(R.id.button6);
        final Intent intentForSecondActivity =
                new Intent(this, RecommendedWorkout.class);
        switchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentForSecondActivity);
            }
        });





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MileTimeDBHelper MileTimeDbHelper = new MileTimeDBHelper(getApplicationContext());


        // Data repository db is in write mode
        SQLiteDatabase db = MileTimeDbHelper.getWritableDatabase(); // Create SQLiteDatabase

        // Map of values created, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(MileTimeDBHelper.COL1_NAME, 0343); //column data

        // values inserted in row
        db.insert(MileTimeDBHelper.MILE_TABLE_NAME, null, values);

        SQLiteDatabase dBase = MileTimeDbHelper.getReadableDatabase();

        // projection specifies columns from the database
        String[] projection = {"time"};

        // Query c performed with projection
        Cursor c = dBase.query(
                MileTimeDBHelper.MILE_TABLE_NAME,     // table to query
                projection,                        // columns to return
                null,                               // columns for WHERE clause
                null,                               // values for WHERE clause
                null,                               // don't group rows
                null,                               // don't filter by row groups
                null                                // sort order
        );


        c.moveToFirst();
        int record = c.getInt(c.getColumnIndexOrThrow(MileTimeDBHelper.COL1_NAME));
        //we will parse the column data into a time format
        String format = "00:00";// minutes:seconds format
        int minutes = record / 60 + Integer.valueOf(format.substring(0,1));
        int seconds = record % 60 + Integer.valueOf(format.substring(3,4));
        String time = minutes+":"+seconds;
        toast("World Record Mile Time: " + time);
        toast("World Record Mile Time: " + time);

        c.close(); // close the cursor
        db.close(); //close the database

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_db, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String aToast){
        Toast.makeText(getApplicationContext(), aToast, Toast.LENGTH_SHORT).show();
    }

}
