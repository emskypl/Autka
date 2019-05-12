package com.example.autka.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.autka.R;
import com.squareup.picasso.Picasso;

//TODO (2) Images viewing
public class SingleResultActivity extends AppCompatActivity {

    private static final String TAG = "SingleResultActivity";

    private ImageView image;
    private TextView created_at;
    private TextView url;
    private TextView price;
    private TextView brand;
    private TextView model;
    private TextView engine;
    private TextView hp;
    private TextView mileage;
    private TextView color;
    private TextView damaged;
    private TextView automated;
    private TextView fuel;
    private TextView countryFrom;
    private TextView region;
    private TextView city;
    private TextView description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_result);

        image = findViewById(R.id.image_single_result);
        created_at = findViewById(R.id.created_at_single_result);
        url = findViewById(R.id.url_single_result);
        price = findViewById(R.id.price_single_result);
        brand = findViewById(R.id.brand_single_result);
        model = findViewById(R.id.model_single_result);
        engine = findViewById(R.id.engine_single_result);
        hp = findViewById(R.id.hp_single_result);
        mileage = findViewById(R.id.mileage_single_result);
        color = findViewById(R.id.color_single_result);
        damaged = findViewById(R.id.damaged_single_result);
        automated = findViewById(R.id.automated_single_result);
        fuel = findViewById(R.id.fuel_single_result);
        countryFrom = findViewById(R.id.country_from_single_result);
        region = findViewById(R.id.region_single_result);
        city = findViewById(R.id.city_single_result);
        description = findViewById(R.id.description_single_result);
        init();
    }

    private void init() {
        Bundle extras = getIntent().getExtras();
        Picasso.get().load(extras.getString("image_url")).resize(300,200).into(image);
        created_at.setText(extras.getString("created_at"));
        url.setText(extras.getString("url"));
        price.setText(extras.getString("price"));
        brand.setText(extras.getString("brand"));
        model.setText(extras.getString("model"));
        engine.setText(extras.getString("engine"));
        hp.setText(String.valueOf(extras.getInt("hp")));
        mileage.setText(String.valueOf(extras.getInt("mileage")));
        color.setText(extras.getString("color"));
        if(extras.getBoolean("damaged")){
            damaged.setText("Tak");
        }else{
            damaged.setText("Nie");
        }
        if(extras.getBoolean("automated")){
            automated.setText("Tak");
        }else{
            automated.setText("Nie");
        }
        if(extras.getBoolean("fuel")){
            fuel.setText("Benzyna");
        }else{
            fuel.setText("Gas");
        }
        countryFrom.setText(extras.getString("country_from"));
        region.setText(extras.getString("region"));
        city.setText(extras.getString("city"));
        description.setText(extras.getString("description"));
        Log.d(TAG, "init: " + extras.toString());
        extras.clear();
    }
}