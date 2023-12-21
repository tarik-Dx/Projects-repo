package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }
    @Override
    public void onCreate(){
        Toast.makeText(this,"Service.onCreate()",Toast.LENGTH_SHORT).show();
    }


    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"Service.onBind()",Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Service.onDestroy()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent,int flag,int startId){
        super.onStartCommand(intent,flag,startId);
        Toast.makeText(this,"Service.onStartCommand()",Toast.LENGTH_SHORT).show();

        return START_NOT_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent){
        Toast.makeText(this,"Service.onUnbind()",Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }
}