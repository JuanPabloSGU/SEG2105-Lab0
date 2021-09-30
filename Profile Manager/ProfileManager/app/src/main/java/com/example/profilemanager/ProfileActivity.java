package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        flagid_00 = findViewById(R.id.flagid00);
        flagid_01 = findViewById(R.id.flagid01);
        flagid_02 = findViewById(R.id.flagid02);
        flagid_03 = findViewById(R.id.flagid03);
        flagid_04 = findViewById(R.id.flagid04);
        flagid_05 = findViewById(R.id.flagid05);
        flagid_06 = findViewById(R.id.flagid06);
        flagid_07 = findViewById(R.id.flagid07);
        flagid_08 = findViewById(R.id.flagid08);
        description = findViewById(R.id.description);


    }

    ImageView flagid_00, flagid_01, flagid_02, flagid_03, flagid_04, flagid_05, flagid_06, flagid_07, flagid_08;
    TextView description;
}