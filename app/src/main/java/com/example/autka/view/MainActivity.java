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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.autka.R;

import android.view.LayoutInflater;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import controler.ElasticSearchApi;
import model.Car;
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

//TODO (4) Improve brand/model and create other filters


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "http://35.242.198.46//elasticsearch/posts/car/";
    private static final String ELASTIC_PASSWORD = "jMBN8LfUeZKo";

    private Spinner brandSpinner, modelSpinner;
    private Button addRecordButton;
    private LinearLayout addedRecordsFilterLayout;
    private EditText engine_filter;
    private Spinner year_filter;


    private Button searchButton;


    //elastic
    private Button get_elastic;
    private TextView elastic_text_view;
    private ArrayList<Car> mCars;


    private Integer recordCounter = 0;

    private Intent toSearchActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brandSpinner = (Spinner) findViewById(R.id.brandSpinner);
        modelSpinner = (Spinner) findViewById(R.id.modelSpinner);
        addRecordButton = (Button) findViewById(R.id.addRecordButton);
        addedRecordsFilterLayout = (LinearLayout) findViewById(R.id.addedFilterRecordsLayout);
        year_filter = (Spinner) findViewById(R.id.year_filter);

        searchButton = (Button) findViewById(R.id.searchButton);


        get_elastic = (Button) findViewById(R.id.get_from_elastic);
        elastic_text_view = (TextView) findViewById(R.id.elastic_text_view);

        CarsBrands brands = new CarsBrands();
        ArrayAdapter<String> brandsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item);

        brands.brandsToArray(brandsAdapter);
        brandsAdapter = brands.getBrandsList();
        brandSpinner.setAdapter(brandsAdapter);

        toSearchActivity = new Intent(getApplicationContext(),ResultOfSearchActivity.class);
        init();


    }

    private void init() {

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

        ArrayAdapter<String> year_filter_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item);
        year_filter_adapter.add("Rocznik (domyślnie wszystkie)");
        year_filter.setAdapter(year_filter_adapter);

        get_elastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCars = new ArrayList<Car>();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ElasticSearchApi searchAPI = retrofit.create(ElasticSearchApi.class);

                HashMap<String, String> headerMap = new HashMap<String, String>();
                headerMap.put("Authorization", Credentials.basic("user",ELASTIC_PASSWORD));

                String searchString = "brand:Audi";

                Call<HitsObject> call = searchAPI.search(headerMap, "AND", searchString);
                call.enqueue(new Callback<HitsObject>() {
                    @Override
                    public void onResponse(Call<HitsObject> call, Response<HitsObject> response) {
                        HitsList hitsList = new HitsList();
                        String jsonRespone = "";
                        try {
                            if (response.isSuccessful()) {
                                Log.d(TAG, "onResponse: response success");
                                hitsList = response.body().getHitsList();
                            } else {
                                Log.d(TAG, "onResponse: response failed");
                                jsonRespone = response.errorBody().string();
                            }

                            Log.e(TAG, "onResponse: hits" + hitsList);
                            for(int i = 0; i < hitsList.getCarIndex().size(); i++){
                                Log.d(TAG, "onResponse: data" + hitsList.getCarIndex().get(i).getCar().toString());
                                //if(mCars.get(i).getBrand() == null)
                                mCars.add(hitsList.getCarIndex().get(i).getCar());
                            }
                           // Log.d(TAG, mCars.get(0).getBrand() + " " + mCars.get(0).getModel());
                            Log.d(TAG, "onResponse: size"+ mCars.size());
                        }catch (NullPointerException e){
                            Log.e(TAG, "onResponse: NullPointerException" + e.getMessage());
                        }catch (IndexOutOfBoundsException e){
                            Log.e(TAG, "onResponse: IndexOutOfBoundsException" + e.getMessage());
                        }catch (IOException e){
                            Log.e(TAG, "onResponse: IOException" + e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<HitsObject> call, Throwable t) {

                    }
                });

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
