package com.example.aman1.greenflag.realm;

import io.realm.RealmObject;

/**
 * Created by aman1 on 20/11/2017.
 */

public class RealmLogin extends RealmObject {

    private String userName;
    private String password;

    public RealmLogin(){

    }

    public RealmLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
