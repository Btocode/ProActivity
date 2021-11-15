package com.afsan.proactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
    private Button button1;
    String[] spinner_list_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn);

        spinner_list_items = getResources().getStringArray(R.array.spinneritems);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sample_view, R.id.tvs,spinner_list_items);
        spinner.setAdapter(adapter);
        button1.setOnClickListener(v -> changeActivity("act1"));
    }
    public void changeActivity(String activity){
        Intent intent1,intent2,intent3;

        if(activity.equals("act1")){
            intent1 = new Intent(this, Activity2.class);
            startActivity(intent1);
        }
    }
}