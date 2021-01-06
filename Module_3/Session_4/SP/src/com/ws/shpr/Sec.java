package com.ws.shpr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Sec extends Activity {
	EditText ed1,ed2;
	SharedPreferences sp;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec);
        ed1=(EditText)findViewById(R.id.e1);
        ed2=(EditText)findViewById(R.id.e2);
        
        sp = getSharedPreferences("SD", Context.MODE_PRIVATE);
        ed1.setText(sp.getString("un", "").toString());
        ed2.setText(sp.getString("up", "").toString());
    }
    public void onClose(View v)
    {
    	SharedPreferences.Editor ed = sp.edit();
    	ed.clear();
    	ed.commit();
    	finish();
    }
}