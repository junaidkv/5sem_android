package com.hb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HybridBasedActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button bPress;
        setContentView(R.layout.main);
        bPress = (Button)findViewById(R.id.bPress);
        bPress.setOnClickListener(this);
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		EditText txtName;
		txtName = (EditText)findViewById(R.id.txtName);
		txtName.setText("Hybrid Based...");
	}
}