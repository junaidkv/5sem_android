package com.act.csa1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SA1Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onLoadActivity(View v)
    {
    	Intent obj = new Intent("activity.second");
    	startActivity(obj);
    }
}