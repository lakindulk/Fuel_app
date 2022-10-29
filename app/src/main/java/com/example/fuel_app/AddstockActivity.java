package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddstockActivity extends AppCompatActivity {
    String id,sid;
    private EditText station_id,arrival_time,petrol92,petrol95,diesel,superdiesal,finish;
    String atime,p92,p95,d,sd,end,two,three,four,six,fftype;
    private Button addstock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstock);
        station_id= findViewById(R.id.stationid);
        arrival_time=findViewById(R.id.arrivaltime);
        petrol92=findViewById(R.id.petrol92);
        petrol95=findViewById(R.id.petrol95);
        diesel=findViewById(R.id.diesel);
        superdiesal=findViewById(R.id.superdiesel);
        finish=findViewById(R.id.finishtime);
        addstock=findViewById(R.id.addstock);
        Intent intent = this.getIntent();
        if(intent != null){
            id = intent.getStringExtra("ID");
            sid = intent.getStringExtra("SID");
            atime = intent.getStringExtra("ATime");
            p92 = intent.getStringExtra("Pet92");
            p95 = intent.getStringExtra("Pet95");
            d = intent.getStringExtra("Dies");
            sd = intent.getStringExtra("SuperDies");
            end = intent.getStringExtra("EndTime");
            two=intent.getStringExtra("TwoW");
            three=intent.getStringExtra("ThreeW");
            four=intent.getStringExtra("FourW");
            six=intent.getStringExtra("SixW");
            fftype=intent.getStringExtra("ftype");
        }
        System.out.println("id : " + sid);
        station_id.setText(sid);
        arrival_time.setText(atime);
        petrol92.setText(p92);
        petrol95.setText(p95);
        diesel.setText(d);
        superdiesal.setText(sd);
        finish.setText(end);

        addstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stationID=station_id.getText().toString();
                String arrive=arrival_time.getText().toString();
                String Petrol92=petrol92.getText().toString();
                String Petrol95=petrol95.getText().toString();
                String Diesel=diesel.getText().toString();
                String SupDiesel=superdiesal.getText().toString();
                String Finish=finish.getText().toString();

                FueltypeDetailsService fueltypeDetailsService=new FueltypeDetailsService(AddstockActivity.this);
                fueltypeDetailsService.updateFuelType(new FueltypeDetailsService.VolleyResponseListenerUpdatetypeData() {
                    @Override
                    public void onResponse(String msg) {
                        System.out.println("done updating");
                        Intent intent =new Intent(AddstockActivity.this,ViewallActivity.class);

                        startActivity(intent);

                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(AddstockActivity.this, message, Toast.LENGTH_SHORT).show();

                    }
                },id,stationID,arrive,fftype,four,six,three,two,Petrol92,Petrol95,Diesel,SupDiesel,Finish);
            }
        });
    }
}