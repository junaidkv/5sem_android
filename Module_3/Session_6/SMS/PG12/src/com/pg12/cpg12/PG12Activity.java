package com.pg12.cpg12;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;

public class PG12Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String phoneNumber = "9847186884";
        SmsManager sms = SmsManager.getDefault();
        /* Reading the text from the textbox */
        String msg = "Testing";//(EditText)findViewById(R.id.editText1)).getText().toString();
        /* Sending the sms */
        sms.sendTextMessage(phoneNumber, null, msg, null, null);

    }
}