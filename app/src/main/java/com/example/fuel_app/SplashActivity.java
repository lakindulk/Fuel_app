package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//this class is to handle all business logics
public class SplashActivity extends AppCompatActivity {

    Button vehicleownerbtn, stationownerbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        vehicleownerbtn = findViewById(R.id.vehicleowner);
        stationownerbtn = findViewById(R.id.stationowner);

        vehicleownerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        stationownerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this,OwnerLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}