package com.example.autka.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.autka.R;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private static final String BASE_URL = "http://34.89.133.205/elasticsearch/auta/";
    private static final String ELASTIC_PASSWORD = "ALRE63oHnS34";

    private ArrayList<Car> mCars = new ArrayList<Car>();
    private String searchString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_search);
        FancyToast.makeText(getApplicationContext(), "Szukam...", FancyToast.LENGTH_LONG, FancyToast.INFO, false).show();
        getCarsFromServer();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addListElements();

            }
        }, 1000);
    }

    private void getCarsFromServer() {
        Bundle extras = getIntent().getExtras();

        /*
          GET by uri from elasticsearch
        */

        searchString = extras.getString("searchString");
        Log.d(TAG, "getCarsFromServer: search_string:" + searchString);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ElasticSearchApi searchAPI = retrofit.create(ElasticSearchApi.class);
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Authorization", Credentials.basic("user", ELASTIC_PASSWORD));
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
                        jsonRespone = response.errorBody().string();
                        Log.d(TAG, "onResponse: response failed" + jsonRespone);
                    }
                    Log.e(TAG, "onResponse: hits" + hitsList);

                    for (int i = 0; i < hitsList.getCarIndex().size(); i++) {
                        if(hitsList.getCarIndex().get(i).getCar().getBrand() != null){

                            Log.d(TAG, "onResponse: hit: " + hitsList.getCarIndex().get(i).getCar().toString());
                            mCars.add(hitsList.getCarIndex().get(i).getCar());
                        }
                    }
                    Log.d(TAG, "onResponse: size" + mCars.size());
                    FancyToast.makeText(getApplicationContext(), "Znaleziono " + mCars.size() + " ofert", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();

                } catch (NullPointerException e) {
                    Log.e(TAG, "onResponse: NullPointerException" + e.getMessage());
                } catch (IndexOutOfBoundsException e) {
                    Log.e(TAG, "onResponse: IndexOutOfBoundsException" + e.getMessage());
                } catch (IOException e) {
                    Log.e(TAG, "onResponse: IOException" + e.getMessage());
                }
            }
            @Override
            public void onFailure(Call<HitsObject> call, Throwable t) { }
        });
        Log.d(TAG, "onResponse: size after respone" + mCars.size());
        searchString = "";
    }


    private void addListElements() {
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        CustomAdapter customAdapter = new CustomAdapter();
        androidListView.setAdapter(customAdapter);

        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: item id" + id);
                Intent toSingleResult = new Intent(getApplicationContext(), SingleResultActivity.class);
                toSingleResult.putExtra("image_url", mCars.get(position).getImage_url());
                toSingleResult.putExtra("created_at", mCars.get(position).getCreated_at());
                toSingleResult.putExtra("url", mCars.get(position).getUrl());
                toSingleResult.putExtra("price", mCars.get(position).getPrice());
                toSingleResult.putExtra("brand", mCars.get(position).getBrand());
                toSingleResult.putExtra("model", mCars.get(position).getModel());
                toSingleResult.putExtra("engine", mCars.get(position).getEngine());
                toSingleResult.putExtra("hp", mCars.get(position).getHp());
                toSingleResult.putExtra("mileage", mCars.get(position).getMileage());
                toSingleResult.putExtra("color", mCars.get(position).getColor());
                toSingleResult.putExtra("damaged", mCars.get(position).getDamaged());
                toSingleResult.putExtra("automated", mCars.get(position).getAutomated());
                toSingleResult.putExtra("fuel", mCars.get(position).getFuel());
                toSingleResult.putExtra("country_from", mCars.get(position).getCountry_from());
                toSingleResult.putExtra("region", mCars.get(position).getRegion());
                toSingleResult.putExtra("city", mCars.get(position).getCity());
                toSingleResult.putExtra("description", mCars.get(position).getDescription());
                startActivity(toSingleResult);
            }
        });
    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mCars.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            try {
                view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.listview_record, null);
                TextView brandAndModel = (TextView) view.findViewById(R.id.listview_item_title);
                TextView price = (TextView) view.findViewById(R.id.listview_item_price);
                TextView year = (TextView) view.findViewById(R.id.listview_item_year);
                final ImageView imageView = (ImageView) view.findViewById(R.id.listview_item_image);
                ImageView serwisLogo = (ImageView) view.findViewById(R.id.serwislogo_item_image);
                brandAndModel.setText(mCars.get(i).getBrand() + " " + mCars.get(i).getModel());
                price.setText(mCars.get(i).getPrice().toString() + " zł");
                year.setText(mCars.get(i).getYear().toString());
                Picasso.get().load(mCars.get(i).getImage_url()).resize(300, 200).into(imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() { }

                    @Override
                    public void onError(Exception e) { imageView.setImageResource(R.drawable.audi_gt); }
                });
                boolean isAllegro = mCars.get(i).getUrl().contains("allegro");
                boolean isOtomoto = mCars.get(i).getUrl().contains("otomoto");

                if (isAllegro)
                {
                    Picasso.get().load(R.drawable.allegrologo).into(serwisLogo);
                }
                else if (isOtomoto)
                {
                    Picasso.get().load(R.drawable.otomoto_logotyp).into(serwisLogo);
                }
                else
                {
                    serwisLogo.setImageResource(R.drawable.androidicon);
                }
            } catch (Exception e) { }
            return view;
        }
    }
}
