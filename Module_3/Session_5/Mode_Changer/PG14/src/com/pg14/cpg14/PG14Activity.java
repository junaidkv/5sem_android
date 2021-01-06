package com.pg14.cpg14;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PG14Activity extends Activity {
	private AudioManager myAudioManager;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
    }
    public void onMode(View v)
    {
    	int mod=myAudioManager.getRingerMode();
        
        if(mod==AudioManager.RINGER_MODE_VIBRATE){
           Toast.makeText(PG14Activity.this,"Now in Vibrate Mode",Toast.LENGTH_LONG).show();
        }
        
        else if(mod==AudioManager.RINGER_MODE_NORMAL){
           Toast.makeText(PG14Activity.this,"Now in Ringing Mode",Toast.LENGTH_LONG).show();
        }
        
        else
        {
           Toast.makeText(PG14Activity.this,"Now in Vibrate Mode",Toast.LENGTH_LONG).show();
        }
    }
    public void onRing(View v)
    {
    	myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        Toast.makeText(this,"Now in Ringing Mode",Toast.LENGTH_LONG).show();
    }
    public void onSilent(View v)
    {
    	myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        Toast.makeText(this,"Now in silent Mode",Toast.LENGTH_LONG).show();
    }
    public void onVibrate(View v)
    {
    	myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        Toast.makeText(this,"Now in Vibrate Mode",Toast.LENGTH_LONG).show();
    }
    
}