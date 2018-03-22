package com.example.kpraveen.teamapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class LocationService extends Service {

    Timer timer = new Timer();

    class ShowTimeTask extends TimerTask {
     @Override
        public void run() {
         Calendar c = Calendar.getInstance();
         SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
         String formattedDate = df.format(c.getTime());
         Log.d("TeamApp", "ShowTimeTask " + formattedDate);
         //Toast.makeText(LocationService.this, formattedDate, Toast.LENGTH_SHORT).show();
        }
    };


    public LocationService() {
        Log.d("TeamApp", "new LocationService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TeamApp-LocationService", "onBind");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TeamApp-LocationService", "onStartCommand");
        super.onStartCommand(intent, flags, startId);
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        Log.d("TeamApp-LocationService", "onCreate");
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
        timer.schedule(new ShowTimeTask(), 2000, 2000);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, R.string.location_service_stopped, Toast.LENGTH_SHORT).show();
    }

}
