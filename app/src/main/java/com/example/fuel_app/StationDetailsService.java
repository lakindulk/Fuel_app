package com.example.fuel_app;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
// this service is to call the api
public class StationDetailsService {
    Context context;

    public StationDetailsService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onResponse(ArrayList<FuelStationModel> stationModel);
        void onError(String message);
    }

    public void getAllStations(VolleyResponseListener volleyResponseListener) { // get all fuel station details
        System.out.println("inside get all");
        ArrayList<FuelStationModel> stationModelList = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://172.28.25.18:8080/api/Owner";
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

    public interface StationDetailsResponseListener{
        void onResponse(StationDetailModel object);
        void onError(String message);
    }
    public void getFuelDetails (StationDetailsResponseListener volleyResponseListener,String id) { // fetch station details by id
        System.out.println("inside fuel station get method : " + id);
        RequestQueue queue = Volley.newRequestQueue(context);
        StationDetailModel stationModel = new StationDetailModel();
        String url = "http://172.28.25.18:8080/api/FuelTypeUpdate/getStations/"+id;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("Station DATA FROM API: " + response);
                    JSONObject object = new JSONObject(response);
                    stationModel.setId(object.getString("id"));
                    stationModel.setStationId(object.getString("stationID"));
                    stationModel.setDiesel(object.getString("diesel"));
                    stationModel.setPetrol92(object.getString("petrol92"));
                    stationModel.setPetrol95(object.getString("petrol95"));
                    stationModel.setSuperDiesel(object.getString("superDiesel"));
                    stationModel.setArrivalTime(object.getString("arrivalTime"));

                    volleyResponseListener.onResponse(stationModel);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("Error Fetching User!!!"+error);
            }
        });
        queue.add(request);


    }

    public interface StationUpdateResponseListener{
        void onResponse(StationUpdateModel object);
        void onError(String message);
    }

    public void getUserQueueDetails(StationUpdateResponseListener volleyResponseListener, String id) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StationUpdateModel stationModel = new StationUpdateModel();
        String url = "http://172.28.25.18:8080/api/FuelQueueUpdate/userQ/"+id;

            StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        System.out.println("queue DATA FROM API: " + response);
                        JSONObject object = new JSONObject(response);

                        volleyResponseListener.onResponse(stationModel);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    volleyResponseListener.onError("Error Fetching User!!!"+error);
                }
            });
    }


}
