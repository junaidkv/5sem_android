package com.wm;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WifimActivity extends Activity {
	Button enableButton,disableButton;
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.main);

	      enableButton=(Button)findViewById(R.id.button1);
	      disableButton=(Button)findViewById(R.id.button2);

	      enableButton.setOnClickListener(new OnClickListener(){
	         public void onClick(View v){
	            WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	            wifi.setWifiEnabled(true);
	         }
	      });
			
	      disableButton.setOnClickListener(new OnClickListener(){
	         public void onClick(View v){
	            WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	            wifi.setWifiEnabled(false);
	         }
	      });
	   }
}