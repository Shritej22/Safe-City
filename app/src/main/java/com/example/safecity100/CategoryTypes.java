package com.example.safecity100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryTypes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_types);
    }

    public void ACCIDENT(View view) {
        Intent intent = new Intent (  CategoryTypes.this , ACCIDENT.class);
        startActivity(intent);
    }

    public void ANIMALABUSE(View view) {
        Intent intent = new Intent(CategoryTypes.this,ANIMALABUSE.class);
        startActivity(intent);
    }

    public void DISASTER(View view) {
        Intent intent = new Intent(CategoryTypes.this,DISASTER.class);
        startActivity(intent);
    }

    public void CRIME(View view){
        Intent intent = new Intent(CategoryTypes.this,CRIME.class);
        startActivity(intent);
    }
}