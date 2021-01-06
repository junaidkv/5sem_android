package com.edit.et;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EDITT_APPActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onclick(View v)
    {
    	EditText sEdit = (EditText)findViewById(R.id.st);
    	EditText dEdit = (EditText)findViewById(R.id.dt);
    	if(sEdit.getText().length() == 0)
    	{
    		Toast.makeText(this, "Enter the value in the First Edit Box", Toast.LENGTH_LONG).show();
    		sEdit.setFocusable(true);
    	}
    	else
    	{
    		dEdit.setText(sEdit.getText());
    		sEdit.setText("");
    	}
        
    }
}