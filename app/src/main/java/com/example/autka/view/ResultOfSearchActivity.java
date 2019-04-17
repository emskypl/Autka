package com.example.autka.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autka.R;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.CarJSONModel;
import model.JSONGetter;
import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultOfSearchActivity extends AppCompatActivity {


    String basicAuth;
    JSONGetter query;
    private ArrayList<CarJSONModel> mCars;
    Button getCarButton;
    String[] listviewTitle = new String[]{};

    int[] listviewImage = new int[]{
            R.drawable.audi_gt, R.drawable.audi_rs_5, R.drawable.audi_gt, R.drawable.audi_rs_5,
            R.drawable.audi_gt, R.drawable.audi_gt, R.drawable.audi_gt, R.drawable.audi_gt,
    };

    String[] listviewShortDescription = new String[]{};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_search);

        Bundle extras = getIntent().getExtras();
        Integer recordCounter = extras.getInt("recordCounter");


        getCarButton = (Button) findViewById(R.id.getCarButton);

        basicAuth = Credentials.basic("elastic", "yA7unBngvF35ipXsoslFHR9I");
        final String httpsURL = "https://7e2430d11bc848f48cd8530f19193781.europe-west1.gcp.cloud.es.io:9243/cars/car/";

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < recordCounter; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", extras.getString("brand"+i));
            hm.put("listview_discription", extras.getString("model"+i));
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_record, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);


        getCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCars = new ArrayList<CarJSONModel>();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(httpsURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JSONGetter searchAPI = retrofit.create(JSONGetter.class);

                HashMap<String,String> headerMap = new HashMap<String, String>();
                headerMap.put("Authorization",basicAuth);

                String searchString = "brand";

                Call<CarJSONModel> call = searchAPI.search(headerMap, "AND", searchString + "*");
                call.enqueue(new Callback<CarJSONModel>() {
                    @Override
                    public void onResponse(Call<CarJSONModel> call, Response<CarJSONModel> response) {
                        CarJSONModel carJSONModel = new CarJSONModel();
                        String jsonRespone = "";
                        if(response.isSuccessful()){
                            Log.e("RESPONSE",response.message().toString());
                            //carJSONModel = response.body();
                            response.body();
                            String brand = response.body().getBrand();
                        } else
                        {
                            Log.e("RESPONE", "NIE polaczono");
                        }
                    }

                    @Override
                    public void onFailure(Call<CarJSONModel> call, Throwable t) {

                    }
                });


            }
        });



    }
}
