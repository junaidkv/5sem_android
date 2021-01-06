package com.pg7.cpg7;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class NotificationView extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
		// ---look up the notification manager service---
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// ---cancel the notification that we started
		/* Cancel a previously shown notification. If it's transient,
		 * the view will be hidden. If it's persistent, it will be removed from the status bar */
		nm.cancel(getIntent().getExtras().getInt("notificationID"));
		
		
	}


}
