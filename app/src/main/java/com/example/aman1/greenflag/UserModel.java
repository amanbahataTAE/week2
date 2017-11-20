package com.example.aman1.greenflag;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aman1 on 19/11/2017.
 */

public class UserModel implements Parcelable {


    String mUserName;

    protected UserModel(Parcel in) {
        mUserName = in.readString();
    }

    public UserModel(String mUserName) {
        this.mUserName = mUserName;
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
