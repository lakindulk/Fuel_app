package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
//this class is to handle all business logics
public class Queue_home extends AppCompatActivity {
    Button checkIn,checkOut;
    String id,userID;
    TextView pet92, pet95, die, dieS,kero,arrTime;
    @SuppressLint("MissingInflatedId")
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
            userID = intent.getStringExtra("userid");
        }

        System.out.println("id : " + id);

        StationDetailsService stationDataService = new StationDetailsService(Queue_home.this);
        stationDataService.getFuelDetails(new StationDetailsService.StationDetailsResponseListener() {
            @Override
            public void onResponse(StationDetailModel stationModel) {
                System.out.println("station data : " + stationModel);
                System.out.println("pet92 : "+stationModel.getPetrol92().toString());
                pet92.setText(stationModel.getPetrol92().toString());
                pet95.setText(stationModel.getPetrol95().toString());
                die.setText(stationModel.getDiesel().toString());
                dieS.setText(stationModel.getSuperDiesel().toString());
                arrTime.setText(stationModel.getArrivalTime().toString());
            }

            @Override
            public void onError(String message) {
                Toast.makeText(Queue_home.this,message , Toast.LENGTH_LONG).show();
            }
        },id);
        UserDetailsModel user = new UserDetailsModel();
        StationUpdateModel updateModel = new StationUpdateModel();
        System.out.println("user id : "+ userID);
        stationDataService.getUserQueueDetails(new StationDetailsService.StationUpdateResponseListener() {
            @Override
            public void onResponse(StationUpdateModel stationModel) {
                System.out.println("station data : " + stationModel);

            }

            @Override
            public void onError(String message) {
                Toast.makeText(Queue_home.this,message , Toast.LENGTH_LONG).show();
            }
        },userID);
        System.out.println("update model : "+updateModel.getCheckOutTime());

        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Queue_home.this,Add_checkin_time.class);
                intent.putExtra("ID",id);
                startActivity(intent);}

        });

    }
}