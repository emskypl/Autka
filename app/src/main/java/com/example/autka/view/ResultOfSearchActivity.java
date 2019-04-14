package com.example.autka.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autka.R;

public class ResultOfSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_search);
        Bundle extras = getIntent().getExtras();
        TextView test = (TextView) findViewById(R.id.test);
        TextView test1 = (TextView) findViewById(R.id.test1);
        Toast.makeText(this,extras.getString("brand1"),Toast.LENGTH_LONG).show();
        String text = "";
        String text1 = "";
        for(int i=1;i<=10;i++)
            try {
                if(!extras.getString("brand"+i).equals("null"))
                text += extras.getString("brand" + i) + "\n";
            }catch (NullPointerException e){}

        for(int i=1;i<=10;i++)
            try {
                if(!extras.getString("model"+i).equals("null"))
                    text1 += extras.getString("model" + i) + "\n";
            }catch (NullPointerException e){}

        test.setText(text);
        test1.setText(text1);

    }
}
