package com.paimage.caimage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AImageActivity extends Activity {
	String a[];
	int pos = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         a = new String[5];
         a[0] = "ic_launcher.png";
         a[1] = "i1.PNG";
         a[2] = "dw.png";
         a[3] = "totest.PNG";
         a[4] = "ic_launcher1.png";
         pos = 0;
        setContentView(R.layout.main);
    }
    public void onShow(View v)
    {
    	ImageView ig;
    	ig = (ImageView)findViewById(R.id.imageView1);
    	pos = (pos + 1) % 5;
    	if(pos == 0 )
    	{
    		ig.setImageResource(R.drawable.i1);
    	}
    	else if(pos == 1)
    	{
    		ig.setImageResource(R.drawable.ic_launcher);
    	}
    	else if(pos == 2)
    	{
    		ig.setImageResource(R.drawable.totest);
    	}
    	else if(pos == 3)
    	{
    		ig.setImageResource(R.drawable.ic_launcher1);
    	}
    	else 
    	{
    		ig.setImageResource(R.drawable.dw);
    	}
    	
    	
    	//Toast.makeText(this, "Image Button", Toast.LENGTH_LONG).show();
    }
}