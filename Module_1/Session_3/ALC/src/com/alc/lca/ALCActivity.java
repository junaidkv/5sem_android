package com.alc.lca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ALCActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	Button bAct;
	final String TAG = "States";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bAct = (Button)findViewById(R.id.button1);
        bAct.setOnClickListener(this);
        
    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, ActivityTwo.class);
		  startActivity(intent);
		
	}
	
	  @Override
	  protected void onRestart() {
	    super.onRestart();
	    Log.d(TAG, "MainActivity: onRestart()");
	  }
	 
	  @Override
	  protected void onStart() {
	    super.onStart();
	    Log.d(TAG, "MainActivity: onStart()");
	  }
	 
	  @Override
	  protected void onResume() {
	    super.onResume();
	    Log.d(TAG, "MainActivity: onResume()");
	  }
	 
	  @Override
	  protected void onPause() {
	    super.onPause();
	    Log.d(TAG, "MainActivity: onPause()");
	  }
	 
	  @Override
	  protected void onStop() {
	    super.onStop();
	    Log.d(TAG, "MainActivity: onStop()");
	  }
	 
	  @Override
	  protected void onDestroy() {
	    super.onDestroy();
	    Log.d(TAG, "MainActivity: onDestroy()");
	  }
	
}