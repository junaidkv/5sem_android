package workshop.session;

import workshop.session.pbar.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class pbarActivity extends Activity implements Runnable {
	ProgressBar pb1,pb2;
	int pv = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        pb1 = (ProgressBar)findViewById(R.id.pb1);
        pb2 = (ProgressBar)findViewById(R.id.pb2);
        pb1.setMax(100);
        pb2.setMax(100);
        pb1.setProgress(0);
        pb2.setProgress(0);
        pb2.setEnabled(false);
    }
    
    public void run()
    {
    	try
    	{
    		while (pv <= 100)
    		{
    			Thread.sleep(200);
    			pv += 10;
    			pb1.setProgress(pv);
    			pb2.setProgress(pv);
    		}
    		pb2.setEnabled(false);
    		Toast.makeText(this, "Complted..", 3).show();
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    public void onStart(View v)
    {
    	pv = 0;
    	pb2.setEnabled(true);
    	Thread t;
    	t = new Thread(this);
    	t.start();
    }
    
}