package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//this class is to handle all business logics
public class Home_Screen extends AppCompatActivity {

    Button fuelType, queue;
    String userId;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        fuelType = findViewById(R.id.fuelTypeBtn);
        queue = findViewById(R.id.queueBtn);


        Intent intent = this.getIntent();
        if(intent != null){
            userId = intent.getStringExtra("user");
        }

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
                intent.putExtra("userId", userId);
                startActivity(intent);
            }
        });
    }
}