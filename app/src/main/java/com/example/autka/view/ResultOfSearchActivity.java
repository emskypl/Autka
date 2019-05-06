package com.example.autka.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.autka.R;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controler.ElasticSearchApi;
import model.Car;
import model.HitsList;
import model.HitsObject;
import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultOfSearchActivity extends AppCompatActivity {

    private static final String TAG = "ResultOfSearchActivity";
    private static final String BASE_URL = "http://35.242.198.46//elasticsearch/posts/car/";
    private static final String ELASTIC_PASSWORD = "jMBN8LfUeZKo";

    // TODO (1) Correct showing results (working but need sync, not async), improve single element design

    int[] listviewImage = new int[]{R.drawable.audi_gt, R.drawable.audi_rs_5};
    int [] serwislogoImage = new int[]{R.drawable.allegrologo, R.drawable.otomoto_logotyp};

    private ArrayList<Car> mCars = new ArrayList<Car>();;
    private String searchString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_search);
        FancyToast.makeText(getApplicationContext(),"Szukam...", FancyToast.LENGTH_LONG,FancyToast.INFO,false).show();

        getCarsFromServer();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addListElements();
            }
        },1000);


    }

    private void getCarsFromServer(){
        Bundle extras = getIntent().getExtras();
        searchString = extras.getString("searchString");
        Log.d(TAG, "getCarsFromServer: search_string:" + searchString);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ElasticSearchApi searchAPI = retrofit.create(ElasticSearchApi.class);

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Authorization", Credentials.basic("user",ELASTIC_PASSWORD));
        Call<HitsObject> call = searchAPI.search(headerMap, "OR", searchString);

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
                        Log.d(TAG, "onResponse: hit: " + hitsList.getCarIndex().get(i).getCar().toString());
                        mCars.add(hitsList.getCarIndex().get(i).getCar());
                    }
                    Log.d(TAG, "onResponse: size"+ mCars.size());
                    FancyToast.makeText(getApplicationContext(),"Znaleziono " + mCars.size() + " ofert", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
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
        Log.d(TAG, "onResponse: size after respone"+ mCars.size());
        searchString = "";
    }


    private void addListElements() {

        ListView androidListView = (ListView) findViewById(R.id.list_view);
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        Log.d(TAG, "addListElements: mCars size:" + mCars.size());

        for (int i = 0; i < mCars.size(); i++) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("listview_title", mCars.get(i).getBrand() + " " + mCars.get(i).getModel());
            hashMap.put("listview_discription", mCars.get(i).getPrice().toString());
            hashMap.put("listview_image", Integer.toString(listviewImage[1]));
            hashMap.put("serwislogo_image", Integer.toString(serwislogoImage[1]));
            aList.add(hashMap);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription", "serwislogo_image"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description, R.id.serwislogo_image};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_record, from, to);
        androidListView.setAdapter(simpleAdapter);
        Log.d(TAG, "addListElements: Records added");
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: item id" + id);
                Intent toSingleResult = new Intent(getApplicationContext(),SingleResultActivity.class);
                startActivity(toSingleResult);
            }
        });
    }
}
