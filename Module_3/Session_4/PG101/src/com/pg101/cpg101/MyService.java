package com.pg101.cpg101;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// We want this service to continue running until it is explicitly
		// stopped, so return sticky.
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		return START_STICKY;
		/* 
		    In this method, you returned the constant START_STICKY so that
			the service will continue to run until it is explicitly stopped.
		*/
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	}
}