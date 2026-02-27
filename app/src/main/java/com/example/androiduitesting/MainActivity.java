package com.example.androiduitesting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    EditText newName;
    LinearLayout nameField;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.field_nameEntry);
        newName  = findViewById(R.id.editText_name);
        cityList = findViewById(R.id.city_list);

        dataList = new ArrayList<>();

        cityAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dataList
        );

        cityList.setAdapter(cityAdapter);

        // ADD BUTTON
        Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(v ->
                nameField.setVisibility(View.VISIBLE)
        );

        // CONFIRM BUTTON
        Button confirmButton = findViewById(R.id.button_confirm);
        confirmButton.setOnClickListener(v -> {

            String cityName = newName.getText().toString().trim();

            if (!cityName.isEmpty()) {
                cityAdapter.add(cityName);
                cityAdapter.notifyDataSetChanged();
            }

            newName.getText().clear();
            nameField.setVisibility(View.INVISIBLE);
        });

        // CLEAR BUTTON
        Button deleteButton = findViewById(R.id.button_clear);
        deleteButton.setOnClickListener(v -> {
            cityAdapter.clear();
            cityAdapter.notifyDataSetChanged();
        });

        // OPEN ShowActivity
        cityList.setOnItemClickListener((parent, view, position, id) -> {

            String selectedCity = cityAdapter.getItem(position);

            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            intent.putExtra("CITY_NAME", selectedCity);
            startActivity(intent);
        });
    }
}