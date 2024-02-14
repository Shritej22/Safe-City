package com.example.safecity100;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class DISASTER extends AppCompatActivity {

    TextView TextDescription;
    EditText Contact,Name;
    Button ButtonInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);

        TextDescription = findViewById(R.id.textdescription);
        Contact = findViewById(R.id.textphone);
        Name = findViewById(R.id.name);
        ButtonInsert = findViewById(R.id.buttoninsert);

        ButtonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

    }

    private void insertData() {

        final String description = TextDescription.getText().toString().trim();
        final String name = Name.getText().toString().trim();
        final String contact = Contact.getText().toString().trim();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        if (name.isEmpty()){
            Toast.makeText(this,"Enter Name",Toast.LENGTH_SHORT).show();
            return;
        }
        else if (contact.isEmpty()){
            Toast.makeText(this,"Enter Contact",Toast.LENGTH_SHORT).show();
            return;
        }
        else if (description.isEmpty()){
            Toast.makeText(this,"Enter Data",Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://safecity724.000webhostapp.com/insert.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("Data Stored")){
                                Toast.makeText(DISASTER.this, "Data Stored", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else {
                                Toast.makeText(DISASTER.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(DISASTER.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            ){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("name",name);
                    params.put("contact",contact);
                    params.put("description",description);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(DISASTER.this);
            requestQueue.add(request);

        }
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }


}