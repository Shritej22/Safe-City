package com.example.safecity100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FirstAid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);
    }

    public void CPR(View view){
        Intent intent = new Intent(FirstAid.this, cprtechnique.class);

        startActivity(intent);
    }
    public void Fracture(View view) {
        Intent intent = new Intent(FirstAid.this,fracturetreatment.class);

        startActivity(intent);
    }

    public void Fire(View view) {
        Intent intent = new Intent(FirstAid.this,fire.class);

        startActivity(intent);
    }

    public void SNAKEBITE(View view) {
        Intent intent = new Intent(FirstAid.this,snakebite.class);

        startActivity(intent);
    }
}