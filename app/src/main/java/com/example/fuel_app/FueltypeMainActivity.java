package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FueltypeMainActivity extends AppCompatActivity {

    Button viewall,addstock,addcount,usermana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fueltype_main);

        usermana = findViewById(R.id.usermanagement);
        viewall = findViewById(R.id.fueltype_viewall);
        addstock = findViewById(R.id.fueltype_addfuel);
        addcount = findViewById(R.id.daily_count);

        usermana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FueltypeMainActivity.this, UserManagementActivity.class));
            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FueltypeMainActivity.this, ViewallActivity.class));
            }
        });



        addstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FueltypeMainActivity.this, AddstockActivity.class));
            }
        });

        addcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FueltypeMainActivity.this, AdddailyvehiclecountActivity.class));
            }
        });
    }


}