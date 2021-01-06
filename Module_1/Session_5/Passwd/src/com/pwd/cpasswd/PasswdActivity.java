package com.pwd.cpasswd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PasswdActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onLogin(View v)
    {
    	String str;
    	EditText e;
    	e = (EditText)findViewById(R.id.etUN);
    	str = e.getText().toString();
    	str = str + "   ";
    	e = (EditText)findViewById(R.id.etPWD);
    	str = str + e.getText().toString();
    	Toast.makeText(this,str,3).show();
    }
}