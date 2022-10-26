package com.example.fuel_app;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FueltypeDetailsService {
Context context;

    public FueltypeDetailsService(Context context){this.context=context;}

    public interface VolleyResponseListener{
        void onResponse(ArrayList<FuelTypeModel> typeModels);
        void onError(String message);
    }

    public void getAllTypes(VolleyResponseListener volleyResponseListener){
        System.out.println("Get All Fuel Type");
        ArrayList<FuelTypeModel> fuelTypeList = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://192.168.1.5:8090/api/FuelTypeUpdate";
        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    System.out.println("H11" + response);
                    for (int i = 0; i < response.length(); i++) {
                        FuelTypeModel typeModel = new FuelTypeModel();
                        JSONObject first_data = (JSONObject) response.get(i);
                        System.out.println("Type r" + first_data);
                        typeModel.setId(first_data.getString("id"));
                        typeModel.setStationID(first_data.getString("stationID"));
                        typeModel.setFuelType(first_data.getString("fuelType"));
                        typeModel.setPetrol92(first_data.getString("petrol92"));
                        typeModel.setPetrol95(first_data.getString("petrol95"));
                        typeModel.setDiesel(first_data.getString("diesel"));
                        typeModel.setSuperDiesel(first_data.getString("superDiesel"));
                        typeModel.setArrivalTime(first_data.getString("arrivalTime"));
                        typeModel.setFinishTime(first_data.getString("finishTime"));
                        typeModel.setNoOfFourweel(first_data.getString("noOfFourweel"));
                        typeModel.setNoOfThreeweel(first_data.getString("noOfThreeweel"));
                        typeModel.setNoOfTwoweel(first_data.getString("noOfTwoweel"));
                        typeModel.setNoOfSixweel(first_data.getString("noOfSixweel"));

                        fuelTypeList.add(typeModel);
                    }
                    volleyResponseListener.onResponse(fuelTypeList);
                } catch (JSONException e) {
                    System.out.println(" error" + e);
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error :"+error);
                volleyResponseListener.onError("Error Fetching FuelType Data");
            }
        });
        queue.add(request);
    }


}
