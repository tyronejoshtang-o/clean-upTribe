package com.example.clean_uptribe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AcknowledgementActivity extends AppCompatActivity {

    // Declare buttons for navigating to different activities
    Button acknowledgebackButton, stayintouchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgement);

        //linking to their XML IDs
        acknowledgebackButton = (Button) findViewById(R.id.acknowledgebackbtn);
        stayintouchButton = (Button) findViewById(R.id.stayintouchbtn);

        // Set up an OnClickListener for the 'Back' button
        acknowledgebackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to navigate back to the HomeActivity
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent); // Start the HomeActivity
            }
        });

        // Set up an OnClickListener for the 'Stay in Touch' button
        stayintouchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create an Intent to navigate to the StayInTouchActivity
                Intent intent = new Intent(getApplicationContext(), StayInTouchActivity.class);
                startActivity(intent); // Start the StayInTouchActivity
            }
        });


    }
}