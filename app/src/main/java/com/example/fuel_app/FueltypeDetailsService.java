package com.example.fuel_app;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

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
// this service is to manage api requests in fuel type api
public class FueltypeDetailsService {
    Context context;

    public FueltypeDetailsService(Context context){this.context=context;}




    public interface VolleyResponseListener{
        void onResponse(ArrayList<FuelTypeModel> typeModels);
        void onError(String message);
    }
//Get All Data
    public void getAllTypes(VolleyResponseListener volleyResponseListener){
        System.out.println("Get All Fuel Type");
        ArrayList<FuelTypeModel> fuelTypeList = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://172.28.1.50:8080/api/FuelTypeUpdate";
        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    System.out.println("H11" + response);
                    for (int i = 0; i < response.length(); i++) {
                        FuelTypeModel typeModel = new FuelTypeModel();
                        JSONObject first_data = (JSONObject) response.get(i);
                        String data=Global.getInstance().getData().toString();
                        typeModel.setFuelType(first_data.getString("fuelType"));
                        String owner = typeModel.getFuelType();
                        if(data.equals(owner)){
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

//Update Fuel data
public interface VolleyResponseListenerUpdatetypeData{
    void onResponse(String msg);
    void onError(String message);
}
    public void updateFuelType(VolleyResponseListenerUpdatetypeData done_updating, String id, String stationID, String arrive, String fftype, String four, String six, String three, String two, String petrol92, String petrol95, String diesel, String supDiesel, String finish) {
        RequestQueue queue=Volley.newRequestQueue(context);
        System.out.println(stationID);
        String url="http://172.28.1.50:8080/api/FuelTypeUpdate/"+id+"?stationID="+stationID+"&arrivalTime="+arrive+"&fuelType="+fftype+"&noOfFourweel="+four+"&noOfSixweel="+six+"&noOfThreeweel="+three+"&noOfTwoweel="+two+"&petrol92="+petrol92+"&petrol95="+petrol95+"&diesel="+diesel+"&superDiesel="+supDiesel+"&finishTime="+finish;
        System.out.println("vs");

        StringRequest putRequest=new StringRequest(Request.Method.PUT, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("bhghgvhs"+response);

                        done_updating.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Error :"+error);
                        done_updating.onError("Error in Updating Fuel Types");
                    }
                }

        );
        queue.add(putRequest);
    }
    /*public void updateFuelType(VolleyResponseListenerUpdatetypeData updateFuelTypeResponseListener,String id, String stationID, String arrive, String fftype, String four, String six, String three, String two, String petrol92, String petrol95, String diesel, String supDiesel, String finish){

        RequestQueue queue=Volley.newRequestQueue(context);
        System.out.println(stationID);
        String url="http://172.28.1.50:8090/api/FuelTypeUpdate/"+id+"?stationID="+stationID+"&arrivalTime="+arrive+"&fuelType="+fftype+"&noOfFourweel="+four+"&noOfSixweel="+six+"&noOfThreeweel="+three+"&noOfTwoweel="+two+"&petrol92="+petrol92+"&petrol95="+petrol95+"&diesel="+diesel+"&superDiesel="+supDiesel+"&finishTime="+finish;
        System.out.println("vs");

        StringRequest putRequest=new StringRequest(Request.Method.PUT, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("bhghgvhs");

                        updateFuelTypeResponseListener.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Error :"+error);
                        updateFuelTypeResponseListener.onError("Error in Updating Fuel Types");
                    }
                }

        );
        queue.add(putRequest);
    }*/


}