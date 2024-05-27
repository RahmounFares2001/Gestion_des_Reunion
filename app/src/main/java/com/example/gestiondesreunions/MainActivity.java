package com.example.gestiondesreunions;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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


        // login btn
        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check user
                EditText usernameEditText = findViewById(R.id.username);
                EditText passwordEditText = findViewById(R.id.password);

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if( username.equals("admin") && password.equals("admin") ) {
                    // Start ListActivity
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Wrong password or username", Toast.LENGTH_LONG).show();
                };


            }
        });
    }
}