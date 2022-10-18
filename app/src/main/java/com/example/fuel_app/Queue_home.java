package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Queue_home extends AppCompatActivity {
    Button checkIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_home);

        checkIn = findViewById(R.id.checkInBtn);

        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Queue_home.this,Add_checkin_time.class);
                startActivity(intent);
            }
        });
    }
}