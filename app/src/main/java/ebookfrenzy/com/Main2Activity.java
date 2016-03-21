package ebookfrenzy.com;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ebookfrenzy.assignment.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private ListView listv; //initialize list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        listv = (ListView) findViewById(R.id.listView);

        // Instantiate array list
        List<String> array_list = new ArrayList<String>();
        array_list.add("Push-ups");
        array_list.add("Sit-ups");
        array_list.add("Pull-ups");
        array_list.add("Dips");
        array_list.add("Chest press");
        array_list.add("Run");
        // Array adapter that takes the context of the activity,
        // the type of list view, and array.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                array_list );
        listv.setAdapter(arrayAdapter);

    }

}
