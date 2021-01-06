package com.cdtp.ccddttpp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class DTPActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onShow(View v)
    {
    	DatePicker dp = (DatePicker)findViewById(R.id.dp1);
    	TimePicker tp = (TimePicker)findViewById(R.id.tp1);
    	EditText e = (EditText)findViewById(R.id.et1);
    	
    	String s;
    	s = "" + dp.getDayOfMonth()+ "/" + (dp.getMonth() + 1) + "/" + dp.getYear();
    	s = s + "\n";
    	s = s + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + ":";
    	
    	e.setText(s);
    	
    	//Toast.makeText(this, dp.,3).show();
    	//Toast.makeText(this, tp.toString(),3).show();
    }
}