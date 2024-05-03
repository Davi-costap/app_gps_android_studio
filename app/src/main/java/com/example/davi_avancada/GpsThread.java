package com.example.davi_avancada;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
public class GpsThread extends Thread {
    private final Context context;
    private final LocationManager locationManager;
    private final LocationListener locationListener;
    private boolean shouldStop = false;

    public GpsThread(Context context, LocationManager locationManager, LocationListener locationListener) {
        this.context = context;
        this.locationManager = locationManager;
        this.locationListener = locationListener;
    }

    @Override
    public void run() {
        Looper.prepare();

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        while (!shouldStop) {
            Looper.loop(); // Este laço pode bloquear a thread caso não seja quebrado
        }
    }

    public void stopThread() {
        shouldStop = true;
        locationManager.removeUpdates(locationListener);
        // A thread deve ser interrompida apropriadamente

    }
}
