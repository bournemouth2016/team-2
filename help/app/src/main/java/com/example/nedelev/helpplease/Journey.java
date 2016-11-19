package com.example.jonat.testproject;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by jonathan on 19/11/2016.
 */

public class Journey extends Service {

    private int numberOfPassengers;
    private final Boat boat;
    private LocationFinder currentLocationFinder;
    private ArrayList<Location> locationList;

    public Journey(final Boat boat,final int numberOfPassengers,final Context context){
        this.boat = boat;
        this.numberOfPassengers = numberOfPassengers;
        locationList = new ArrayList<Location>();
    }

    public void createLocationFinder(Context context, final long minTimeBwUpdates,final long minDistChangeForUpdates){

            currentLocationFinder = new LocationFinder(context, minTimeBwUpdates, minDistChangeForUpdates){
                @Override
                public void onLocationChanged(Location location) {
                    logLocation(location);
                }
            };
    }

    private void logLocation(final Location location) {
        locationList.add(location);
    }


    public ArrayList<Location> getLocationList(){
        return locationList;
    }

    public int getNumberOfPassengers(){
        return numberOfPassengers;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
