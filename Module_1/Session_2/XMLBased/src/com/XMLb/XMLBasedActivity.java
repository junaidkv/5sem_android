package com.XMLb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class XMLBasedActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void OnPress(View v)
    {
    	Toast.makeText(getApplicationContext(), "Press", 3).show();
    }
}