package com.example.aman1.greenflag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity implements OnOptionSelected{

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null){
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_cont, new MainActivity())
                    .commit();
        }

    }

    @Override
    public void optionSelected() {
        // TODO: 21/11/2017  does nothing
    }

        public void clickButtonEvents(View view){

            Fragment mainActivity = new MainActivity();
      //      Fragment signInActivity = new SignInActivity();
            Fragment createAccountActivity = new CreateAccountActivity();
            Fragment personalInformationActivity = new PersonalInformationActivity();


        if (view.getId() == R.id.sign_in_button){
//            Intent intent = new Intent(BaseActivity.this, SignInActivity.class);
//            startActivity(intent);
//            fragmentManager.beginTransaction()
//                    .replace(R.id.fragment_cont, new SignInActivity())
//                    .commit();

            Toast.makeText(this, "SIgn in button pressed", Toast.LENGTH_LONG).show();

        }else if (view.getId() == R.id.create_an_account_button) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_cont, createAccountActivity)
                    .commit();

        }else if (view.getId() == R.id.backButton ){
            fragmentManager.beginTransaction()
//                    .replace(R.id.fragment_cont, new MainActivity())
                    .remove(mainActivity)
                    .commit();
        }else if (view.getId() == R.id.create_an_account){
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_cont, personalInformationActivity)
                    .commit();
        }
    }
}
