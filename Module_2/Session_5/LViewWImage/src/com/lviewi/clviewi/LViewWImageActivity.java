package com.lviewi.clviewi;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LViewWImageActivity extends ListActivity implements OnItemClickListener {
	static final String[] MOBILE_OS =
            new String[] { "Android", "iOS", "Blackberry"};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setListAdapter(new MobileArrayAdapter(this, MOBILE_OS));
        
        //setListAdapter(new ArrayAdapter<String>(this, R.layout.main,MOBILE_OS));

		//ListView listView = getListView();
		//listView.setTextFilterEnabled(true);
		
		//listView.setOnItemClickListener(this);
    }

	public void onItemClick(AdapterView<?> arg0,View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		TextView tv = (TextView)arg1;
		String s = tv.getText().toString();
		
		Toast.makeText(this,s, Toast.LENGTH_LONG).show();
	}
    
}