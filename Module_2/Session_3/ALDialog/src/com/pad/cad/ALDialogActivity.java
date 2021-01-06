package com.pad.cad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class ALDialogActivity extends Activity implements DialogInterface.OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Simple to be terminated with ESC
        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setMessage(" Are you Sure");
        obj.setCancelable(true);
        obj.show();
        */
        
        /*
        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setMessage(" Are you Sure");
        obj.setCancelable(true);
        obj.setPositiveButton("Yes",this);
        obj.setNegativeButton("No", this);
        //obj.show();
        
        AlertDialog d = obj.create();
        d.show();
        
        */
        
        /*
        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setMessage(" Are you Sure").setCancelable(true)
        	.setPositiveButton("Yes",this)
        	.setNegativeButton("No", this);
        //obj.show();
        
        AlertDialog d = obj.create();
        d.show();
        
        */
        
        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setMessage(" Are you Sure").setCancelable(true)
        	.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					finish();
				}
			})
        	.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					arg0.cancel();
				}
			});
        //obj.show();
        
        AlertDialog d = obj.create();
        d.show();
        setContentView(R.layout.main);
        
    }
    
    

	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		if(arg1 == -1)
		{
			finish();
		}
		else
		{
			arg0.cancel();
		}
	}
}