package sokohuru.muchbeer.king.database;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @Override
    protected void onStart() {
        super.onStart();
        ContentResolver resolver = getContentResolver();
        Uri uri = ContentHelper.insertContent(resolver);
        Log.d(TAG, "Uri:" + uri.getPath());
        String data = ContentHelper.fetchContent(resolver, uri);
        TextView view = (TextView)findViewById(R.id.data);
        view.setText(data);

        int rows = ContentHelper.updateContent(resolver, uri);
        Log.d(TAG, "Rows Updated:"+ rows);
        data = ContentHelper.fetchContent(resolver, uri);
        TextView updateView = (TextView)findViewById(R.id.updatedata);
        updateView.setText(data);

        rows = ContentHelper.deleteContent(resolver);
        Log.d(TAG, "Rows Deleted:"+ rows);
    }


}
