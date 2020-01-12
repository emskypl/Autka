package com.example.autka.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.autka.R;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.CarsBrands;
import model.CarsModels;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String quote = "\u005c\u0022";

    //filter elements
    private Spinner brandSpinner, modelSpinner;
    private EditText min_price_filter, max_price_filter;
    private EditText min_engine_filter, max_engine_filter;
    private EditText min_hp_filter, max_hp_filter;
    private EditText min_mileage_filter, max_mileage_filter;
    private Spinner year_filter;
    private EditText color_filter;
    private CheckBox damaged_filter;
    private CheckBox automated_filter;
    private CheckBox fuel_filter;
    private CheckBox diesel_filter;
    private CheckBox gas_filter;
    private EditText country_from_filter;
    private EditText region_filter;
    private EditText city_filter;

    //layout elements
    private ImageButton addRecordButton;
    private LinearLayout addedRecordsFilterLayout;
    private Button searchButton;

    //elasticsearch
    String searchString = "";
    private List<String> brandList;
    private List<String> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);



        //filter values
        brandSpinner = (Spinner) findViewById(R.id.brandSpinner);
        modelSpinner = (Spinner) findViewById(R.id.modelSpinner);
        min_price_filter = (EditText) findViewById(R.id.min_price_filter);
        max_price_filter = (EditText) findViewById(R.id.max_price_filter);
        min_engine_filter = (EditText) findViewById(R.id.min_engine_filter);
        max_engine_filter = (EditText) findViewById(R.id.max_price_filter);
        min_hp_filter = (EditText) findViewById(R.id.min_hp_filter);
        max_hp_filter = (EditText) findViewById(R.id.max_hp_filter);
        min_mileage_filter = (EditText) findViewById(R.id.min_mileage_filter);
        max_mileage_filter = (EditText) findViewById(R.id.max_mileage_filter);
        year_filter = (Spinner) findViewById(R.id.year_filter);
        color_filter = (EditText) findViewById(R.id.color_filter);
        damaged_filter = (CheckBox) findViewById(R.id.damaged_filter);
        automated_filter = (CheckBox) findViewById(R.id.automated_filter);
        fuel_filter = (CheckBox) findViewById(R.id.fuel_filter);
        diesel_filter = (CheckBox) findViewById(R.id.diesel_filter);
        gas_filter = (CheckBox) findViewById(R.id.gas_filter);
        country_from_filter = (EditText) findViewById(R.id.country_from_filter);
        region_filter = (EditText) findViewById(R.id.region_filter);
        city_filter = (EditText) findViewById(R.id.city_filter);

        //layout elements
        addRecordButton = (ImageButton) findViewById(R.id.addRecordButton);
        addedRecordsFilterLayout = (LinearLayout) findViewById(R.id.addedFilterRecordsLayout);
        searchButton = (Button) findViewById(R.id.searchButton);

        //elasticsearch
        brandList = new ArrayList<>();
        modelList = new ArrayList<>();

        init();
    }

    private void init() {

        spinnersInit();
        brandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CarsModels models = new CarsModels();
                ArrayAdapter<String> modelsAdapter = new ArrayAdapter<>(view.getContext(),android.R.layout.simple_spinner_dropdown_item);
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
                Intent toResultOfSearch = new Intent(getApplicationContext(),ResultOfSearchActivity.class);
                toResultOfSearch.putExtra("brands", brandList.toArray());
                toResultOfSearch.putExtra("models", modelList.toArray());
                toResultOfSearch.putExtra("minHp", min_hp_filter.getText().toString());
                toResultOfSearch.putExtra("maxHp", max_hp_filter.getText().toString());
                toResultOfSearch.putExtra("minEngine", min_engine_filter.getText().toString());
                toResultOfSearch.putExtra("maxEngine", max_engine_filter.getText().toString());
                toResultOfSearch.putExtra("automated", automated_filter.getText().toString());
                toResultOfSearch.putExtra("fuel", fuel_filter.getText().toString());
                toResultOfSearch.putExtra("year", year_filter.getSelectedItem().toString());
                toResultOfSearch.putExtra("country", color_filter.getText().toString());
                toResultOfSearch.putExtra("minMileage", min_mileage_filter.getText().toString());
                toResultOfSearch.putExtra("maxMileage", max_mileage_filter.getText().toString());
                toResultOfSearch.putExtra("damaged", damaged_filter.getText().toString());
                toResultOfSearch.putExtra("color", color_filter.getText().toString());
                toResultOfSearch.putExtra("minPrice", min_price_filter.getText().toString());
                toResultOfSearch.putExtra("maxPrice", max_price_filter.getText().toString());
                toResultOfSearch.putExtra("region", region_filter.getText().toString());
                toResultOfSearch.putExtra("city", city_filter.getText().toString());
                startActivity(toResultOfSearch);
            }
        });

        addRecordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onAddField(v);
            }
        });


    }

    private void spinnersInit(){
        //brands
        CarsBrands brands = new CarsBrands();
        ArrayAdapter<String> brandsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item);
        brandsAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_orange);
        brands.brandsToArray(brandsAdapter);
        brandsAdapter = brands.getBrandsList();
        brandSpinner.setAdapter(brandsAdapter);

        ArrayAdapter<String> year_filter_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner);
        year_filter_adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);

        year_filter_adapter.add("Wszystkie roczniki");
        for(int i=Calendar.getInstance().get(Calendar.YEAR);i > 1901 ;i--){
            year_filter_adapter.add(Integer.toString(i));
        }
        year_filter.setAdapter(year_filter_adapter);
    }

    private void onAddField(View v){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(5,5,5,5);
        rowView.setLayoutParams(lp);
        addedRecordsFilterLayout.addView(rowView, addedRecordsFilterLayout.getChildCount() - 1);
        TextView brandTextView = (TextView) rowView.findViewById(R.id.brandName);
        TextView modelTextView = (TextView) rowView.findViewById(R.id.modelName);
        brandTextView.setText(brandSpinner.getSelectedItem().toString());
        brandList.add(brandTextView.getText().toString());
        Log.d(TAG, "onAddField: "+ brandList.get(brandList.size()-1));
        modelTextView.setText(modelSpinner.getSelectedItem().toString());
        modelList.add(modelTextView.getText().toString());
        Log.d(TAG, "onAddField: " + modelList.get(modelList.size()-1));

    }

    public void onDelete(View v) {
        TextView brandTextView = (TextView) v.findViewById(R.id.brandName);
        TextView modelTextView = (TextView) v.findViewById(R.id.modelName);
        for(int i=0; i > brandList.size();i++){
            if(brandTextView.getText().toString().equals(brandList.get(i))){
                if(modelTextView.getText().toString().equals(modelList.get(i))){
                    brandList.remove(i);
                    modelList.remove(i);
                }
            }
        }
        addedRecordsFilterLayout.removeView((View) v.getParent());
    }
}
