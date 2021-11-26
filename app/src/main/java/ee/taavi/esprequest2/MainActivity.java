package ee.taavi.esprequest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnLedOnClicked(View v) {
        makeRequest("on");
    }

    public void btnLedOffClicked(View v) {
        makeRequest("off");
    }

    private void makeRequest(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String host = "http://192.168.4.1";
        String path = host + "/" + url;
        Log.e("MAIN", path);

        StringRequest strReq = new StringRequest(Request.Method.GET, path,
                response -> Log.e("MAIN", "Response: " + response),
                error -> Log.e("MAIN", "Error with response: " + error.toString())
        );

        queue.add(strReq);
    }
}