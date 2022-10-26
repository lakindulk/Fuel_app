package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Queue_home extends AppCompatActivity {
    Button checkIn;
    String id;
    TextView pet92, pet95, die, dieS,kero,arrTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_home);

        checkIn = findViewById(R.id.checkInBtn);
        pet92 = findViewById(R.id.petrol92Val);
        pet95 = findViewById(R.id.petrol95Val);
        die = findViewById(R.id.autodTxt);
        dieS = findViewById(R.id.superDVal);
        kero = findViewById(R.id.keroVal);
        arrTime = findViewById(R.id.arivalTime);

        Intent intent = this.getIntent();
        if(intent != null){
            id = intent.getStringExtra("ID");
        }
        System.out.println("id : " + id);

        StationDetailsService stationDataService = new StationDetailsService(Queue_home.this);
        stationDataService.getFuelDetails(new StationDetailsService.UserDetailsResponseListener() {
            @Override
            public void onResponse(StationDetailModel stationModel) {
                System.out.println("station data : " + stationModel);
//                ArrayAdapter arr = new ArrayAdapter(ViewFuelStation.this, android.R.layout.simple_list_item_1,stationModel.get());
                    pet92.setText(stationModel.getPetrol92());
                    pet95.setText(stationModel.getPetrol95());
                    die.setText(stationModel.getDiesel());
                    dieS.setText(stationModel.getSuperDiesel());
                    arrTime.setText(stationModel.getArrivalTime());
            }

            @Override
            public void onError(String message) {
                Toast.makeText(Queue_home.this,message , Toast.LENGTH_LONG).show();
            }
        },id);


        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Queue_home.this,Add_checkin_time.class);
                intent.putExtra("ID",id);
                startActivity(intent);
            }
        });
    }
}