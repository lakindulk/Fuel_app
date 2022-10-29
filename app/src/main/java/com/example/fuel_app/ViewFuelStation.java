package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
//this class is to handle all business logics
public class ViewFuelStation extends AppCompatActivity {

    ListView stationList;
    CustomBaseAdapter listAdapter;
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fuel_station);


        Intent intent = this.getIntent();
        if(intent != null){
            userid = intent.getStringExtra("userId");
        }

        stationList = (ListView) findViewById(R.id.customListView);

        StationDetailsService stationDataService = new StationDetailsService(ViewFuelStation.this);
        stationDataService.getAllStations(new StationDetailsService.VolleyResponseListener() {
            @Override
            public void onResponse(ArrayList<FuelStationModel> stationModel) {
                System.out.println("station data : " + stationModel);
//                ArrayAdapter arr = new ArrayAdapter(ViewFuelStation.this, android.R.layout.simple_list_item_1,stationModel.get());

                listAdapter = new CustomBaseAdapter(getApplicationContext(),stationModel);
                stationList.setAdapter(listAdapter);
                stationList.setClickable(true);
                stationList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        System.out.println("Clicked One:" + i);
                        Intent intent = new Intent(getApplicationContext(),Queue_home.class);
                        intent.putExtra("ID",stationModel.get(i).getId());
                        intent.putExtra("userid",userid);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(String message) {
                Toast.makeText(ViewFuelStation.this,message , Toast.LENGTH_LONG).show();
            }
        });

    }
}