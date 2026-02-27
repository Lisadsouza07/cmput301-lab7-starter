package com.example.androiduitesting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    TextView textView_city;
    Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        textView_city = findViewById(R.id.textView_city);
        button_back = findViewById(R.id.button_back);

        // Get city name from intent
        Intent intent = getIntent();
        String cityName = intent.getStringExtra("CITY_NAME");

        textView_city.setText(cityName);

        // Back button
        button_back.setOnClickListener(v -> {
            finish(); // go back to MainActivity
        });
    }
}