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

public class StationDetailsService {
    Context context;

    public StationDetailsService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onResponse(ArrayList<FuelStationModel> stationModel);
        void onError(String message);
    }

    public void getAllStations(VolleyResponseListener volleyResponseListener) {
        System.out.println("inside get all");
        ArrayList<FuelStationModel> stationModelList = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://192.168.1.5:8090/api/Owner";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    System.out.println("Hi: " + response);
                    for (int i = 0; i < response.length(); i++) {
                        FuelStationModel stationModel = new FuelStationModel();
                        JSONObject first_data = (JSONObject) response.get(i);
                        System.out.println("station data " + first_data);
                        stationModel.setId(first_data.getString("id"));
                        stationModel.setStationName(first_data.getString("stationName"));
                        stationModel.setCity(first_data.getString("city"));
                        stationModel.setName("stationName" + "city");
//                        stationModel.setArrivaltime(first_data.getBoolean("openCloseStatus"));
//                        stationModel.setFinishTime(first_data.getBoolean("openCloseStatus"));

                        stationModelList.add(stationModel);

                    }

                    volleyResponseListener.onResponse(stationModelList);

                } catch (JSONException e) {
                    System.out.println("error in service: " + e);
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error : "+error);
                volleyResponseListener.onError("Error Fetching Stations!!!");
            }
        });
        queue.add(request);
    }


}
