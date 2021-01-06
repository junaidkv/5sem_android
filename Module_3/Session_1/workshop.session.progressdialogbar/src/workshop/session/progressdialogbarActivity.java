package workshop.session;

import workshop.session.progressdialogbar.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class progressdialogbarActivity extends Activity  implements Runnable{
	ProgressDialog pbd;
	Handler h;
	int pv = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         
        
    }
    public void run()
    {
    	try
    	{
    		while(pv<=100)
    		{
    			Thread.sleep(500);
    			pv += 10;
    			h.post(new Runnable()
    			{
    				public void run()
    				{
    					pbd.setProgress(pv);
    				}
    			});
    		}
    		Thread.sleep(500);
    		pbd.dismiss();
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    public void onDownLoad(View v)
    {
    	pv = 0;
    	h = new Handler();
    	pbd = new ProgressDialog(v.getContext());
        pbd.setMax(100);
        pbd.setProgress(0);
        pbd.setCancelable(true);  
        pbd.setMessage("File downloading ...");  
        pbd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); 
    	pbd.show();
    	Thread t = new Thread(this);
    	t.start();
    }
}