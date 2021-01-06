package com.dbapp.cdbapp;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DB_APPActivity extends Activity {
	CDB db;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        db = new CDB(this);
    }
    public void onAdd(View v)
    {
    	 
    	EditText e2,e3;
    	e2 = (EditText)findViewById(R.id.e2);
    	e3 = (EditText)findViewById(R.id.e3);
    	CUser rec = new CUser();
    	rec.uname = e2.getText().toString();
    	rec.name = e3.getText().toString();
    	db.add(rec);
    	
    	e2.setText("");
    	e3.setText("");
    	
    }
    public void onSearch(View v)
    {
    	EditText e1,e2,e3;
    	CUser rec = null;
    	e1 = (EditText)findViewById(R.id.e1);
    	e2 = (EditText)findViewById(R.id.e2);
    	e3 = (EditText)findViewById(R.id.e3);
    	rec = db.getOneContact(Integer.parseInt(e1.getText().toString()));
    	if(rec != null)
    	{
    		e2.setText(rec.uname);
    		e3.setText(rec.name);
    	}
    	else
    	{
    		Toast.makeText(this, "Not FOund..", Toast.LENGTH_LONG);
    	}
    }
    public void onDelete(View v)
    {
    	EditText e1;
    	e1 = (EditText)findViewById(R.id.e1);
    	db.delete(Integer.parseInt(e1.getText().toString()));
    	
    }
    public void onUpdate(View v)
    {
    	EditText e1,e2,e3;
    	e1 = (EditText)findViewById(R.id.e1);
    	e2 = (EditText)findViewById(R.id.e2);
    	e3 = (EditText)findViewById(R.id.e3);
    	CUser rec = new CUser();
    	rec.id = Integer.parseInt(e1.getText().toString());
    	rec.uname = e2.getText().toString();
    	rec.name = e3.getText().toString();
    	db.update(rec);
    	
    	e1.setText("");
    	e2.setText("");
    	e3.setText("");
    }
    public void onList(View v)
    {
    	 List<CUser> rec = db.getAllvalues();
         String str = "";
         for (CUser cr : rec) {
             String log = "Id: " + cr.id + " ,UNAME: " + cr.uname + ",NAME:" + cr.name;
             log = log + "\n";
             str = str + log;
         }
         TextView t = (TextView)findViewById(R.id.tv);
         t.setText(str);

    }
}