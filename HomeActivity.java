package com.example.clean_uptribe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    // Declare buttons for donate and join actions
    Button donate, join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //linking them to XML IDs
        donate = (Button) findViewById(R.id.btndonate);
        join = (Button) findViewById(R.id.btnjoin);

        // Set an OnClickListener for the Donate button
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the donate button is clicked, navigate to DonateActivity
                Intent intent = new Intent(getApplicationContext(), DonateActivity.class);
                startActivity(intent); // Start DonateActivity

            }
        });

        // Set an OnClickListener for the Join button
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the join button is clicked, navigate to JoinActivity
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent); // Start JoinActivity


            }
        });
    }
}