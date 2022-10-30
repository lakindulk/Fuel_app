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
//this class is to handle all business logics
public class RegisterActivity extends AppCompatActivity {

    Button signinbtn;
    EditText vehiclenum,password,vtype,ftype,chesis;
    private DBHelper DB;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DB = new DBHelper(this);
        signinbtn = findViewById(R.id.userregibtn);
        vehiclenum = findViewById(R.id.vehiclenumber);
        password = findViewById(R.id.password);
        vtype = findViewById(R.id.vehicletype);
        ftype = findViewById(R.id.fueltype);
        chesis = findViewById(R.id.chesisnumber);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
               // startActivity(intent);

                String vnum,pw,v_type,f_type,chesis_n;
                vnum = vehiclenum.getText().toString();
                pw = password.getText().toString();
                v_type = vtype.getText().toString();
                f_type = ftype.getText().toString();
                chesis_n = chesis.getText().toString();

                if(vnum.equals("")|| pw.equals("")|| v_type.equals("")|| f_type.equals("")|| chesis_n.equals("")){
                    Toast.makeText(RegisterActivity.this, "You should fill all fields !!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUser = DB.checkusername(vnum);
                    if(checkUser == false){
                       postDataToDB(vnum,pw,v_type,f_type,chesis_n);
                        Boolean insertSuccess = DB.insertData(vnum, pw);
                        if(insertSuccess == true){
                            Toast.makeText(RegisterActivity.this, "User Registered Successfully !", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent1);
                        }else {
                            Toast.makeText(RegisterActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "User already registered !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    // implementation to post the vehicle owner data to DB
    private void postDataToDB(String vnum, String pw, String v_type, String f_type, String chesis_n ){
        try {
            // url to post the user data
            String url = "http://172.28.1.50:8080/api/User";
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("vehicleNb", vnum);
            params.put("password", pw);
            params.put("vehicleType", v_type);
            params.put("fuelType", f_type);
            params.put("chesisNb", chesis_n);
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
            requestQueue = Volley.newRequestQueue(RegisterActivity.this);
            requestQueue.add(req);
        }catch (Exception e){
        }
    }
}