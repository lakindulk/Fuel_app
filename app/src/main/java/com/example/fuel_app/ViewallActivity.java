package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewallActivity extends AppCompatActivity {
    ListView typeList;
    FuelTypeBasedAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);

        typeList=(ListView) findViewById(R.id.newListView);
        FueltypeDetailsService fueltypeDetailsService=new FueltypeDetailsService(ViewallActivity.this);
        fueltypeDetailsService.getAllTypes(new FueltypeDetailsService.VolleyResponseListener() {
            @Override
            public void onResponse(ArrayList<FuelTypeModel> typeModel) {
                System.out.println("Type Data ss"+ typeModel);
                listAdapter=new FuelTypeBasedAdapter(getApplicationContext(),typeModel);
                typeList.setAdapter(listAdapter);
                typeList.setClickable(true);
                typeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        System.out.println("Clicked One"+i);
                        Intent intent=new Intent(getApplicationContext(),ViewcountActivity.class);
                        intent.putExtra("ID",typeModel.get(i).getId());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(String message) {
                Toast.makeText(ViewallActivity.this,message , Toast.LENGTH_LONG).show();

            }
        });
    }
}