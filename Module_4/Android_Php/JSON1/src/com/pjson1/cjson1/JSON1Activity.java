package com.pjson1.cjson1;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JSON1Activity extends Activity {
	
	public static final String JSON_STRING="{\"employee\":{\"name\":\"Sachin\",\"salary\":56000}}";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView textView1=(TextView)findViewById(R.id.textView1);

        try
        {
        	JSONObject emp=(new JSONObject(JSON_STRING)).getJSONObject("employee");
        	String empname=emp.getString("name");
        	int empsalary=emp.getInt("salary");
        	String str="Employee Name:"+empname+"\n"+"Employee Salary:"+empsalary;
        	textView1.setText(str);
        }
        catch (Exception e) 
        {
        	e.printStackTrace();
        }

    }
}