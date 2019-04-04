package com.example.autka.view;
import android.database.DataSetObserver;
import android.graphics.drawable.GradientDrawable;
import android.print.PrintAttributes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Brands;
import model.Models;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    Spinner brandSpinner, modelSpinner;
    Button addRecordButton;
    LinearLayout addedRecordsLayout;

    ArrayList<String> brandsList, modelsList;
    ArrayAdapter<String> brandAdapter, modelsAdapter;

    Brands brands;
    Models models;

    public int x = 50;
    Map<String,String> addedFilterMap;

    public static <K,V> K getKey(Map<K,V> map, V value){
        for(Map.Entry<K,V> entry : map.entrySet()) {
            if(value.equals(entry.getValue())) {
                return entry.getKey();
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
        addedRecordsLayout = (LinearLayout) findViewById(R.id.addedRecordsLayout);

        brands = new Brands();
        models = new Models();
        brandsList = new ArrayList<>();
        modelsList = new ArrayList<>();
        addedFilterMap = new HashMap<String, String>();

        brands.brandsToArray(brandsList);
        brandAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, brands.getBrandsList());
        brandSpinner.setAdapter(brandAdapter);


        brandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                models.getMarks(brandSpinner.getSelectedItem().toString(),modelsList);
                modelsAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.support_simple_spinner_dropdown_item,models.getModelsList());
                modelSpinner.setAdapter(modelsAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        addRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addedFilterMap.size() >= 5){
                    Toast.makeText(v.getContext(),"Maksymalna liczba filtrów to " + addedFilterMap.size(),LENGTH_LONG).show();
                    return;
                }else {
                    addedFilterMap.put(brandSpinner.getSelectedItem().toString(),modelSpinner.getSelectedItem().toString());
                }


                        TextView addedRecordBrandTextView = new TextView(v.getContext());
                        TextView addedRecordModelTextView = new TextView(v.getContext());
                        LinearLayout addedRecordNewLayout = new LinearLayout(v.getContext());
                        LinearLayout.LayoutParams addedRecordLayoutParams = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.HORIZONTAL
                        );

                        addedRecordLayoutParams.setMargins(0, 150 + x, 0, 0);
                        x = x + 50;
                        addedRecordNewLayout.setLayoutParams(addedRecordLayoutParams);


                        addedRecordBrandTextView.setText(getKey(addedFilterMap, "5"));
                        addedRecordModelTextView.setText(addedFilterMap.get("BMW"));

                        addedRecordNewLayout.addView(addedRecordBrandTextView);
                        addedRecordNewLayout.addView(addedRecordModelTextView);

                        addedRecordsLayout.addView(addedRecordNewLayout);


            }
        });

    }
}
