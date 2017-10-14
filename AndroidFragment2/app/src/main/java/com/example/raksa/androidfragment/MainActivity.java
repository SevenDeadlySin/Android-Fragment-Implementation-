package com.example.raksa.androidfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

    //global Keys for the bundle....
    public static final String FIRST_NAME = "FIRSTNAME";
    public static final String LAST_NAME = "LASTNAME";

    Button buttonSend;
    EditText editTextFirstName;
    EditText editTextLastName;

    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get Data From View and put it to Fragment through bundle
        buttonSend = (Button) findViewById(R.id.button);
        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);







        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //init the Fragment with Bundle...
                MainFragment mainFragment = new MainFragment();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();

                Fragment existFragment = fm.findFragmentById(R.id.container);
                if (existFragment==null){

                    //init Bundle with Input Data From Activity to Fragment..

                    Bundle nameBundle = new Bundle();
                    nameBundle.putString(FIRST_NAME,editTextFirstName.getText().toString());
                    nameBundle.putString(LAST_NAME,editTextLastName.getText().toString());

                    mainFragment.setArguments(nameBundle);

                    fragmentTransaction.add(R.id.container,mainFragment);
                    fragmentTransaction.commit();
                }
                else {

                    //init another one
                    Bundle nameBundle = new Bundle();
                    nameBundle.putString(FIRST_NAME,editTextFirstName.getText().toString());
                    nameBundle.putString(LAST_NAME,editTextLastName.getText().toString());
                    mainFragment.setArguments(nameBundle);

                    fragmentTransaction.replace(R.id.container,mainFragment).commit();

                }

            }
        });

    }


    @Override
    public void onFragmentInteraction(Uri uri) {}
}
