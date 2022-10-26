package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView signinbtn;
    Button vehicleLoginButton;
    EditText vehiclenum,password;
    private DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        vehicleLoginButton = findViewById(R.id.vehicleLoginBtn);
        vehiclenum = findViewById(R.id.ve_num);
        password = findViewById(R.id.passw);
        DB = new DBHelper(this);
        vehicleLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LoginActivity.this,Home_Screen.class);
                //startActivity(intent);

                String vnum,pw;
                vnum = vehiclenum.getText().toString();
                pw = password.getText().toString();

                if(vnum.equals("")|| pw.equals("")){
                    Toast.makeText(LoginActivity.this, "Required fields !!", Toast.LENGTH_SHORT).show();
                }

                else{
                    Boolean checkUser = DB.checkusername(vnum);
                    if(checkUser == false){
                        //postDataToDB(vnum,pw);
                        Boolean insertSuccess = DB.insertData(vnum, pw);
                        if(insertSuccess == true){
                            Toast.makeText(LoginActivity.this, "User login Successfully !", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(LoginActivity.this, Home_Screen.class);
                            startActivity(intent1);
                        }else {
                            Toast.makeText(LoginActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        signinbtn = findViewById(R.id.signup);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}