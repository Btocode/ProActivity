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

        button1 = findViewById(R.id.btn1);
        spinner_list_items = getResources().getStringArray(R.array.spinneritems);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sample_view, R.id.tvs,spinner_list_items);
        spinner.setAdapter(adapter);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = spinner.getSelectedItem().toString();
                changeActivity(state);
            }
        });





    }
    public void changeActivity(String activity){
        Intent intent;

        if(activity.equals("Custom broadcast receiver")){
            intent = new Intent(this, CustomBroadcast.class);
            startActivity(intent);
        }
        else if(activity.equals("Wifi RTT state change receiver")){
            intent = new Intent(this, WifiRttReceiver.class);
            startActivity(intent);
        }
        else{
            intent = new Intent(this, SystemBatteryNotificationReceiver.class);
            startActivity(intent);
        }

    }
}