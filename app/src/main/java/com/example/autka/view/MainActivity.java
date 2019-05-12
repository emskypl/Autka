package com.example.autka.view;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.autka.R;
import com.shashank.sony.fancytoastlib.FancyToast;

import android.view.LayoutInflater;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.CarsBrands;
import model.CarsModels;
import model.HitsList;
import model.HitsObject;
import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.action.search.SearchType;
//import org.elasticsearch.index.query.QueryBuilder.*;

// TODO(1) Improve adding nad removing filters
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

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
    private Button addRecordButton;
    private LinearLayout addedRecordsFilterLayout;
    private Button searchButton;

    //elasticsearch
    String searchString = "";
    // TODO (Later) Rozwazyc zmiane struktury danych (kolekcji), moze Map?
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
        addRecordButton = (Button) findViewById(R.id.addRecordButton);
        addedRecordsFilterLayout = (LinearLayout) findViewById(R.id.addedFilterRecordsLayout);
        searchButton = (Button) findViewById(R.id.searchButton);

        //elasticsearch
        brandList = new ArrayList<>();
        modelList = new ArrayList<>();

        //spinner init


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

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toResultOfSearch = new Intent(getApplicationContext(),ResultOfSearchActivity.class);
                searchStringCreate();
                toResultOfSearch.putExtra("searchString", searchString);
                searchString = "";
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
        brands.brandsToArray(brandsAdapter);
        brandsAdapter = brands.getBrandsList();
        brandSpinner.setAdapter(brandsAdapter);
        //years
        ArrayAdapter<String> year_filter_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item);
        year_filter_adapter.add("Wszystkie roczniki");
        for(int i=Calendar.getInstance().get(Calendar.YEAR);i > 1901 ;i--){
            year_filter_adapter.add(Integer.toString(i));
        }
        year_filter.setAdapter(year_filter_adapter);
    }

    private void searchStringCreate(){
        //TODO (elastic) AND and OR in one query
        if(brandList.size()>0){
            for(String value : brandList){
                searchString = searchString + " brand:" + value;
                Log.d(TAG, "searchStringCreate: brand: "+value);
            }
        }
        if(modelList.size()>0){
            for(String value : modelList){
                searchString = searchString + " model:" + value;
                Log.d(TAG, "searchStringCreate: model: "+value);
            }
        }
        // TODO (elastic) range in price, engine, hp, mileage
        if(!min_price_filter.getText().toString().equals("")){
            Log.d(TAG, "searchStringCreate: min_price aft"+min_price_filter.getText());
            searchString = searchString + " price:" + min_price_filter.getText().toString();
        }
        if(!min_engine_filter.getText().toString().equals("")){
            searchString = searchString + " engine:" + min_engine_filter.getText().toString();
        }
        if(!min_hp_filter.getText().toString().equals("")){
            searchString = searchString + " hp:" + min_hp_filter.getText().toString();
        }
        if(!min_mileage_filter.getText().toString().equals("")){
            searchString = searchString + " mileage:" + min_mileage_filter.getText().toString();
        }
        if(!year_filter.getSelectedItem().toString().equals("Wszystkie roczniki")){
            searchString = searchString + " year:" + year_filter.getSelectedItem().toString();
        }
        if(!color_filter.getText().toString().equals("")){
            searchString = searchString + " color:" + color_filter.getText().toString();
        }
        if(damaged_filter.isChecked()){
            searchString = searchString + " damaged:true";
        }
        if(automated_filter.isChecked()){
            searchString = searchString + " automated:true";
        }
        //TODO (elastic) Change mapping in elastic search
        /*
        if(!fuel_filter.isChecked()){
            searchString = searchString + " fuel:false";
        }
        if(!diesel_filter.isChecked()){
            searchString = searchString + " diesel:false";
        }
        if(!gas_filter.isChecked()){
            searchString = searchString + " gas:false";
        }
        */
        if(!country_from_filter.getText().toString().equals("")){
            searchString = searchString + " country_from:" + country_from_filter.getText().toString();
        }
        if(!region_filter.getText().toString().equals("")){
            searchString = searchString + " region:" + region_filter.getText().toString();
        }
        if(!city_filter.getText().toString().equals("")){
            searchString = searchString + " city:" + city_filter.getText().toString();
        }
        Log.d(TAG, "searchStringCreate: searchString:" + searchString);
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
