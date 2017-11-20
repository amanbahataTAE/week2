package com.example.aman1.greenflag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.aman1.greenflag.realm.RealmController;
import com.example.aman1.greenflag.realm.RealmUser;

import java.util.ArrayList;

import io.realm.Realm;

public class CreateAccountActivity extends AppCompatActivity {

    private ImageButton mBackButton;
    private Button mCreateAccount;
    private EditText mEmail;
    private ImageView mEmailError;
    private ImageView mEmailThick;
    private EditText mPassword;
    private ImageView mPasswordError;
    private ImageView mPasswordThick;
    private EditText mConfirmPassword;
    private ImageView mConfirmPasswordThick;
    private ImageView mConfirmPasswordError;

    private static int PASSWORD_LENGHT = 8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        initialize();

        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mEmailThick.setVisibility(View.GONE);
                mEmailError.setVisibility(View.GONE);
                if(isValidEmail(mEmail.getText().toString())){
                    mEmailThick.setVisibility(View.VISIBLE);
                }else{
                    mEmailError.setVisibility(View.VISIBLE);
                }
            }
        });

        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPasswordThick.setVisibility(View.GONE);
                mPasswordError.setVisibility(View.GONE);
                if(isValidPassword(mPassword.getText().toString())){
                    mPasswordThick.setVisibility(View.VISIBLE);
                }else{
                    mPasswordError.setVisibility(View.VISIBLE);
                }
            }
        });

        mConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mConfirmPasswordThick.setVisibility(View.GONE);
                mConfirmPasswordError.setVisibility(View.GONE);

                if ((mConfirmPassword.getText().toString()).equals(mPassword.getText().toString())){
                    mConfirmPasswordThick.setVisibility(View.VISIBLE);
                    mCreateAccount.setVisibility(View.VISIBLE);
                }else{
                    mConfirmPasswordError.setVisibility(View.VISIBLE);
                    mCreateAccount.setVisibility(View.GONE);
                }
            }
        });


        /**
         * Injects test login credentials for ease of access
         */
        mEmail.setText("test@gmail.com");
        mPassword.setText("123456789");
        mConfirmPassword.setText("123456789");

    }






    public void clickButtonEvents(View view){

        if(view.getId() == R.id.backButton ){
            Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.create_an_account_button){
            Intent intent = new Intent(CreateAccountActivity.this, PersonalInformationActivity.class);
            intent.putExtra("USEREMAIL", mEmail.getText().toString().trim());
            intent.putExtra("USERPASSWORD", mPassword.getText().toString().trim());
            startActivity(intent);
        }

    }

    public void initialize(){
        mBackButton = (ImageButton) findViewById(R.id.backButton);
        mCreateAccount = (Button) findViewById(R.id.create_an_account_button);
        mEmail = (EditText) findViewById(R.id.emailInput);
        mEmailThick = (ImageView) findViewById(R.id.emailThick);
        mEmailError = (ImageView) findViewById(R.id.emailError);
        mPassword = (EditText) findViewById(R.id.passwordInput);
        mPasswordError = (ImageView) findViewById(R.id.passwordError) ;
        mPasswordThick = (ImageView) findViewById(R.id.passwordThick) ;
        mConfirmPassword = (EditText) findViewById(R.id.repeat_passwordInput) ;
        mConfirmPasswordThick = (ImageView) findViewById(R.id.repeatPasswordThick);
        mConfirmPasswordError = (ImageView) findViewById(R.id.confirmPasswordError);
    }

    public boolean isValidEmail(String mEmail){
        if (mEmail == null) {
            return false;
        } else {
            //android Regex to check the email address
            return android.util.Patterns.EMAIL_ADDRESS.matcher(mEmail).matches();
        }
    }


    /**
     * Checks the length of the user entered password
     * @param mPassword
     * @return
     */

    private boolean isValidPassword(String mPassword) {
        return (mPassword.length() > PASSWORD_LENGHT);
    }
}
