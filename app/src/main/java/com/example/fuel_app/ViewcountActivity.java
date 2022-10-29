package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewcountActivity extends AppCompatActivity {
    String id;
    TextView station_id,arrival_time,petrol92,petrol95,diesel,superdiesal,finish,twoweel,threeweel,fourweel,sixweel;
    String atime,p92,p95,d,sd,end,two,three,four,six;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcount);


        station_id=findViewById(R.id.station_id);
        arrival_time=findViewById(R.id.arrival_time);
        petrol92=findViewById(R.id.petrol92);
        petrol95=findViewById(R.id.petrol95);
        diesel=findViewById(R.id.diesel);
        superdiesal=findViewById(R.id.superdiesal);
        finish=findViewById(R.id.finish);
        twoweel=findViewById(R.id.twoweel);
        threeweel=findViewById(R.id.threeweel);
        fourweel=findViewById(R.id.fourweel);
        sixweel=findViewById(R.id.sixweel);

        Intent intent = this.getIntent();
        if(intent != null){
            id = intent.getStringExtra("ID");
            atime = intent.getStringExtra("ATime");
            p92 = intent.getStringExtra("Pet92");
            p95 = intent.getStringExtra("Pet95");
            d = intent.getStringExtra("Dies");
            sd = intent.getStringExtra("SuperDies");
            end = intent.getStringExtra("EndTime");
            two = intent.getStringExtra("TwoW");
            three = intent.getStringExtra("ThreeW");
            four = intent.getStringExtra("FourW");
            six = intent.getStringExtra("SixW");

        }
        System.out.println("id : " + id);
        station_id.setText(id);
        arrival_time.setText(atime);
                petrol92.setText(p92);
                petrol95.setText(p95);
                diesel.setText(d);
                superdiesal.setText(sd);
                finish.setText(end);
                twoweel.setText(two);
                threeweel.setText(three);
                fourweel.setText(four);
                sixweel.setText(six);

    }
}