package com.example.clean_uptribe;

// Import necessary classes for Android functionality
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StayInTouchActivity extends AppCompatActivity {

    // Declare EditText fields for user input (name and email)
    EditText sitnameedit, sitemailedit;
    //Declare Button for the subscription action
    Button subscribebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_in_touch);

        // linking to their XML IDs
        sitemailedit = (EditText) findViewById(R.id.sitnameedt);
        sitemailedit = (EditText) findViewById(R.id.sitnameedt);

        // linking to its XML ID
        subscribebutton = (Button) findViewById(R.id.subscribebtn);

        subscribebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Show a toast message to notify the user of successful subscription
                Toast.makeText(StayInTouchActivity.this, "Subscription successful! Thank you for staying in touch.", Toast.LENGTH_SHORT).show();

                // Create an Intent to navigate to the HomeActivity after subscription
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}