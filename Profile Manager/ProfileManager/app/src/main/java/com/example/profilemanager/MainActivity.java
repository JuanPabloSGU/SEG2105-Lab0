package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddress);

        // Create a URI from a string. Use the result to create an intent
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        // Create an Intent from gmmIntentUri. SEt the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        helperName = findViewById(R.id.helperName);
        helperAddress = findViewById(R.id.helperAddress);
        googleMaps = findViewById(R.id.googleMaps);
        teamName = findViewById(R.id.teamName);
        teamAddress = findViewById(R.id.teamAddress);

        googleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                OnOpenInGoogleMaps(v);
            }
        });

    }




    Button googleMaps;
    TextView title, helperName, helperAddress;
    EditText teamName, teamAddress;
}