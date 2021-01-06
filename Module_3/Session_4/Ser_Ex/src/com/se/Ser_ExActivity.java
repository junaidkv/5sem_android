package com.se;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ser_ExActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onstarts(View v)
    {
    	startService(new Intent(this, MyService.class));  
    }
    public void onstops(View v)
    {
    	stopService(new Intent(this, MyService.class));
    }
    public void onsnext(View v)
    {
    	Intent intent=new Intent(this,NextPage.class);  
        startActivity(intent);  
    }
}