package ebookfrenzy.com;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.ebookfrenzy.assignment.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CalculateBMI extends Activity {

    ConnectivityManager connManager;
    NetworkInfo netInfo;

    public void onClickHandler(View view) {
        // Post1: networkInfo is current NetworkInfo value
        // Post2: No Internet connection or = postconditions of DownloadWebPageTask.execute()

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        final String BMI_URL = "http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm";
        if (networkInfo != null && networkInfo.isConnected()) {
            toast("Website access begun ...");
            new DownloadWebPageTask().execute(BMI_URL);
        } else {
            toast("No network connection available.");
        }
    }

    private String downloadUrl(String aUrl) throws IOException {
        // Post1: Return = first NUM_CHARS_DISPLAYED characters of page at aUrl, if possible
        // Post2: No opened InputStreams remain

        InputStream inStream = null;
        final int NUM_CHARS_DISPLAYED = 500;

        try {
            URL url = new URL(aUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            inStream = conn.getInputStream();
            String contentAsString = readIt(inStream, NUM_CHARS_DISPLAYED);
            return contentAsString;

            // Close InputStream after the app completed use
        } finally {
            if (inStream != null) {
                inStream.close();
            }
        }
    }

    public String readIt(InputStream anInStream, int aLen)
            throws IOException {
        // Post: return = first aLen characters of anInStream
        Reader reader = null;
        reader = new InputStreamReader(anInStream, "UTF-8");
        char[] buffer = new char[aLen];
        reader.read(buffer);
        return new String(buffer);
    }

    private void toast(String aToast) {
        Toast.makeText(getApplicationContext(), aToast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bmi);

        connManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        netInfo = connManager.getActiveNetworkInfo();

        Toast toast = Toast.makeText(getApplicationContext(), "APP BEGUN", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
        toast.show();


    }

    public void isConnected(View view) {  // for connected_button
        boolean isConnected = netInfo != null &&
                netInfo.isConnectedOrConnecting();
        toast(String.format("Connected: %s", isConnected));
    }

    // To create a task separate from the main UI thread
    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            // Pre: urls[0] is the parameter of execute() (i.e., when invoked by an AsycTask object)
            // Post = Postconditions for downloadUrl(urls[0])
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        @Override
        protected void onPostExecute(String aResult) {
            // Post: aResult is toasted
            toast(aResult);
        }
    }

}
