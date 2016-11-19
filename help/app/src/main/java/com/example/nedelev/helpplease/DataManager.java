package com.example.hamish.rnlicodeforgood;

import android.content.SharedPreferences;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Hamish on 19/11/2016.
 */

public class DataManager {

    public static final String BOATS = "boats";

    public void saveBoats(final ArrayList<Boat> boats, final SharedPreferences.Editor editor) {

        try {
            editor.putString(BOATS, ObjectSerializer.serialize(boats));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.commit();
    }

    public ArrayList<Boat> loadBoats(final SharedPreferences preferences) {
        try {
            return (ArrayList<Boat>) ObjectSerializer.deserialize(preferences.getString(BOATS, ObjectSerializer.serialize(new ArrayList<Boat>())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
