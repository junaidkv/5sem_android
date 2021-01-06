import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ACT1Activity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("MyApp","OnCreate()");
    }
    
    @Override
    public void onStart()
    {
    	super.onStart();
    	Log.d("MyApp","OnStart()");
    }
    
    @Override
    public void onStop()
    {
    	super.onStop();
    	Log.d("MyApp","OnStop()");
    }
    
    @Override
    public void onDestroy()
    {
    	super.onDestroy();
    	Log.d("MyApp","OnDestroy()");
    }
    
    @Override
    public void onResume()
    {
    	super.onResume();
    	Log.d("MyApp","Onresume()");
    }
    
    @Override
    public void onPause()
    {
    	super.onPause();
    	Log.d("MyApp","OnPause()");
    }
    
}