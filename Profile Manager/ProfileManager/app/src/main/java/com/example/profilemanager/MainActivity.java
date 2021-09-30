package com.example.profilemanager;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
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

    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == Activity.RESULT_OK){
                // There are no request codes
                Intent data = result.getData();

                ImageView avatarImage = (ImageView) findViewById(R.id.avatar);
                String drawableName = "flag_02";

                switch(data.getIntExtra("imageID",R.id.flagid00)){
                    case R.id.flagid00:
                        drawableName = "flag_00";
                        break;
                    case R.id.flagid01:
                        drawableName = "flag_01";
                        break;
                    case R.id.flagid02:
                        drawableName = "flag_02";
                        break;
                    case R.id.flagid03:
                        drawableName = "flag_03";
                        break;
                    case R.id.flagid04:
                        drawableName = "flag_04";
                        break;
                    case R.id.flagid05:
                        drawableName = "flag_05";
                        break;
                    case R.id.flagid06:
                        drawableName = "flag_06";
                        break;
                    case R.id.flagid07:
                        drawableName = "flag_07";
                        break;
                    case R.id.flagid08:
                        drawableName = "flag_08";
                        break;
                    default:
                        drawableName = "flag_09";
                        break;
                }
                int resID = getResources().getIdentifier(drawableName, "drawable",getPackageName());
                avatarImage.setImageResource(resID);
            }
        }

    });

    public void OnSetAvatarButton(View view){
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);
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
        avatar = findViewById(R.id.avatar);

        googleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                OnOpenInGoogleMaps(v);
            }
        });

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSetAvatarButton(v);
            }
        });

    }




    ImageView avatar;
    Button googleMaps;
    TextView title, helperName, helperAddress;
    EditText teamName, teamAddress;
}