package com.example.amir.smstext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

public class ReciveSms extends BroadcastReceiver{

    final SmsManager smsManager=SmsManager.getDefault();
    static int id=1;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=new Bundle();
        bundle=intent.getExtras();
        try {
            if (bundle!=null){
                final Object[] smscontent=(Object[])bundle.get("pdus");
                for (int i = 0; i <smscontent.length ; i++) {
                    SmsMessage message=SmsMessage.createFromPdu((byte[])smscontent[i]);
                    NewMessageNotification notification=new NewMessageNotification();
                    notification.notify(context,message.getDisplayOriginatingAddress(),message.getMessageBody(),id);
                    id++;
                }
            }

        }catch (Exception e){}


    }
}
