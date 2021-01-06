package com.ws.shpr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SPActivity extends Activity {
	EditText ed1,ed2;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onLogin(View v)
    {
    	ed1=(EditText)findViewById(R.id.e1);
        ed2=(EditText)findViewById(R.id.e2);
        SharedPreferences sp;
        sp = getSharedPreferences("SD", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("un", ed1.getText().toString());
        ed.putString("up", ed2.getText().toString());
        ed.commit();
        Intent in = new Intent(this,Sec.class);
        startActivity(in);
    }
}