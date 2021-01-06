package com.pdbis.cdbis;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DB_Insert_SelectActivity extends Activity {
	EditText e1,e2,e3;
	CDB db;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        e3 = (EditText)findViewById(R.id.e3);
        db = new CDB(this);
    }
    public void onSave(View v)
    {
    	String dn,dl;
    	dn = e2.getText().toString();
    	dl = e3.getText().toString();
    	Toast.makeText(this,dn + dl,3).show();
    	db.addDept(dn, dl);
    	e2.setText("");
    	e3.setText("");
    }
    public void onFind(View v)
    {
    	String a[];
    	try
    	{
    	String dno = e1.getText().toString();
    	a = db.getOneDepartment(Integer.parseInt(dno));
    	if(a[0] != "")
    	{
    		e2.setText(a[0]);
    		e3.setText(a[1]);
    	}
    	else
    	{
    		Toast.makeText(this,"Not Found..",3).show();
    	}
    	}
    	catch(Exception e)
    	{
    		Log.d("SELECT123",e.toString());
    	}
    }
    public void onDelete(View v)
    {
    	String dno = e1.getText().toString();
    	db.deleteDept(Integer.parseInt(dno));
    	e2.setText("");
    	e3.setText("");
    }
    public void onUpdate(View v)
    {
    	String dno = e1.getText().toString();
    	String dn,dl;
    	dn = e2.getText().toString();
    	dl = e3.getText().toString();
    	db.update(Integer.parseInt(dno), dn, dl);
    	e2.setText("");
    	e3.setText("");
    }
    
}