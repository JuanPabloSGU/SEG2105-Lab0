package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    public void SetTeamIcon(View v){
        // Creating a return Intent to pass to the Main Activity
        Intent returnIntent = new Intent();

        // Figuring out which image was clicked
        ImageView selectedImage = (ImageView) v;

        // Adding details to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        // Finishing the activity and returning to the main screen
        finish();
    }

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