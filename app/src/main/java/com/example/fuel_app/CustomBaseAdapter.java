package com.example.fuel_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomBaseAdapter extends ArrayAdapter<FuelStationModel> {

    //Reference: https://www.youtube.com/watch?v=RHqGiWluAzU&ab_channel=Foxandroid
    public CustomBaseAdapter(@NonNull Context context, ArrayList<FuelStationModel> stationArrayList) {
        super(context, R.layout.activity_custom_list_view,stationArrayList);


    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        System.out.println("inside get view");
        FuelStationModel model = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_list_view,parent,false);
        }

        System.out.println("station Name : " + model.getName());
        TextView stationName = convertView.findViewById(R.id.textView);

        stationName.setText(model.getStationName() + " - " +model.getCity());

        return convertView;
      //return super.getView(position, convertView, parent);
    }
}
