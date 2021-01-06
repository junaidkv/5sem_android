package com.pg101.cpg101;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PG101Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button bs = (Button)findViewById(R.id.button1);
        Button be = (Button)findViewById(R.id.button2);
        
        bs.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				
				startService(new Intent("my.service2"));
				
			}
		});
        
        be.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				
				stopService(new Intent("my.service2"));
				
			}
		});

    }
}