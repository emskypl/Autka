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
    private ImageButton clearButton;

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
        max_engine_filter = (EditText) findViewById(R.id.max_engine_filter);
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
        clearButton = (ImageButton) findViewById(R.id.clearButton);
        //layout elements
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
                ArrayAdapter<String> modelsAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item);
                models.getMarks(brandSpinner.getSelectedItem().toString(), modelsAdapter);
                modelsAdapter = models.getModelsList();
                modelSpinner.setAdapter(modelsAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brandSpinner.setSelection(0);
                modelSpinner.setSelection(0);
                min_hp_filter.setText("");
                max_hp_filter.setText("");
                min_engine_filter.setText("");
                max_engine_filter.setText("");
                automated_filter.setChecked(false);
                damaged_filter.setChecked(false);
                fuel_filter.setChecked(false);
                diesel_filter.setChecked(false);
                gas_filter.setChecked(false);
                year_filter.setSelection(0);
                color_filter.setText("");
                region_filter.setText("");
                city_filter.setText("");
                country_from_filter.setText("");
                min_price_filter.setText("");
                max_price_filter.setText("");
                min_mileage_filter.setText("");
                max_mileage_filter.setText("");
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toResultOfSearch = new Intent(getApplicationContext(),ResultOfSearchActivity.class);
                toResultOfSearch.putExtra("brand", brandSpinner.getSelectedItem().toString());
                if(modelSpinner.getSelectedItem().toString() != "Wszystkie modele"){
                    toResultOfSearch.putExtra("model", modelSpinner.getSelectedItem().toString());
                }else{
                    toResultOfSearch.putExtra("model","");
                }
                toResultOfSearch.putExtra("minHp", min_hp_filter.getText().toString());
                toResultOfSearch.putExtra("maxHp", max_hp_filter.getText().toString());
                toResultOfSearch.putExtra("minEngine", min_engine_filter.getText().toString());
                toResultOfSearch.putExtra("maxEngine", max_engine_filter.getText().toString());
                if(automated_filter.isChecked()){
                    toResultOfSearch.putExtra("automated", "1");
                }else{
                    toResultOfSearch.putExtra("automated", "0");
                }
                if(damaged_filter.isChecked()){
                    toResultOfSearch.putExtra("damaged", "1");
                }else{
                    toResultOfSearch.putExtra("damaged", "0");
                }
                if(fuel_filter.isChecked()){
                    toResultOfSearch.putExtra("fuel", "0");
                }else if(diesel_filter.isChecked()){
                    toResultOfSearch.putExtra("fuel", "1");
                }else if(gas_filter.isChecked()) {
                    toResultOfSearch.putExtra("fuel", "2");
                }else if(fuel_filter.isChecked() && diesel_filter.isChecked() && gas_filter.isChecked()){
                    toResultOfSearch.putExtra("fuel", "");
                }else{
                    toResultOfSearch.putExtra("fuel", "");
                }

                if(year_filter.getSelectedItem().toString() != "Wszystkie roczniki"){
                    toResultOfSearch.putExtra("year", year_filter.getSelectedItem().toString());
                }
                toResultOfSearch.putExtra("country", color_filter.getText().toString());
                toResultOfSearch.putExtra("minMileage", min_mileage_filter.getText().toString());
                toResultOfSearch.putExtra("maxMileage", max_mileage_filter.getText().toString());

                toResultOfSearch.putExtra("color", color_filter.getText().toString());
                toResultOfSearch.putExtra("minPrice", min_price_filter.getText().toString());
                toResultOfSearch.putExtra("maxPrice", max_price_filter.getText().toString());
                toResultOfSearch.putExtra("region", region_filter.getText().toString());
                toResultOfSearch.putExtra("city", city_filter.getText().toString());
                startActivity(toResultOfSearch);
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
