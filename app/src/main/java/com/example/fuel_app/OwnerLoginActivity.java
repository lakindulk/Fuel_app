package com.example.fuel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OwnerLoginActivity extends AppCompatActivity {

    TextView signinbtn;
    Button login;
    EditText username,password;
    private DBHelperOwner DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        login =findViewById(R.id.login);
        DB = new DBHelperOwner(this);
        username = findViewById(R.id.usern);
        password = findViewById(R.id.pa);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(OwnerLoginActivity.this,FueltypeMainActivity.class);
                //startActivity(intent);

                String unum,pw;
                unum = username.getText().toString();
                pw = password.getText().toString();

                if(unum.equals("")|| pw.equals("")){
                    Toast.makeText(OwnerLoginActivity.this, "You should fill all fields !!", Toast.LENGTH_SHORT).show();
                }

                else{
                    Boolean checkUser = DB.checkusername(unum);
                    if(checkUser == false){
                        //postDataToDB(vnum,pw,v_type,f_type,chesis_n);
                        Boolean insertSuccess = DB.insertData(unum, pw);
                        if(insertSuccess == true){
                            Toast.makeText(OwnerLoginActivity.this, "Owner Login Successfully !", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(OwnerLoginActivity.this, FueltypeMainActivity.class);
                            startActivity(intent1);
                        }else {
                            Toast.makeText(OwnerLoginActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });

        signinbtn = findViewById(R.id.ownersignup);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerLoginActivity.this,OwnerRegistrationActivity.class);
                startActivity(intent);
            }
        });

    }
}