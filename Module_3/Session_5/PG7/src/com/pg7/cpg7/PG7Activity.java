package com.pg7.cpg7;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PG7Activity extends Activity {
	int notificationID = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onb1Click(View v)
    {
    	displayNotification();
    	notificationID++;
    }
    protected void displayNotification() {
		
		Intent i = new Intent(this, NotificationView.class);
		i.putExtra("notificationID", notificationID);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
		/* getActivity() :: Retrieve a PendingIntent that will start a new activity, like calling Context.startActivity(Intent). 
		 * Note that the activity will be started outside of the context of an existing activity,  */
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		// We specified the name of the desired system service we want ie NOTIFICATION_SERVICE
		// So now a handle to that service will be returned to ' nm ' above
		
		Notification notif = new Notification(R.drawable.ic_launcher,"Reminder: Meeting starts in 5 minutes",System.currentTimeMillis());
		
		/* 
		Constructs a Notification object with the information needed to have a status bar icon without the standard expanded view.
     	Parameters
		icon : The resource id of the icon to put in the status bar. 
		tickerText : The text that flows by in the status bar when the notification first activates. 
		when : The time to show in the time field. In the System.currentTimeMillis timebase. 
		*/
		
		CharSequence from = "System Alarm";
		CharSequence message = "Meeting with customer at 3pm...";
		notif.setLatestEventInfo(this, from, message, pendingIntent);
		
		/* The intent(pendingIntent) to launch when the user clicks the expanded notification. */
		
		// ---100ms delay, vibrate for 250ms, pause for 100 ms and
		// then vibrate for 500ms---
		notif.vibrate = new long[] { 100, 250, 100, 500 };
		nm.notify(notificationID, notif);
	}

}