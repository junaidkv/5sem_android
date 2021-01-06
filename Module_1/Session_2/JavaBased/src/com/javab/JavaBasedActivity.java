package com.javab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class JavaBasedActivity extends Activity {
	Button bPress;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bPress = new Button(this);
        bPress.setText("Press Me !");
        LinearLayout lWindow = new LinearLayout(this);
        lWindow.setOrientation(1);
        lWindow.addView(bPress);
        
        bPress.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Welcome TO Android Programming", 3).show();
			}
		});
        
        setContentView(lWindow);
    }
}