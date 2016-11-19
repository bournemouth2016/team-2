package com.example.nedelev.helpplease;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import static android.location.LocationManager.GPS_PROVIDER;
import static android.location.LocationManager.NETWORK_PROVIDER;

/**
 * Created by jonatan on 18/11/2016.
 */

public class LocationFinder extends Service implements LocationListener {


    private final Context mContext;

    // flag for GPS status
    boolean isGPSEnabled = false;
    // flag for network status
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;
    Location location; // location
    double latitude; // latitude
    double longitude; // longitude

    // The minimum distance to change Updates in meters
    private final long MIN_DISTANCE_CHANGE_FOR_UPDATES; // 10 meters

    // The minimum time between updates in milliseconds
    private final long MIN_TIME_BW_UPDATES; // 1 minute

    // Declaring a Location Manager
    protected LocationManager locationManager;

    public LocationFinder(Context context, final long minTimeBwUpdates,final long minDistChangeForUpdates) {
        this.mContext = context;
        MIN_DISTANCE_CHANGE_FOR_UPDATES = minDistChangeForUpdates;
        MIN_TIME_BW_UPDATES = minTimeBwUpdates;
        getLocation();
    }

    public Location getLocation() {
        locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnabled = locationManager.isProviderEnabled(NETWORK_PROVIDER);
        if (isNetworkEnabled) {
            try {
                locationManager.requestLocationUpdates(NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                Log.d("Network", "Network");
                if (locationManager != null) {
                    location = locationManager.getLastKnownLocation(NETWORK_PROVIDER);
                }


            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        if (isGPSEnabled) {
            try {
                if (location == null) {
                    locationManager.requestLocationUpdates(GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("GPS Enabled", "GPS Enabled");
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(GPS_PROVIDER);
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        else {
            promptUserToEnableLocationServices();
        }
        return location;

    }


       public double getLatitude(){
            if (location != null) {
                latitude = location.getLatitude();
            }
            return latitude;
        }
        public double getLongitude(){
            if (location != null) {
                latitude = location.getLongitude();
            }
            return longitude;
        }
    public void stopUsingGPS() {
        if(locationManager != null) {
            try {
                locationManager.removeUpdates(LocationFinder.this);
            }
            catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    public void onLocationChanged(Location location) {
    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    @Override
    public void onProviderEnabled(String provider) {
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    public void promptUserToEnableLocationServices(){
        System.exit(0);
    };


}
