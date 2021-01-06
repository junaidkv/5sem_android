package com.ra;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class SumActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        processSum();
        finish();
    }
    public void processSum()
    {
    	Intent I;
    	I = getIntent();
    	Bundle B;
    	B = I.getExtras();
    	int a,b;
    	a = Integer.parseInt(B.getString("no1"));
    	b = Integer.parseInt(B.getString("no2"));
    	int s = a + b;
    	Intent IR = new Intent();
    	IR.setData(Uri.parse("" + s));
    	setResult(RESULT_OK,IR);
    }
}