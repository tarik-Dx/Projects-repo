package com.example.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private WorkManager workManager;
    private WorkRequest workRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workManager = WorkManager.getInstance(getApplicationContext());
        workRequest = new PeriodicWorkRequest.Builder(FileReadWork.class,15, TimeUnit.MINUTES).build();
    }
    public void  startWork(View v){
        workManager.enqueue(workRequest);
    }
    public  void stopWork(View v){
        workManager.cancelWorkById(workRequest.getId());
    }
}