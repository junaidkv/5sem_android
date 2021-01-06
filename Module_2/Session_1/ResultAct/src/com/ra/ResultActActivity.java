package com.ra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResultActActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onSum(View v)
    {
    	EditText e1,e2;
    	e1 = (EditText)findViewById(R.id.et1);
    	e2 = (EditText)findViewById(R.id.et2);
    	
    	Intent IS = new Intent("a.sum");
    	IS.putExtra("no1", e1.getText().toString());
    	IS.putExtra("no2", e2.getText().toString());
    	startActivityForResult(IS,1);
    }
    @Override
    protected void onActivityResult(int rq,int rc,Intent data)
    {
    	super.onActivityResult(rq, rc, data);
    	EditText e3 = (EditText)findViewById(R.id.et3);
    	if(rc == RESULT_OK)
    	{
    		e3.setText(data.getData().toString());
    	}	
    }

}