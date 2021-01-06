package com.pg8.cpg8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PG8Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onSaveClick(View v)
    {
    	try
    	{
    		EditText e1 = (EditText)findViewById(R.id.et1);
    		EditText e2 = (EditText)findViewById(R.id.et2);
    		
    		/*
			File sdCard = Environment.getExternalStorageDirectory();
			File directory = new File (sdCard.getAbsolutePath() +"/MyFiles");
			directory.mkdirs();
			File file = new File(directory, "temptext.txt");
			FileOutputStream fOut = new FileOutputStream(file);
			*/

    		
    		FileOutputStream fout;
    		fout = openFileOutput(e1.getText().toString(),0);
    		OutputStreamWriter osw = new OutputStreamWriter(fout);
    		osw.write(e2.getText().toString());
    		osw.flush();
    		osw.close();
    	}
    	catch(Exception e)
    	{
    		Toast.makeText(this,e.toString(),Toast.LENGTH_LONG);
    	}
    	
    }
    public void onOpenClick(View v)
    {
    	try
    	{
    		EditText e1 = (EditText)findViewById(R.id.et1);
    		EditText e2 = (EditText)findViewById(R.id.et2);
    		
    		/*
			File sdCard = Environment.getExternalStorageDirectory();
			File directory = new File (sdCard.getAbsolutePath() + "/MyFiles");
			File file = new File(directory, "temptext.txt");
			FileInputStream fIn = new FileInputStream(file);
			
			*/

    		
    		FileInputStream fin;
    		fin = openFileInput(e1.getText().toString());
    		InputStreamReader isw = new InputStreamReader(fin);
    		char []b = new char[10];
    		int n = isw.read(b,0,10);
    		String str = new String(b,0,n);
    		e2.setText(str);
    		isw.close();
    	}
    	catch(Exception e)
    	{
    		Toast.makeText(this,e.toString(),Toast.LENGTH_LONG);
    	}
    	
    }
}