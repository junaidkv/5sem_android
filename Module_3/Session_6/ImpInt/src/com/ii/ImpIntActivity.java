package com.ii;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ImpIntActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onshow(View v)
    {
    	EditText e = (EditText)findViewById(R.id.e1);
    	 String url=e.getText().toString();  
         Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));  
         startActivity(intent); 
    }
}