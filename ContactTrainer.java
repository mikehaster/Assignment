package ebookfrenzy.com;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ebookfrenzy.assignment.R;

public class ContactTrainer extends Activity {

    public static final String NUMBER = "555-555-5555";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTrainer(NUMBER);
            }
        });
    }

    public void showTelState(View aView){
        // Post: Effects of TelephonyState
        Intent intent =  new Intent(ContactTrainer.this, TeleStatus.class);
        startActivity(intent);
    }
    private void callTrainer(final String contactNum) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", contactNum, null)));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
