package com.example.autka.view;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.autka.R;

import android.view.LayoutInflater;

import java.util.Map;

import model.Brands;
import model.Models;

//TODO (4) Improve brand/model and create other filters


public class MainActivity extends AppCompatActivity {

    Brands brands;
    Models models;

    Spinner brandSpinner, modelSpinner;
    ArrayAdapter<String> brandsAdapter, modelsAdapter;

    Button addRecordButton;
    Button searchButton;
    LinearLayout addedRecordsFilterLayout;
    Integer recordCounter = 0;

    Map<String,String> addedFilterMap;
    public static String textToModelsView = "";

    Intent toSearchActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brandSpinner = (Spinner) findViewById(R.id.brandSpinner);
        modelSpinner = (Spinner) findViewById(R.id.modelSpinner);
        addRecordButton = (Button) findViewById(R.id.addRecordButton);
        searchButton = (Button) findViewById(R.id.searchButton);

        addedRecordsFilterLayout = (LinearLayout) findViewById(R.id.addedFilterRecordsLayout);

        brands = new Brands();
        models = new Models();

        toSearchActivity = new Intent(getApplicationContext(),ResultOfSearchActivity.class);

        brandsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item);
        modelsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item);

        brands.brandsToArray(brandsAdapter);
        brandsAdapter = brands.getBrandsList();
        brandSpinner.setAdapter(brandsAdapter);

        brandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                models.getMarks(brandSpinner.getSelectedItem().toString(), modelsAdapter);
                modelsAdapter = models.getModelsList();
                modelSpinner.setAdapter(modelsAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toSearchActivity);
            }
        });

        addRecordButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                onAddField(v);
                toSearchActivity.putExtra("brand"+recordCounter, brandSpinner.getSelectedItem().toString());
                toSearchActivity.putExtra("model"+recordCounter, modelSpinner.getSelectedItem().toString());
                recordCounter++;
                toSearchActivity.putExtra("recordCounter",recordCounter);
            }
        });

    }
    public void onAddField(View v){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(5,5,5,5);
        rowView.setLayoutParams(lp);
        addedRecordsFilterLayout.addView(rowView, addedRecordsFilterLayout.getChildCount() - 1);
        TextView brandTextView = (TextView) rowView.findViewById(R.id.brandName);
        TextView modelTextView = (TextView) rowView.findViewById(R.id.modelName);
        brandTextView.setText(brandSpinner.getSelectedItem().toString());
        modelTextView.setText(modelSpinner.getSelectedItem().toString());
    }
    public void onDelete(View v) {
        addedRecordsFilterLayout.removeView((View) v.getParent());
    }
}
