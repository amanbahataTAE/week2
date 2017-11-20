package com.example.aman1.greenflag;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by aman1 on 19/11/2017.
 */

public class MyApp extends Application{
    @Override
    public void onCreate(){
        super.onCreate();

        /**
         *
         */

        Realm.init(getApplicationContext()); // applicationContext


        // Builder pattern used
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
