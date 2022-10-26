package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class OwnerRegistrationActivity extends AppCompatActivity {

    Button ownerregi;
    EditText uname,password,sname,rnum,city;
    private DBHelperOwner DB;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_registration);
        DB = new DBHelperOwner(this);
        ownerregi = findViewById(R.id.ownerregibtn);
        uname = findViewById(R.id.username);
        password = findViewById(R.id.password);
        sname = findViewById(R.id.stationname);
        rnum = findViewById(R.id.registernumber);
        city = findViewById(R.id.city);

        ownerregi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(OwnerRegistrationActivity.this,OwnerLoginActivity.class);
                //startActivity(intent);

                String u_name,pw,s_name,r_num,cit;
                u_name = uname.getText().toString();
                pw = password.getText().toString();
                s_name = sname.getText().toString();
                r_num = rnum.getText().toString();
                cit = city.getText().toString();

                if(u_name.equals("")|| pw.equals("")|| s_name.equals("")|| r_num.equals("")|| cit.equals("")){
                    Toast.makeText(OwnerRegistrationActivity.this, "You should fill all fields !!", Toast.LENGTH_SHORT).show();
                }

                else{
                    Boolean checkUser = DB.checkusername(u_name);
                    if(checkUser == false){
                        //postDataToDB(vnum,pw,v_type,f_type,chesis_n);
                        Boolean insertSuccess = DB.insertData(u_name, pw);
                        if(insertSuccess == true){
                            Toast.makeText(OwnerRegistrationActivity.this, "User Registered Successfully !", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(OwnerRegistrationActivity.this, OwnerLoginActivity.class);
                            startActivity(intent1);
                        }else {
                            Toast.makeText(OwnerRegistrationActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(OwnerRegistrationActivity.this, "User already registered !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    // implementation to post the station owner data to DB
    private void postDataToDB(String u_name, String pw, String s_name, String r_num, String cit ){
        try {
            // url to post the user data
            String url = "http://192.168.1.11:8081/api/Customer";
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("userName", u_name);
            params.put("password", pw);
            params.put("stationName", s_name);
            params.put("registerNb", r_num);
            params.put("city", cit);
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
            requestQueue = Volley.newRequestQueue(OwnerRegistrationActivity.this);
            requestQueue.add(req);
        }catch (Exception e){
        }
    }
}