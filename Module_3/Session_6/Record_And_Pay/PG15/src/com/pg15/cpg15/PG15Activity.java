package com.pg15.cpg15;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PG15Activity extends Activity {
	
	private MediaRecorder myAudioRecorder;
	private String outputFile = null;
	Button play,stop,record;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try
        {
        
        record = (Button)findViewById(R.id.brec);
        stop = (Button)findViewById(R.id.bstop);
        play = (Button)findViewById(R.id.bplay);
        
        stop.setEnabled(false);
        play.setEnabled(false);
        
       

        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath();
        outputFile = outputFile + "/recording.3gp";
        
        Toast.makeText(getApplicationContext(), outputFile, Toast.LENGTH_LONG).show();
        
        
        myAudioRecorder=new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.DEFAULT);
        myAudioRecorder.setOutputFile(outputFile);
        }
        catch(Exception e)
        {
        	Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        	return;
        	
        }
        
       
        
    }
    public void onRecord(View v)
    {
    	try {
            myAudioRecorder.prepare();
            myAudioRecorder.start();
         }
         
         catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         record.setEnabled(false);
         stop.setEnabled(true);
         
         Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
    }
    public void onStop(View v)
    {
    	myAudioRecorder.stop();
        myAudioRecorder.release();
        myAudioRecorder  = null;
        
        stop.setEnabled(false);
        play.setEnabled(true);
        
        Toast.makeText(getApplicationContext(), "Audio recorded successfully",Toast.LENGTH_LONG).show();
    }
    public void onPlay(View v)
    {
    	MediaPlayer m = new MediaPlayer();
        
        try {
           m.setDataSource(outputFile);
        }
        
        catch (IOException e) {
           e.printStackTrace();
        }
        
        try {
           m.prepare();
        }
        
        catch (IOException e) {
           e.printStackTrace();
        }
        
        m.start();
        Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
    }
    
}