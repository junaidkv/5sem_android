package compbtser.ctserv;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

public class BtserverActivity extends Activity {

 TextView infoIp, infoPort;

 static final int SocketServerPORT = 8080;
 ServerSocket serverSocket;
 
 ServerSocketThread serverSocketThread;
 
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.main);
  infoIp = (TextView) findViewById(R.id.infoip);
  infoPort = (TextView) findViewById(R.id.infoport);

  infoIp.setText(getIpAddress());
  
  serverSocketThread = new ServerSocketThread();
  serverSocketThread.start();
 }

 @Override
 protected void onDestroy() {
  super.onDestroy();
  
  if (serverSocket != null) {
   try {
    serverSocket.close();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
 }

 private String getIpAddress() {
  String ip = "";
  try {
   Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
     .getNetworkInterfaces();
   while (enumNetworkInterfaces.hasMoreElements()) {
    NetworkInterface networkInterface = enumNetworkInterfaces
      .nextElement();
    Enumeration<InetAddress> enumInetAddress = networkInterface
      .getInetAddresses();
    while (enumInetAddress.hasMoreElements()) {
     InetAddress inetAddress = enumInetAddress.nextElement();

     if (inetAddress.isSiteLocalAddress()) {
      ip += "SiteLocalAddress: "
        + inetAddress.getHostAddress() + "\n";
     }

    }

   }

  } catch (SocketException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
   ip += "Something Wrong! " + e.toString() + "\n";
  }

  return ip;
 }
 
 public class ServerSocketThread extends Thread {

  @Override
  public void run() {
   Socket socket = null;
   
   try {
    serverSocket = new ServerSocket(SocketServerPORT);
    BtserverActivity.this.runOnUiThread(new Runnable() {


     public void run() {
      infoPort.setText("I'm waiting here: " 
       + serverSocket.getLocalPort());
     }});
    
    while (true) {
     socket = serverSocket.accept();
     FileTxThread fileTxThread = new FileTxThread(socket);
     fileTxThread.start();
    }
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } finally {
    if (socket != null) {
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
 
 public class FileTxThread extends Thread {
  Socket socket;
  
  FileTxThread(Socket socket){
   this.socket= socket;
  }

  @Override
  public void run() {
   try
   {
   FileOutputStream fout;
	fout = openFileOutput("test.txt",0);
	OutputStreamWriter osw = new OutputStreamWriter(fout);
	osw.write("This is the data");
	osw.flush();
	osw.close();
	fout.close();
	/*File file = new File(Environment.getExternalStorageDirectory(),"test.txt");
   byte[] bytes = new byte[(int) file.length()];
   BufferedInputStream bis;
   
    bis = new BufferedInputStream(new FileInputStream(file));
    bis.read(bytes, 0, bytes.length);
    */
	FileInputStream fin;
	fin = openFileInput("test.txt");
	InputStreamReader isw = new InputStreamReader(fin);
	char []b = new char[fin.available()];
	int n = isw.read(b,0,fin.available());
	String str = new String(b,0,n);
	byte bytes[] = str.getBytes();
	isw.close();
	fin.close();
	
    OutputStream os = socket.getOutputStream();
    os.write(bytes, 0, bytes.length);
    os.flush();
    socket.close();
    
    final String sentMsg = "File sent to: " + socket.getInetAddress();
    BtserverActivity.this.runOnUiThread(new Runnable() {

     public void run() {
      Toast.makeText(BtserverActivity.this, 
        sentMsg, 
        Toast.LENGTH_LONG).show();
     }});
    
   } catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } finally {
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