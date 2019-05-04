package com.example.autka.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.autka.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Credentials;

public class ResultOfSearchActivity extends AppCompatActivity {

//TODO (5) Side menu or overflow menu and improve showing each item in ListView
    String basicAuth = Credentials.basic("elastic", "yA7unBngvF35ipXsoslFHR9I");
    String httpsURL = "https://7e2430d11bc848f48cd8530f19193781.europe-west1.gcp.cloud.es.io:9243/cars/car/";
    ListView androidListView;

    int[] listviewImage = new int[]{
            R.drawable.audi_gt, R.drawable.audi_rs_5, R.drawable.toyota_corolla, R.drawable.bmw_7,
            R.drawable.audi_gt, R.drawable.audi_rs_5, R.drawable.toyota_corolla, R.drawable.bmw_7
    };

    int [] serwislogoImage = new int[]{
            R.drawable.allegrologo, R.drawable.otomoto_logotyp,R.drawable.allegrologo, R.drawable.otomoto_logotyp,
            R.drawable.allegrologo, R.drawable.otomoto_logotyp,R.drawable.allegrologo, R.drawable.otomoto_logotyp
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_search);
        addListElements();


    }



    private void addListElements() {
        androidListView = (ListView) findViewById(R.id.list_view);
        Bundle extras = getIntent().getExtras();
        Integer recordCounter = extras.getInt("recordCounter");

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < recordCounter; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", extras.getString("brand"+i));
            hm.put("listview_discription", extras.getString("model"+i));
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            hm.put("serwislogo_image", Integer.toString(serwislogoImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription", "serwislogo_image"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description, R.id.serwislogo_image};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_record, from, to);

        androidListView.setAdapter(simpleAdapter);

        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Działa klik","TAK");
            }
        });
    }
}
