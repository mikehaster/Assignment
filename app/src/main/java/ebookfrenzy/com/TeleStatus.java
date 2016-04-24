package ebookfrenzy.com;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ebookfrenzy.assignment.R;


public class TeleStatus extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public TextView telMgrOutput;

    @Override
    public void onStart() {
        super.onStart();

        // TelephonyManager
        final TelephonyManager telMgr =
                (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        this.telMgrOutput = (TextView) findViewById(R.id.textView);
        telMgrOutput.setText(telMgr.toString());
        String telephonyOverview = getTelephonyOverview(telMgr);
        telMgrOutput.setText(telephonyOverview);
    }

    public String getTelephonyOverview(final TelephonyManager telMgr) {
        // Post: telMgr in human-readable form has been returned

        // callState = state of the call (idle, ringing, off the hook etc.)
        int callState = telMgr.getCallState();
        String callStateString = "NA";
        switch (callState) {
            case TelephonyManager.CALL_STATE_IDLE:
                callStateString = "IDLE";
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                callStateString = "OFFHOOK";
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                callStateString = "RINGING";
                break;
        }
        // phoneType (GSM, CDMA, etc.)
        int phoneType = telMgr.getPhoneType();
        String phoneTypeString = "NA";
        switch (phoneType) {
            case TelephonyManager.PHONE_TYPE_GSM:
                phoneTypeString = "GSM";
                break;
            case TelephonyManager.PHONE_TYPE_CDMA:
                phoneTypeString = "CDMA";
                break;
            case TelephonyManager.PHONE_TYPE_NONE:
                phoneTypeString = "NONE";
                break;
        }
        // simState = state of sim card (pin requires, ready, etc.)
        int simState = telMgr.getSimState();
        String simStateString = "NA";
        switch (simState) {
            case TelephonyManager.SIM_STATE_ABSENT:
                simStateString = "ABSENT";
                break;
            case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                simStateString = "NETWORK_LOCKED";
                break;
            case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                simStateString = "PIN_REQUIRED";
                break;
            case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                simStateString = "PUK_REQUIRED";
                break;
            case TelephonyManager.SIM_STATE_READY:
                simStateString = "STATE_READY";
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN:
                simStateString = "STATE_UNKNOWN";
                break;
        }



        // return concatenation of the above data, with labels
        return "Telephone Manager:  " +
                "  \ncallState = " + callStateString +
                "  \nphoneTypeString = " + phoneTypeString +
                "  \nsimStateString = " + simStateString ;


    }
}



