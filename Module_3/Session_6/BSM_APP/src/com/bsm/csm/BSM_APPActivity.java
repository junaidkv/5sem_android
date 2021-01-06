package com.bsm.csm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BSM_APPActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onCI(View v)
    {
    	Intent intent = new Intent();
    	intent.setAction("android.intent.action.CUSTOM_INTENT");
    	sendBroadcast(intent);
    }
}