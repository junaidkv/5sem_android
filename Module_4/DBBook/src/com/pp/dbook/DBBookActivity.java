package com.pp.dbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DBBookActivity extends Activity {
    /** Called when the activity is first created. */
	DBHelper db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        db = new DBHelper(this);
    }
    public void onAdd(View v)
    {
    	EditText e1 = (EditText)findViewById(R.id.e1);
    	EditText e2 = (EditText)findViewById(R.id.e2);
    	EditText e3 = (EditText)findViewById(R.id.e3);
    	db.addBook(e2.getText().toString(), e3.getText().toString());
    	e1.setText("");
    	e2.setText("");
    	e3.setText("");
    }
    public void onFind(View v)
    {
    	EditText e1 = (EditText)findViewById(R.id.e1);
    	EditText e2 = (EditText)findViewById(R.id.e2);
    	EditText e3 = (EditText)findViewById(R.id.e3);
    	Book b = db.getOneBook(e1.getText().toString());
    	if(b != null)
    	{
    		e2.setText(b.bname);
    		e3.setText(b.aname);
    	}
    }
}