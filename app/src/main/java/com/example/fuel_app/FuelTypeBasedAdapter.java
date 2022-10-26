package com.example.fuel_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FuelTypeBasedAdapter extends ArrayAdapter<FuelTypeModel> {
    public FuelTypeBasedAdapter(@NonNull Context context, ArrayList<FuelTypeModel> fuelTypeModelArrayList){
        super(context,R.layout.activity_fueltype_listview,fuelTypeModelArrayList);
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        System.out.println("inside get type view");
        FuelTypeModel model = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_fueltype_listview,parent,false);
        }
        System.out.println("station Name : " + model.getStationID());
        TextView stationName = convertView.findViewById(R.id.newfuelview);
        stationName.setText(model.getStationID()+"-"+model.getFuelType() );
        return convertView;

    }
}
