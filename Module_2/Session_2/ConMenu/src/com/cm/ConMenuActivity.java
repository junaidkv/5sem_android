package com.cm;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

public class ConMenuActivity extends Activity {
	TextView tv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView)findViewById(R.id.tv1);
        registerForContextMenu(tv);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) 
    {
    	// TODO Auto-generated method stub
    	super.onCreateContextMenu(menu, v, menuInfo);
    	menu.setHeaderTitle("Select");
    	menu.add("Call");
    	menu.add("SMS");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	if(item.getTitle().toString().equals("Call"))
    	{
    		Toast.makeText(this, "Calling...", 2).show();
    	}
    	else if(item.getTitle().toString().equals("SMS"))
    	{
    		Toast.makeText(this, "Sending...", 2).show();
    	}
    	return super.onContextItemSelected(item);
    }
}