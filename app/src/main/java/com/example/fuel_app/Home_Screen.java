package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Screen extends AppCompatActivity {

    Button fuelType, queue;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        fuelType = findViewById(R.id.fuelTypeBtn);
        queue = findViewById(R.id.queueBtn);

        fuelType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Screen.this,FueltypeMainActivity.class);
                startActivity(intent);
            }
        });

        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Screen.this,ViewFuelStation.class);
                startActivity(intent);
            }
        });
    }
}