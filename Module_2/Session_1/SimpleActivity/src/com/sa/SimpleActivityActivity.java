package com.sa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SimpleActivityActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onShow(View v)
    {
    	Intent iObj;
    	iObj = new Intent("activity.sec");
    	startActivity(iObj);
    }
}