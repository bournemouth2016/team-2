package com.example.nedelev.helpplease;

import com.parse.Parse;

/**
 * Created by Hamish on 19/11/2016.
 */

public class Application extends android.app.Application {

    @Override public void onCreate() {
        super.onCreate();

        //Connect to the Parse server
        Parse.initialize(new Parse.Configuration.Builder(this.getApplicationContext())
                .applicationId("myAppId")
                .server("http://178.62.115.151:1337/parse")
                .build());
    }

}
