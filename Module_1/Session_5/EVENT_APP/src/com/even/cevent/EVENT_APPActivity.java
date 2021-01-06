package com.even.cevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EVENT_APPActivity extends Activity implements View.OnClickListener {
	TextView t;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b1,b2,b3;
        
        t = (TextView)findViewById(R.id.tv);
        b1 = (Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				t.setText("ONE CLICKED..");
			}
		});
        
        
        b2 = (Button)findViewById(R.id.b2);
        b2.setOnClickListener(new CClick());
        
        b3 = (Button)findViewById(R.id.b3);
        b3.setOnClickListener(this);
    }
    private class CClick implements View.OnClickListener
    {

		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			setTextValue("TWO");
		}
    	
    }
    public void setTextValue(String s)
    {
    	t.setText(s + " CLICKED....");
    }
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		setTextValue("Three");
	}
}