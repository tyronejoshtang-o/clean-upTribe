package com.example.clean_uptribe;

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

public class LoginActivity extends AppCompatActivity {

    // Declare EditText fields for username and password
    EditText username, password;

    //Declare Button for login
    Button btnlogin;

    // Database helper to interact with the SQLite database
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //linking to their XML IDs
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);

        //linking to their XML IDs
        btnlogin = (Button) findViewById(R.id.btnsignin1);

        // Initialize the DBHelper instance to interact with the database
        DB = new DBHelper(this);

        // Set an OnClickListener for the login button
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Retrieve input values for username and password
                String user = username.getText().toString();
                String pass = password.getText().toString();

                // Check if any of the fields are empty
                if (user.equals("") || pass.equals("")) {

                    // Show a toast message if any field is empty
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {

                    // Check if the entered username and password match any record in the database
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {

                        // If credentials are invalid, show an error message
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                    } else {
                        // If credentials are valid, show success message and navigate to HomeActivity
                        Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);                    }
                }
            }
        });
    }
}