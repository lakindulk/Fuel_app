package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OwnerLoginActivity extends AppCompatActivity {

    TextView signinbtn;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        login =findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerLoginActivity.this,FueltypeMainActivity.class);
                startActivity(intent);
            }
        });

        signinbtn = findViewById(R.id.ownersignup);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerLoginActivity.this,OwnerRegistrationActivity.class);
                startActivity(intent);
            }
        });

    }
}