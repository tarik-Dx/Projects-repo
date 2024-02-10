package com.example.workmanager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.transform.Result;

public class FileReadWork  extends Worker {
    private static final String TAG = "FileReadWork";
    private Context context;
    private WorkerParameters workerParameters;
    public FileReadWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
        this.workerParameters = workerParams;
    }
    @NonNull
    @Override
    public Result doWork() {
        InputStream stream = null;
        try {
            stream = context.getAssets().open("assets/file.txt");
            InputStreamReader reader = new InputStreamReader(stream);
            StringBuilder text = new StringBuilder();
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
                Log.d(TAG, line.toString());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, e.getMessage());
            return Result.failure();
        }
        return Result.success();
    }
    /*private static final String TAG = "FileReadWork";
    private Context context;
    private WorkerParameters workerParameters;
    public FileReadWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
        this.workerParameters = workerParams;
    }
    @NonNull
    @Override
    public Result doWork() {
        InputStream stream = null;
        try {
            stream = context.getAssets().open("assets/file.txt");
            InputStreamReader reader = new InputStreamReader(stream);
            StringBuilder text = new StringBuilder();
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
                Log.d(TAG, line.toString());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, e.getMessage());
            return Result.failure();
        }
        return Result.success();
    }*/
}
