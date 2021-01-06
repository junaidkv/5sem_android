package com.pdwpb.cdwpb;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DownLoadAppWithPBActivity extends Activity implements Runnable{
	String qs;
	ProgressBar pb;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onDownLoad(View v)
    {
    	EditText e = (EditText)findViewById(R.id.et1);
    	qs = e.getText().toString();
    	pb = (ProgressBar)findViewById(R.id.pb);
    	pb.setProgress(0);
    	
    	Thread t = new Thread(this);
    	t.start();
    }
	public void run() {
		try 
    	{
			
    		URL url = new URL(qs);
    		URLConnection conexion = url.openConnection();
    		conexion.connect();
    		int lengthOfFile = conexion.getContentLength();
    		Log.d("ANDRO_ASYNC", "Lenght of file: " + lengthOfFile);
    		
    		pb.setMax(lengthOfFile);

    		InputStream input = new BufferedInputStream(url.openStream());
    		OutputStream output = new FileOutputStream("/sdcard/Download/test.pdf");
    		//OutputStream output = openFileOutput("test.pdf",0);

    		byte data[] = new byte[1024];
    		int count;
    		long total = 0;

    			while ((count = input.read(data)) != -1) 
    			{
    				total += count;
    				pb.setProgress((int)total);
    				
    				
    				output.write(data, 0, count);
    			}

    			output.flush();
    			output.close();
    			//input.close();
    	} 
    	catch (Exception ex) 
    	{
    		Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
    	}
	}
}