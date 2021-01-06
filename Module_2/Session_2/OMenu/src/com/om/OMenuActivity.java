package com.om;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OMenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	if(item.getTitle().toString().equals("Exit"))
    	{
    		finish();
    		return true;
    	}
    	else if(item.getTitle().toString().equals("New"))
    	{
    		Toast.makeText(this, "New Menu Clicked", 2).show();
    	}
    	else if(item.getItemId() == R.id.about)
    	{
    		Toast.makeText(this, "About Menu Clicked", 2).show();
    	}
    	return true;
    }


}