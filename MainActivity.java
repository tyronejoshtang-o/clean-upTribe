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

public class MainActivity extends AppCompatActivity {

    // Declare EditText fields for username, password, and confirm password
    EditText username, password, repassword;

    //Declare Button for the signup and sign in
    Button signup, signin;

    // Database helper to interact with the SQLite database
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //linking to their XML IDs
        username = (EditText)findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);

        //linking to their XML IDs
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);

        // Initialize the DBHelper instance to interact with the database
        DB = new DBHelper(this);

        // Set an OnClickListener for the signup button
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Retrieve input values for username, password, and confirm password
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                // Check if any field is empty
                if(user.equals("")|| pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {

                    // If passwords match with registration
                    if (pass.equals(repass)) {

                        // Check if the username already exists
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser==false){

                            // If user doesn't exist, insert new user data into the database
                            Boolean insert = DB.insertData(user, pass);
                            if (insert==true) {

                                // Show success message and navigate to HomeActivity
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            } else {
                                // Show failure message if registration fails
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            // If the username exists, show a message to the user
                            Toast.makeText(MainActivity.this, "User already exists! please sign in", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        // If passwords don't match, show a message to the user
                        Toast.makeText(MainActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        // Set an OnClickListener for the signin button
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to LoginActivity when the signin button is clicked
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}