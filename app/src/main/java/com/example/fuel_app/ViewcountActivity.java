package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ViewcountActivity extends AppCompatActivity {
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcount);

        Intent intent = this.getIntent();
        if(intent != null){
            id = intent.getStringExtra("ID");
        }
        System.out.println("id : " + id);
    }
}