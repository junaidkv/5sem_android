package com.vpa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class second extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        processMax();
    }
    public void processMax()
    {
    	String a,b;
    	int p,q;
    	TextView tv;
    	tv = (TextView)findViewById(R.id.tv1);
    	Bundle bObj = getIntent().getExtras();
    	a = bObj.getString("no1");
    	b = bObj.getString("no2");
    	p = Integer.parseInt(a);
    	q = Integer.parseInt(b);
    	if(p > q)
    		tv.setText("Max : " + a);
    	else
    		tv.setText("Max : " + b);
    }
    public void onHide(View v)
    {
    	finish();
    }
}
