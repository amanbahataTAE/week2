package com.example.aman1.greenflag.realm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import io.realm.RealmObject;

/**
 * Created by aman1 on 19/11/2017.
 */

public class RealmUser extends RealmObject{


    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAge;
    private String userBirthDate;
    private String userGender;
    private String userAddress;



    private byte[] userPhoto;


    // a variable to store the user image


    public RealmUser() {
    }

    public RealmUser(String userName, String userEmail,
                     String userPassword, String userAge, String userBirthDate,
                     String userGender, String userAddress, byte[] userPhoto) {

        this.userName = userName;
        this.userEmail = userEmail;
       this.userPassword = userPassword;
        this.userAge = userAge;
        this.userBirthDate = userBirthDate;
        this.userGender = userGender;
        this.userAddress = userAddress;
       this.userPhoto = userPhoto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Bitmap getUserPhoto() {
        Bitmap actualPhoto = convertImage(this.userPhoto);
        return actualPhoto;
    }

    public void setUserPhoto(byte[] userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Bitmap convertImage(byte[] array){
        Bitmap bitmap = BitmapFactory.decodeByteArray(array, 0, array.length);
        return bitmap;
    }
}
