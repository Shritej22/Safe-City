package com.example.safecity100;

import androidx.annotation.Nullable;
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

public class RegistrationActivity extends AppCompatActivity {

    EditText register_username,register_email,register_password;
    String str_name,str_email,str_password;
    String url ="https://safecity724.000webhostapp.com/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        register_username = findViewById(R.id.register_username);
        register_email = findViewById(R.id.register_email);
        register_password = findViewById(R.id.register_password);

    }

    public void Register(View view) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");

        if(register_username.getText().toString().equals("")){
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        }
        else if(register_email.getText().toString().equals("")){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        else if(register_password.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else{

            progressDialog.show();
            str_name = register_username.getText().toString().trim();
            str_email = register_email.getText().toString().trim();
            str_password = register_password.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    register_username.setText("");
                    register_email.setText("");
                    register_password.setText("");
                    Toast.makeText(RegistrationActivity.this,response,Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(RegistrationActivity.this,error.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
            }

            ){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();


                    params.put("name", str_name);
                    params.put("email", str_email);
                    params.put("password", str_password);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(RegistrationActivity.this);
            requestQueue.add(request);




        }
        Intent intent =new Intent(RegistrationActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();



    }

    public void moveToLogin(View view) {
        Intent intent =new Intent(RegistrationActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
