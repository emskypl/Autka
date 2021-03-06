package com.example.autka.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.autka.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.elasticsearch.common.recycler.Recycler;

public class SingleResultActivity extends AppCompatActivity {

    private static final String TAG = "SingleResultActivity";

    private ImageView image;
    private ImageView image_bg;
    private TextView created_at;
    private TextView url;
    private TextView price;
    private TextView brand;
    private TextView model;
    private TextView engine;
    private TextView year;
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
    private ImageView serwisLogo;
    private Button backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_result);

        image = findViewById(R.id.image_single_result);
        image_bg = findViewById(R.id.image_single_result_bg);
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
        serwisLogo = findViewById(R.id.serwis_logo_single_result);
        backButton = (Button) findViewById(R.id.buton_back);
        year = findViewById(R.id.year_single_result);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        init();
    }

    private void init() {

        Bundle extras = getIntent().getExtras();
        try {
            Picasso.get().load(extras.getString("images")).resize(2000, 2000).onlyScaleDown().into(image, new com.squareup.picasso.Callback() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onError(Exception e) {

                }
            });
        } catch (Exception ex) {
            Log.d(TAG, ex.getMessage());
        }

        // krokodyl: zamiast rotate musi być blur
        try {
            Picasso.get().load(extras.getString("images")).transform(new BlurTransformation(this)).transform(new BlurTransformation(this)).fit().centerCrop().into(image_bg, new com.squareup.picasso.Callback() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onError(Exception e) {

                }
            });
        } catch (Exception ex) {
            Log.d(TAG, ex.getMessage());
        }

        url.setText(extras.getString("url"));
        if (!url.getText().toString().startsWith("http://") && !url.getText().toString().startsWith("https://"))
            url.setText("http://" + url);

        boolean isAllegro = url.getText().toString().contains("allegro");
        boolean isOtomoto = url.getText().toString().contains("otomoto");
        boolean isOlx = url.getText().toString().contains("olx");

        if (isAllegro) {
            Picasso.get().load(R.drawable.allegrologo).into(serwisLogo);
        }
        if (isOtomoto) {
            Picasso.get().load(R.drawable.otomoto_logotyp).into(serwisLogo);
        }
        if (isOlx) {
            Picasso.get().load(R.drawable.olxlogo).into(serwisLogo);
        }

        price.setText(extras.getString("price"));
        brand.setText(extras.getString("brand"));
        model.setText(extras.getString("model"));
        engine.setText(extras.getString("engine"));
        hp.setText(String.valueOf(extras.getInt("hp")));
        mileage.setText(String.valueOf(extras.getInt("mileage")));
        color.setText(extras.getString("color"));
        year.setText(extras.getString("year"));
        if (extras.getBoolean("damaged")) {
            damaged.setText("Tak");
        } else {
            damaged.setText("Nie");
        }
        if (extras.getBoolean("automated")) {
            automated.setText("Tak");
        } else {
            automated.setText("Nie");
        }
        if (extras.getString("fuel") == "0") {
            fuel.setText("Benzyna");
        } else if(extras.getString("fuel") == "1"){
            fuel.setText("Diesel");
        }else if(extras.getString("fuel") == "2"){
            fuel.setText("LPG");
        }
        countryFrom.setText(extras.getString("countryFrom"));
        region.setText(extras.getString("region"));
        city.setText(extras.getString("city"));
        description.setText(extras.getString("description"));
        Log.d(TAG, "init: " + extras.toString());
        extras.clear();

        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url.getText().toString()));
                startActivity(browserIntent);
            }
        });
    }

    public class BlurTransformation implements Transformation {

        RenderScript rs;

        public BlurTransformation(Context context) {
            super();
            rs = RenderScript.create(context);
        }

        @Override
        public Bitmap transform(Bitmap bitmap) {
            // Create another bitmap that will hold the results of the filter.
            Bitmap blurredBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);

            // Allocate memory for Renderscript to work with
            Allocation input = Allocation.createFromBitmap(rs, blurredBitmap, Allocation.MipmapControl.MIPMAP_FULL, Allocation.USAGE_SHARED);
            Allocation output = Allocation.createTyped(rs, input.getType());

            // Load up an instance of the specific script that we want to use.
            ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
            script.setInput(input);

            // Set the blur radius
            script.setRadius(25);

            // Start the ScriptIntrinisicBlur
            script.forEach(output);

            // Copy the output to the blurred bitmap
            output.copyTo(blurredBitmap);

            bitmap.recycle();

            return blurredBitmap;
        }
        @Override
        public String key() {
            return "blur";
        }
    }
}