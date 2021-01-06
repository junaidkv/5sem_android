package com.btpcli.btccli;

import android.app.Activity;
import android.os.Bundle;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Environment;

public class BtclientActivity extends Activity {
 EditText editTextAddress;
 Button buttonConnect;
 TextView textPort;

 static final int SocketServerPORT = 8080;


 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.main);

  editTextAddress = (EditText) findViewById(R.id.address);
  textPort = (TextView) findViewById(R.id.port);
  textPort.setText("port: " + SocketServerPORT);
  buttonConnect = (Button) findViewById(R.id.connect);
  
  buttonConnect.setOnClickListener(new OnClickListener(){

   public void onClick(View v) {
    ClientRxThread clientRxThread = 
     new ClientRxThread(
      editTextAddress.getText().toString(), 
      SocketServerPORT);
    
    clientRxThread.start();
   }});
 }

 private class ClientRxThread extends Thread {
  String dstAddress;
  int dstPort;

  ClientRxThread(String address, int port) {
   dstAddress = address;
   dstPort = port;
  }

  @Override
  public void run() {
   Socket socket = null;
   
   try {
    socket = new Socket(dstAddress, dstPort);
    
    //File file = new File(Environment.getExternalStorageDirectory(),"testclient.txt");
    
    byte[] bytes = new byte[1024];
    InputStream is = socket.getInputStream();
       FileOutputStream fos = openFileOutput("testclient.txt",0);
       BufferedOutputStream bos = new BufferedOutputStream(fos);
       int bytesRead = is.read(bytes, 0, bytes.length);
       bos.write(bytes, 0, bytesRead);
       bos.close();
       socket.close();
       
       BtclientActivity.this.runOnUiThread(new Runnable() {

    public void run() {
      Toast.makeText(BtclientActivity.this, 
        "Finished", 
        Toast.LENGTH_LONG).show();
     }});
    
   } catch (IOException e) {

    e.printStackTrace();
    
    final String eMsg = "Something wrong: " + e.getMessage();
    BtclientActivity.this.runOnUiThread(new Runnable() {

     public void run() {
      Toast.makeText(BtclientActivity.this, 
        eMsg, 
        Toast.LENGTH_LONG).show();
     }});
    
   } finally {
    if(socket != null){
     try {
      socket.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
   }
  }
 }

}
