package com.calc.cadd;

//import com.edit.et.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CALC_APPActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onMinus(View v)
    {
    	int n1=5,n2=3,ans;
    	try
    	{
    		EditText sNo1 = (EditText)findViewById(R.id.eT1);
    		EditText sNo2 = (EditText)findViewById(R.id.eT2);
    		EditText sAns = (EditText)findViewById(R.id.eT3);
    		n1 = Integer.parseInt(sNo1.getText().toString());
    		n2 = Integer.parseInt(sNo2.getText().toString());
    		ans = n1-n2;
    		String s = "";
    		s = s + ans;
    		sAns.setText(s);
    	}
    	catch(Exception e)
    	{
    		Toast.makeText(this,"Error in No",Toast.LENGTH_LONG).show();
    	}
    }
    public void onPlus(View v)
    {
    	int n1=5,n2=3,ans;
    	try
    	{
    		EditText sNo1 = (EditText)findViewById(R.id.eT1);
    		EditText sNo2 = (EditText)findViewById(R.id.eT2);
    		EditText sAns = (EditText)findViewById(R.id.eT3);
    		n1 = Integer.parseInt(sNo1.getText().toString());
    		n2 = Integer.parseInt(sNo2.getText().toString());
    		ans = n1+n2;
    		String s = "";
    		s = s + ans;
    		sAns.setText(s);
    	}
    	catch(Exception e)
    	{
    		Toast.makeText(this,"Error in No",Toast.LENGTH_LONG).show();
    	}
    }
}