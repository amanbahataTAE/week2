package com.example.aman1.greenflag;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CreateAccountActivity extends Fragment {

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

    private OnOptionSelected optionSelected;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_create_account, container, false);
        initialize(view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * Injects test login credentials for ease of access
         */
        mEmail.setText("test@gmail.com");
        mPassword.setText("123456789");
        mConfirmPassword.setText("123456789");



        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This space intentionally left blank
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
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This space intentionally left blank
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
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This space intentionally left blank
            }

            @Override
            public void afterTextChanged(Editable s) {
                mConfirmPasswordThick.setVisibility(View.GONE);
                mConfirmPasswordError.setVisibility(View.GONE);

                if ((mConfirmPassword.getText().toString()).equals(mPassword.getText().toString())){
                    mConfirmPasswordThick.setVisibility(View.VISIBLE);
                   // mCreateAccount.setVisibility(View.VISIBLE);

                }else{
                    mConfirmPasswordError.setVisibility(View.VISIBLE);
                   // mCreateAccount.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("EMAIL", mEmail.getText().toString());
        outState.putString("PASSWORD", mPassword.getText().toString());

    }



    public void initialize(View view) {
        mBackButton = (ImageButton) view.findViewById(R.id.backButton);
        mCreateAccount = (Button) view.findViewById(R.id.create_an_account_button);
        mEmail = (EditText) view.findViewById(R.id.emailInput);
        mEmailThick = (ImageView) view.findViewById(R.id.emailThick);
        mEmailError = (ImageView) view.findViewById(R.id.emailError);
        mPassword = (EditText) view.findViewById(R.id.passwordInput);
        mPasswordError = (ImageView) view.findViewById(R.id.passwordError);
        mPasswordThick = (ImageView) view.findViewById(R.id.passwordThick);
        mConfirmPassword = (EditText) view.findViewById(R.id.repeat_passwordInput);
        mConfirmPasswordThick = (ImageView) view.findViewById(R.id.repeatPasswordThick);
        mConfirmPasswordError = (ImageView) view.findViewById(R.id.confirmPasswordError);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        optionSelected = (OnOptionSelected) getActivity();
    }
}
