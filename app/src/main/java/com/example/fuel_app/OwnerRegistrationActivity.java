package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OwnerRegistrationActivity extends AppCompatActivity {

    TextView signinbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_registration);

        signinbtn = findViewById(R.id.alreadysigninowner);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerRegistrationActivity.this,FueltypeMainActivity.class);
                startActivity(intent);
            }
        });
    }
}