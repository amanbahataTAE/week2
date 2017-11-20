package com.example.aman1.greenflag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aman1.greenflag.realm.RealmController;
import com.example.aman1.greenflag.realm.RealmUser;

import java.util.ArrayList;

import io.realm.Realm;

public class UsersListActivity extends AppCompatActivity {

    private RealmController realmController;

    private ArrayList<RealmUser> realmUsersList;
    private RecyclerView recyclerView;


   // public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);



        realmController = new RealmController(Realm.getDefaultInstance());
        realmUsersList = realmController.getUserList();

        initializeRecyclerView();
    }


    public void initializeRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.rvUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new UserAdaptor(realmUsersList, R.layout.row_user, getApplicationContext()));
    }
}
