package com.tha.cth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class TH_APPActivity extends Activity implements Runnable {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ExecutorService taskList = 
                Executors.newFixedThreadPool(50);
        taskList.execute(this);
    }

	public void run() {
		// TODO Auto-generated method stub
		try
		{
		for (int i = 0; i < 20; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread:" + threadName+ i);
            try {
                Thread.sleep(1000);
            } 
            catch(Exception e)
            {
            	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
		}
		catch(Exception ee)
		{
			Toast.makeText(this, ee.toString(), Toast.LENGTH_LONG).show();
		}
	}
}