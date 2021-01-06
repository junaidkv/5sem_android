package com.pemail.cmail;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class And_EmailActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onCompose(View v)
    {
    	 sendEmail();
    }
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        
        try {
           startActivity(Intent.createChooser(emailIntent, "Send mail..."));
           finish();
           Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
           Toast.makeText(And_EmailActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
     }
}