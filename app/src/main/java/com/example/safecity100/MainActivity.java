package com.example.safecity100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }


    public void HelplineNumber(View view) {
        Intent intent = new Intent(MainActivity.this, HelplineNumber.class);

        startActivity(intent);
    }


    public void Category(View view) {
        Intent intent = new Intent(MainActivity.this, CategoryTypes.class);

        startActivity(intent);
    }
    public void  FirstAid(View view){
        Intent intent = new Intent(MainActivity.this,FirstAid.class);

        startActivity(intent);
    }

    public void ReportCrime(View view) {
        Intent intent = new Intent(MainActivity.this,CategoryTypes.class);
        startActivity(intent);
    }





}