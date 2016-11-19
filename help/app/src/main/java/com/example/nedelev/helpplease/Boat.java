package com.example.nedelev.helpplease;


import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hamish on 18/11/2016.
 */

public class Boat {

    public static class InvalidKeyValuePairsException extends Exception {

    }

    public enum Size {
        SMALL(0), MEDIUM(1), LARGE(2);

        final int rawValue;

        Size(final int rawValue) {
            this.rawValue = rawValue;
        }

        public static Size fromInteger(int i) {
            switch (i) {
                case 0:
                    return SMALL;
                case 1:
                    return MEDIUM;
                case 2:
                    return LARGE;
                default:
                    return null;
            }
        }
    }

    public final Integer id;
    public final Size size;
    public final Integer maxPeople;

    public Bitmap image;
    public Float maxSpeed;
    public Location moorLocation;

    public Boat(final Integer id, final Size size, final Integer maxPeople) {
        this.id = id;
        this.size = size;
        this.maxPeople = maxPeople;
    }

    public Boat(final Map<String, ?> keyValues) throws InvalidKeyValuePairsException {

        try { // this is horrible code. open to suggestions.

            size = Size.fromInteger((Integer) keyValues.get("size"));
            maxPeople = (Integer) keyValues.get("maxPeople");

            if (size == null || maxPeople == null) {
                throw new InvalidKeyValuePairsException();
            }

            id = (Integer) keyValues.get("id");
            maxSpeed = (Float) keyValues.get("maxSpeed");

            final Double latitude = (Double)keyValues.get("location.latitude");
            final Double longitude = (Double)keyValues.get("location.longitude");

            if (latitude != null && longitude != null) {
                moorLocation = new Location("");
                moorLocation.setLatitude(latitude);
                moorLocation.setLongitude(longitude);
            }

            final String imagePath = (String) keyValues.get("imagePath");

            if (imagePath != null) {

                System.out.println(imagePath);

                try {
                    final File f = new File(imagePath, _imageFileName());
                    image = BitmapFactory.decodeStream(new FileInputStream(f));
                } catch (FileNotFoundException e) {
                    throw new InvalidKeyValuePairsException();
                }
            }

            } catch(ClassCastException e) {
                throw new InvalidKeyValuePairsException();
            }
    }

    private String _imageFileName() {
        return "boat" + String.valueOf(id) + ".png";
    }

    public void writeToEditor(final SharedPreferences.Editor editor) {

        editor.putInt("size", size.rawValue);
        editor.putInt("maxPeople", maxPeople);
        editor.putInt("id", id);

        if (image != null) {

            final File directory = new File(Environment.getExternalStorageDirectory() + "/Android/data/");

            final File path = new File(directory, _imageFileName());

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(path);
                image.compress(Bitmap.CompressFormat.PNG, 100, fos);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            editor.putString("imagePath", directory.getAbsolutePath());
        }

        if (maxSpeed != null) editor.putFloat("maxSpeed", maxSpeed);


        if (moorLocation != null) {
            editor.putFloat("location.latitude", Double.valueOf(moorLocation.getLatitude()).floatValue());
            editor.putFloat("location.longitude", Double.valueOf(moorLocation.getLatitude()).floatValue());
        }
    }
}