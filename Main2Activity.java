package ebookfrenzy.com;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ebookfrenzy.assignment.R;
import java.util.ArrayList;
import java.util.List;
public class Main2Activity extends Activity {

    ListView listv; //initialize list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

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
