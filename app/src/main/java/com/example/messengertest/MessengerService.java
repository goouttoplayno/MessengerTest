package com.example.messengertest;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

public class MessengerService extends Service {

    public static final int MSG_SAY_HELLO = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Toast.makeText(MessengerService.this, "hello", Toast.LENGTH_LONG).show();
                    Log.d("MessengerService", "MessengerService thread id is " + Thread.currentThread().getId());
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private Messenger messenger = new Messenger(handler);
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }
}
