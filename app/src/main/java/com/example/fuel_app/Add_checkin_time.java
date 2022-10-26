package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Add_checkin_time extends AppCompatActivity {

    Editable checkInTime;
    Button checkInBtn;
    EditText cheinInTxt;
    private RequestQueue requestQueue;
    String id;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_checkin_time);

        cheinInTxt = findViewById(R.id.addCheckInTime);
        checkInBtn = findViewById(R.id.addTime);

        Intent intent = this.getIntent();
        if(intent != null){
            id = intent.getStringExtra("ID");
        }
        System.out.println("id : " + id);


        checkInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInTime = cheinInTxt.getText();

                if(checkInTime.equals("") ){
                    Toast.makeText(Add_checkin_time.this, "Enter Checkin time", Toast.LENGTH_SHORT).show();

                } else {
                    try {
                        // url to post the user data
                        String url = "http://192.168.1.4:8080/api/FuelQueueUpdate";

                        HashMap<String, String> params = new HashMap<String, String>();

                        params.put("StationId", id);
                        params.put("VehicleType", "Car");
                        params.put("NoOfLiters", "");
                        params.put("CheckInTime", checkInTime.toString());
                        params.put("CheckOutTime", "");
                        params.put("FuelType", "Petrol");

                        JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(params),
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        try {
                                            VolleyLog.v("Response:%n %s", response.toString(4));
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.e("Error: ", error.getMessage());
                            }
                        });

                        requestQueue = Volley.newRequestQueue(Add_checkin_time.this);
                        requestQueue.add(req);

                        Intent intent = new Intent(Add_checkin_time.this,Add_checkout_time.class);
                        startActivity(intent);

                    }catch (Exception e){

                    }
                }


            }
        });

    }
}