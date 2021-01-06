package com.lv.clv;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LViewActivity extends ListActivity implements OnItemClickListener {
    static final String []lst = new String [] { "One", "Two", "Three" };
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setContentView(R.layout.main);
        setListAdapter(new ArrayAdapter<String>(this,R.layout.main,lst));
        ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		
		listView.setOnItemClickListener(this);
    }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		String s;
		TextView tv = (TextView)arg1;
		s = (String)tv.getText().toString();
		Toast.makeText(this,s, 2).show();
	}
}