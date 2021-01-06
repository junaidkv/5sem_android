package workshop.session1;

import workshop.session1.checkboxdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class checkboxdemoActivity extends Activity {
	CheckBox c1,c2,c3;
	EditText e1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initControls();
    }
    public void initControls()
    {
    	c1 = (CheckBox) findViewById(R.id.cb1);
    	c2 = (CheckBox) findViewById(R.id.cb2);
    	c3 = (CheckBox) findViewById(R.id.cb3);
    	e1 = (EditText) findViewById(R.id.et1);
    }
    public void onSslc(View v)
    {
    	if(c1.isChecked() == false)
    	{
    		c2.setChecked(false);
    		c3.setChecked(false);
    	}
    }
    public void onselect(View v)
    {
    	String str = "";
    	
    	if(c1.isChecked())
    		str = str + c1.getText().toString();
    	if(c2.isChecked())
    		str = str + c2.getText().toString();
    	if(c3.isChecked())
    		str = str + c3.getText().toString();
    	e1.setText(str);
    }
}