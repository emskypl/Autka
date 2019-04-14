package com.example.autka.view;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.drawable.GradientDrawable;
import android.opengl.Visibility;
import android.print.PrintAttributes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autka.R;

import android.view.LayoutInflater;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Brands;
import model.Models;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    Brands brands;
    Models models;

    Spinner brandSpinner, modelSpinner;
    ArrayAdapter<String> brandsAdapter, modelsAdapter;



    Button addRecordButton;
    Button searchButton;
    LinearLayout addedRecordsFilterLayout;






    Map<String,String> addedFilterMap;
    public static String textToModelsView = "";

    Intent toSearch;

    public static <K,V> V getValuesByKey(Map<K,V> map,K key){
        for(Map.Entry<K,V> entry : map.entrySet()) {
            if(key.equals(entry.getKey()))
                textToModelsView += entry.getValue();
            }
        return null;
    }

    public static <K,V> V getMapValue(Map<K,V> map, V value, K key){
        for(Map.Entry<K,V> entry : map.entrySet()) {
            if(value.equals(entry.getValue()) && key.equals(entry.getKey())){
                return value;
            }
        }
        return null;
    }


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

        addedFilterMap = new HashMap<String, String>();
        toSearch = new Intent(getApplicationContext(),ResultOfSearchActivity.class);

        brandsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item);
        modelsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item);

        final TextView[] brandName = new TextView[1];
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


        addRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddField(v);
                //TODO (1) Correct adding values to TextViews
                brandName[addedRecordsFilterLayout.getChildCount()] = (TextView) findViewById(R.id.brandName);
                brandName[addedRecordsFilterLayout.getChildCount()].setText(brandSpinner.getSelectedItem().toString());
            }
        });

    }
    public void onAddField(View v){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        addedRecordsFilterLayout.addView(rowView, addedRecordsFilterLayout.getChildCount() - 1);
    }
    public void onDelete(View v) {
        addedRecordsFilterLayout.removeView((View) v.getParent());
    }
}
