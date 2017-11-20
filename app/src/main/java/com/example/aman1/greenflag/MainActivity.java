package com.example.aman1.greenflag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aman1.greenflag.realm.RealmController;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private Button mSignIn, mCreateAccount;
    private RealmController realmController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initializer();

    }

    public void initializer(){
        this.mSignIn = (Button) findViewById(R.id.sign_in_button);
        this.mCreateAccount = (Button) findViewById(R.id.create_an_account_button);
    }

    public void clickButtonEvents(View view){
        if (view.getId() == R.id.sign_in_button){
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
        }else if (view.getId() == R.id.create_an_account_button) {
            Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
            startActivity(intent);
        }
    }


}
