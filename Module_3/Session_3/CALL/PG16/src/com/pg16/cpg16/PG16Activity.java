package com.pg16.cpg16;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PG16Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onCall(View v)
    {
    	Intent in=new Intent(Intent.ACTION_CALL,Uri.parse("tel:8606045590"));
        try{
           startActivity(in);
        }
        
        catch (android.content.ActivityNotFoundException ex){
           Toast.makeText(getApplicationContext(),"yourActivity is not founded.." + ex.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}