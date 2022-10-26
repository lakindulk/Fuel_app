package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OwnerRegistrationActivity extends AppCompatActivity {

    Button ownerregi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_registration);

        ownerregi = findViewById(R.id.ownerregibtn);

        ownerregi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerRegistrationActivity.this,OwnerLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}