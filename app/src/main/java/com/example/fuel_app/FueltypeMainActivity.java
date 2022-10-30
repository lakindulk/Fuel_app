package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//this class is to handle all business logics
public class FueltypeMainActivity extends AppCompatActivity {

    Button viewall,addstock,addcount,usermana;
    String Un;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fueltype_main);

        usermana = findViewById(R.id.usermanagement);
        viewall = findViewById(R.id.fueltype_viewall);
        addstock = findViewById(R.id.fueltype_addfuel);
        addcount = findViewById(R.id.daily_count);
        Intent intent = this.getIntent();
        Un = intent.getStringExtra("IDD");

        usermana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FueltypeMainActivity.this, UserManagementActivity.class));
            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentw = new Intent(FueltypeMainActivity.this, ViewallActivity.class);
                intentw.putExtra("IDDU",Un);
                startActivity(intentw);

            }
        });



        addstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intents = new Intent(FueltypeMainActivity.this, updateall.class);
                intents.putExtra("IDDU2",Un);
                startActivity(intents);
            }
        });

        addcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(FueltypeMainActivity.this, AdddailyvehiclecountActivity.class);
                intent1.putExtra("IDDD",Un);
                startActivity(intent1);

            }
        });
    }


}