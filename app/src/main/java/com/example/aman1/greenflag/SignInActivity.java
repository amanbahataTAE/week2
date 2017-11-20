package com.example.aman1.greenflag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aman1.greenflag.realm.RealmController;
import com.example.aman1.greenflag.realm.RealmLogin;
import com.example.aman1.greenflag.realm.RealmUser;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;

import io.realm.Realm;

public class SignInActivity extends AppCompatActivity {

    RealmController realmController;
    private ArrayList<RealmLogin> realmUsersList;

    private EditText userEmail;
    private EditText userPassword;
    private Button signButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initialize();

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.login){

                    String email = userEmail.getText().toString();
                    String password = userPassword.getText().toString();

                    if (checkLogin(email, password)){
                        Toast.makeText(SignInActivity.this,"FETCHING USERS OF THE APP", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignInActivity.this, UsersListActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(SignInActivity.this, "INCORRECT USERNAME OR PASSWORD", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }




    public void initialize(){
        userEmail = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.password);
        signButton = (Button) findViewById(R.id.login);

    }

    public boolean checkLogin(String s1, String s2){
        boolean login = false;

        Realm.init(this);
        realmController = new RealmController(Realm.getDefaultInstance());
        realmUsersList = realmController.getUserLoginList();

        if (realmUsersList.size() > 0){

            for (RealmLogin singleLogin : realmUsersList) {
                Log.i("USERDETAILS", singleLogin.getUserName() + " " + singleLogin.getPassword());
                Log.i("SINGLEUSER", singleLogin.getUserName());
                Log.i("SINGLEUSERPASSWORD", singleLogin.getPassword());

                if (singleLogin.getUserName().equals(s1) && singleLogin.getPassword().equals(s2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
