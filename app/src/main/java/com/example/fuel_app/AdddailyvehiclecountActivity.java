package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

//this class is to handle all business logics
public class AdddailyvehiclecountActivity extends AppCompatActivity {
EditText stationID,noOffourweel,noOfSixweel,stationname,noOfThreeweel,noOfTwoweel;
    String Unn,stationIDs,stationnames,noOffourweels,noOfSixweels,noOfThreeweels,noOfTwoweels;
    private RequestQueue requestQueue;

    Button addcount;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddailyvehiclecount);

        stationID=findViewById(R.id.stationID);
        addcount=findViewById(R.id.addcount);
        noOffourweel=findViewById(R.id.noOffourweel);
        noOfSixweel=findViewById(R.id.noOfSixweel);
        noOfThreeweel=findViewById(R.id.noOfThreeweel);
        noOfTwoweel=findViewById(R.id.noOfTwoweel);
        stationname=findViewById(R.id.stationname);
        Intent intent = this.getIntent();
        Unn = intent.getStringExtra("IDDD");
        addcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stationIDs=stationID.getText().toString();
                noOffourweels=noOffourweel.getText().toString();
                noOfSixweels=noOfSixweel.getText().toString();
                noOfThreeweels=noOfThreeweel.getText().toString();
                noOfTwoweels=noOfTwoweel.getText().toString();
                if(stationIDs.equals("")  ){
                    Toast.makeText(AdddailyvehiclecountActivity.this, "You should fill ID  !!", Toast.LENGTH_SHORT).show();
                }else{
                    postDataToDB(stationIDs,Unn,noOffourweels,noOfSixweels,noOfThreeweels,noOfTwoweels);
                    Intent intent = new Intent(AdddailyvehiclecountActivity.this,ViewallActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
    private void postDataToDB(String stationIDs, String Unn, String noOffourweels, String noOfSixweels, String noOfThreeweels,String noOfTwoweels  ) {
    try{
        // url to post the user data
        String url = "http://172.28.1.50:8080/api/FuelTypeUpdate";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("StationId",stationIDs);
        params.put("fuelType",Unn);
        params.put("noOfTwoweel", noOfTwoweels);
        params.put("noOfThreeweel", noOfThreeweels);
        params.put("noOfFourweel", noOffourweels);
        params.put("noOfSixweel", noOfSixweels);
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
        requestQueue = Volley.newRequestQueue(AdddailyvehiclecountActivity.this);
        requestQueue.add(req);

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}