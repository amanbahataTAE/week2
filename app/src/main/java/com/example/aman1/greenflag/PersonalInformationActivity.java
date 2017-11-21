package com.example.aman1.greenflag;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.codetroopers.betterpickers.datepicker.DatePickerDialogFragment;
import com.example.aman1.greenflag.realm.RealmController;
import com.example.aman1.greenflag.realm.RealmLogin;
import com.example.aman1.greenflag.realm.RealmUser;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import io.realm.Realm;

public class PersonalInformationActivity extends Fragment implements DatePickerDialogFragment.DatePickerDialogHandler  {


    private String mUserEmail;
    private String mPassword;
    private EditText userName;
    private EditText userAge;
    private TextView userEmail;
    private TextView userPassword;
    private Button changePhoto;
    private Button chooseBirthDate;
    private Button save;
    private TextView birthDayDisplay;
    private ImageView userPhoto;

    private RadioGroup genderRadioGroup;
    private RadioButton genderRadioButton;
    private EditText userAddress;

    private byte[] uPhoto;


    private RealmController realmController;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    OnOptionSelected optionSelected;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_personal_information, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        mUserEmail = getIntent().getStringExtra("USEREMAIL");
//        mPassword = getIntent().getStringExtra("USERPASSWORD");

        setRetainInstance(true);

        initialize(view);


        // Sets up the birth day date picker

//        birthDayDisplay.setText(R.string.no_value);
//        chooseBirthDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatePickerBuilder dpb = new DatePickerBuilder()
//                        .setFragmentManager(getSupportFragmentManager())
//                        .setStyleResId(R.style.BetterPickersDialogFragment);
//                dpb.show();
//            }
//        });

        //initializeRealm();





        // Listens to the take photo button for a click

//        changePhoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dispatchTakePictureIntent();
//            }
//        });
    }




    public void onSaveButtonEvent(View view){
        if (view.getId() == R.id.save_button){

            int selectedId = genderRadioGroup.getCheckedRadioButtonId();
            genderRadioButton = (RadioButton) view.findViewById(selectedId);

            if (userName != null && userAge != null && birthDayDisplay != null && genderRadioButton != null){

                RealmUser realmUser = new RealmUser(userName.getText().toString().trim(),
                        mUserEmail, mPassword, userAge.getText().toString().trim(), birthDayDisplay.getText().toString(),
                        genderRadioButton.getText().toString(), userAddress.getText().toString().trim(), uPhoto);

                RealmLogin realmUserLogin = new RealmLogin(userName.getText().toString(), userPassword.getText().toString());


                realmController.saveUser(realmUser);
                realmController.saveUserLogin(realmUserLogin);


//                Intent intent = new Intent(PersonalInformationActivity.this, UsersListActivity.class);
//                startActivity(intent);
            }

        }
    }


    // Starts the camera intent to take photo

//    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//        }
//    }


    // Displayes the photo taken from the camera in the ImageView

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            Bitmap bmp = (Bitmap) extras.get("data");
//            userPhoto.setImageBitmap(imageBitmap);
//
//
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            uPhoto = stream.toByteArray();
//        }
//    }


    // Initializes instance variables

    private void initialize(View view){
        userName = (EditText) view.findViewById(R.id.name);
        userAge = (EditText) view.findViewById(R.id.age);
        userEmail = (TextView) view.findViewById(R.id.userName);
        userPassword = (TextView) view.findViewById(R.id.password);
        userEmail.setText(mUserEmail);
        userPassword.setText(mPassword);
        changePhoto = (Button) view.findViewById(R.id.changePhoto);
        chooseBirthDate = (Button) view.findViewById(R.id.chooseBirthDate);
        save = (Button) view.findViewById(R.id.save_button);
        birthDayDisplay = (TextView) view.findViewById(R.id.birthDateDisplay);
        genderRadioGroup = (RadioGroup) view.findViewById(R.id.gender);
        userAddress = (EditText) view.findViewById(R.id.userAddress);
        userPhoto = (ImageView) view.findViewById(R.id.userPhoto);

    }


    // Displays the calender date selection from betterpickers

    @Override
    public void onDialogDateSet(int reference, int year, int monthOfYear, int dayOfMonth) {
        birthDayDisplay.setText(getString(R.string.date_picker_result_value, year, monthOfYear, dayOfMonth));
    }




//    public void initializeRealm(){
//        Realm.init(this);
//        realmController = new RealmController(Realm.getDefaultInstance());
//    }

    public void onRadioButtonClicked(View view) {
        int radioButtonId = genderRadioGroup.getCheckedRadioButtonId();
        genderRadioButton = (RadioButton) view.findViewById(radioButtonId);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        optionSelected = (OnOptionSelected) getActivity();
    }
}
