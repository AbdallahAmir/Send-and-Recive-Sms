package com.example.amir.smstext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buSend(View view) {
        SmsManager Smanager=SmsManager.getDefault();
        EditText Ptext=(EditText)findViewById(R.id.editText);
        EditText Stext=(EditText)findViewById(R.id.editText2);
        Smanager.sendTextMessage(Ptext.getText().toString(),null,Stext.getText().toString(),null,null);
        Stext.setText("done");

    }
}
