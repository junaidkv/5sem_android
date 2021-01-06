package com.pg10.cpg10;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PG10Activity extends Activity {
	/** Called when the activity is first created. */
	ImageView img;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		EditText eu = (EditText)findViewById(R.id.eurl);
		eu.setText("http://maps.google.com/maps/api/geocode/json?latlng=9.986940557300203,76.31206512451172&sensor=false");		
	}
	public void onShow(View v)
	{
		String url;
		EditText eu = (EditText)findViewById(R.id.eurl);
		url = eu.getText().toString();
		String str = DownloadText(url);
		int start = str.indexOf("formatted");
		int end = str.indexOf("geometry");
		char[] name =  new char[200];
		
		str.getChars(start+10, end-8, name, 0);
		EditText etx = (EditText)findViewById(R.id.editText1);
		etx.setText((String.valueOf(name).trim()).replace("address", "Address"));
	}
	/* User Defined Function */
	String DownloadText(String URL) {
		
		int BUFFER_SIZE = 2000;
		InputStream in = null;
		try {
			in = OpenHttpConnection(URL);
		} catch (IOException e1) {
			Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();
			return "";
		}
		InputStreamReader isr = new InputStreamReader(in);  //A class for turning a byte stream into a character stream
		
		int charRead;
		String str = "";
		char[] inputBuffer = new char[BUFFER_SIZE];
		try {
			while ((charRead = isr.read(inputBuffer)) > 0) {
				// ---convert the chars to a String---
				String readString = String.copyValueOf(inputBuffer, 0, charRead);
				str += readString;
				inputBuffer = new char[BUFFER_SIZE];
			}
			in.close();
		} catch (IOException e) {
			Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
			return "";
		}
		return str;
	}

	/* User Defined Method */
	InputStream OpenHttpConnection(String urlString) throws IOException {

		InputStream in = null;
		int response = -1;

		URL url = new URL(urlString);
		URLConnection conn = url.openConnection(); // Opens a URL connection to
													// the resource

		if (!(conn instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection");

		try {
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			httpConn.setRequestMethod("GET"); // Sets the request command
			httpConn.connect(); // Opens connection
			response = httpConn.getResponseCode();
			if (response == HttpURLConnection.HTTP_OK) {
				in = httpConn.getInputStream(); // Returns an InputStream for
												// reading data from the
												// resource pointed by this
												// URLConnection
			}
		} catch (Exception ex) {
			throw new IOException("Error connecting");
		}
		return in;
	}


}