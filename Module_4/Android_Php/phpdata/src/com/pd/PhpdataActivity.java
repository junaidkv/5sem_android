package com.pd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PhpdataActivity extends Activity {
	EditText e1;
	EditText e2;
	TextView tv;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        tv = (TextView)findViewById(R.id.tv);
    }
    public void onGetData(View v)
    {
    	if(e1.getText().toString() == "" || e1.getText().length() == 0)
    		return;
    	else
    	{
    	class CData  extends AsyncTask<String, String, String>
    	{

			@Override
			protected String doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				try{
		           
					String link = "http://172.16.4.107/mobdata/test.php?eno=" + e1.getText().toString();
					
		            URL url = new URL(link);
		            HttpClient client = new DefaultHttpClient();
		            HttpGet request = new HttpGet();
		            request.setURI(new URI(link));
		            HttpResponse response = client.execute(request);
		            
		            BufferedReader in = new BufferedReader(new 
		               InputStreamReader(response.getEntity().getContent()));

		            StringBuffer sb = new StringBuffer("");
		            String line="";

		            while ((line = in.readLine()) != null) {
		               sb.append(line);
		               break;
		            }
		            in.close();
		           
					return sb.toString(); 	
		            
		         } catch(Exception e){
		        	 Toast.makeText(getApplicationContext(),"error" + e.getMessage(),2).show();
		            return new String("Exception: " + e.getMessage());
		         }
			}
			protected void onPreExecute()
			{
				super.onPreExecute();
			}
			protected void onPostExecute(String result)
			{
				try
				{
                        JSONObject jobj = new JSONObject(result);
                        e1.setText(jobj.getString("eno"));
                        e2.setText(jobj.getString("ename"));
				}
				catch(Exception ee)
				{
					 Toast.makeText(getApplicationContext(),"error2" + ee.getMessage(),2).show();
				}
			}
    	}
    	CData obj = new CData();
    	obj.execute();
    	}
    }
    public void onShowAll(View v)
    {
    	class CData  extends AsyncTask<String, String, String>
    	{

			@Override
			protected String doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				try{
		           
					String link = "http://172.16.4.107/mobdata/showall.php";
					
		            URL url = new URL(link);
		            HttpClient client = new DefaultHttpClient();
		            HttpGet request = new HttpGet();
		            request.setURI(new URI(link));
		            HttpResponse response = client.execute(request);
		            
		            BufferedReader in = new BufferedReader(new 
		               InputStreamReader(response.getEntity().getContent()));

		            StringBuffer sb = new StringBuffer("");
		            String line="";

		            while ((line = in.readLine()) != null) {
		               sb.append(line);
		               break;
		            }
		            in.close();
		           
					return sb.toString(); 	
		            
		         } catch(Exception e){
		        	 Toast.makeText(getApplicationContext(),"error" + e.getMessage(),2).show();
		            return new String("Exception: " + e.getMessage());
		         }
			}
			protected void onPreExecute()
			{
				super.onPreExecute();
			}
			protected void onPostExecute(String result)
			{
				String str = "";
				try
				{
				JSONArray jsonArray = new JSONArray(result);

                 if (jsonArray!=null) {
                	 int i = 0;
                    while (i < jsonArray.length()) {
                        JSONObject jobj = jsonArray.getJSONObject(i);
                        str = str + jobj.getString("eno");
                        str = str + "   ";
                        str = str + jobj.getString("ename");
                        str = str + "\n";
                        i++;
                    }
                    tv.setText(str);
                 }
				}
				catch(Exception ee)
				{
					 Toast.makeText(getApplicationContext(),"error2" + ee.getMessage(),2).show();
				}
			}
    	}
    	CData obj = new CData();
    	obj.execute();
    }
}