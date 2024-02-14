package com.example.safecity100;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class LoginActivity extends AppCompatActivity {

    EditText register_email,register_password;
    String str_email,str_password;
    String url = "https://safecity724.000webhostapp.com/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register_email = findViewById(R.id.register_email);
        register_password = findViewById(R.id.register_password);
    }

    public void Login(View view) {

        if(register_email.getText().toString().equals("")){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        else if(register_password.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else{

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait...");

            progressDialog.show();
            str_email = register_email.getText().toString().trim();
            str_password = register_password.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();

                    if (response.equalsIgnoreCase("Logged in Successfully")) {

                        register_email.setText("");
                        register_password.setText("");
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,error.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
            }

            ){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("email", str_email);
                    params.put("password", str_password);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
            requestQueue.add(request);
        }
        Intent intent =new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }


    }




