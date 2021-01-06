package com.vpa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class ValuePassActivityActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onMax(View v)
    {
    	EditText e1,e2;
    	e1 = (EditText)findViewById(R.id.et1);
    	e2 = (EditText)findViewById(R.id.et2);
    	
    	Intent iObj = new Intent("activity.second.max");
    	iObj.putExtra("no1", e1.getText().toString());
    	iObj.putExtra("no2", e2.getText().toString());
    	startActivity(iObj);
    }
    public void onMaximum(View v)
    {
    	EditText e1,e2;
    	e1 = (EditText)findViewById(R.id.et1);
    	e2 = (EditText)findViewById(R.id.et2);
    	
    	Intent iObj = new Intent(this,second.class);
    	iObj.putExtra("no1", e1.getText().toString());
    	iObj.putExtra("no2", e2.getText().toString());
    	startActivity(iObj);
    }
}