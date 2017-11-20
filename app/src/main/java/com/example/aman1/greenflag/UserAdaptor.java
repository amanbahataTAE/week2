package com.example.aman1.greenflag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aman1.greenflag.realm.RealmUser;

import java.util.ArrayList;

/**
 * Created by aman1 on 19/11/2017.
 */

public class UserAdaptor extends RecyclerView.Adapter<UserAdaptor.MyViewHolder> {

    private ArrayList<RealmUser> realmUserArrayList;
    private int row_user;
    private Context applicationContext;

    public UserAdaptor(ArrayList<RealmUser> realmUserArrayList, int row_user, Context applicationContext) {
        this.realmUserArrayList = realmUserArrayList;
        this.row_user = row_user;
        this.applicationContext = applicationContext;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.applicationContext).inflate(row_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.userName.setText(realmUserArrayList.get(position).getUserName());
        holder.userEmail.setText(realmUserArrayList.get(position).getUserEmail());
        holder.userAge.setText(realmUserArrayList.get(position).getUserAge());
        holder.userGender.setText(realmUserArrayList.get(position).getUserGender());
        holder.userPhoto.setImageBitmap(realmUserArrayList.get(position).getUserPhoto());
    }

    @Override
    public int getItemCount() {
        return realmUserArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView userName, userEmail, userAge, userGender;
        ImageView userPhoto;

        public MyViewHolder(View itemView) {
            super(itemView);

            userName = (TextView) itemView.findViewById(R.id.userName);
            userEmail = (TextView) itemView.findViewById(R.id.userEmail);
            userAge = (TextView) itemView.findViewById(R.id.userAge);
            userGender = (TextView) itemView.findViewById(R.id.userGender);
            userPhoto = (ImageView) itemView.findViewById(R.id.userPhotoListing);

        }
    }
}
