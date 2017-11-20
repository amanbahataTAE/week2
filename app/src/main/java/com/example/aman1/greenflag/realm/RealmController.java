package com.example.aman1.greenflag.realm;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by aman1 on 19/11/2017.
 */

public class RealmController {

    Realm realm;


    public RealmController(Realm realm) {
        this.realm = realm;
    }


    /**
     * Stores the users information to the database
     * @param realmUser
     */
    public void saveUser(final RealmUser realmUser){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(realmUser);
            }
        });

    }

    /**
     * Stores the users information to the database
     * @param realmUserLogin
     */
    public void saveUserLogin(final RealmLogin realmUserLogin){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(realmUserLogin);
            }
        });

    }


    /**
     * Returns the users list from the database
     */

    public ArrayList<RealmUser> getUserList(){
        ArrayList<RealmUser> usersList = new ArrayList<>();

        RealmResults<RealmUser> realmUserResult = realm.where(RealmUser.class).findAll();

        for (RealmUser user : realmUserResult) {
            usersList.add(user);
        }
        return usersList;
    }


    /**
     * Returns the users login list from the database
     */

    public ArrayList<RealmLogin> getUserLoginList(){
        ArrayList<RealmLogin> usersList = new ArrayList<>();

        RealmResults<RealmLogin> realmUserResult = realm.where(RealmLogin.class).findAll();

        for (RealmLogin user : realmUserResult) {
            usersList.add(user);
        }
        return usersList;
    }
}
