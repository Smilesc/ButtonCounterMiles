package com.example.button_counter_miles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView counter;
    public static int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button increment = this.findViewById(R.id.increment);
        Button decrement = this.findViewById(R.id.decrement);
        Button reset = this.findViewById(R.id.reset);
        counter = this.findViewById(R.id.counter);

        Bundle storedData = getIntent().getExtras();

        if (storedData != null) {
            count = storedData.getInt("com.example.button_counter_miles.count");
        } else {
            count = 0;
        }

        counter.setText(String.format(Locale.US, "%d", count));

        //Increment 1
        increment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter.setText(String.format(Locale.US, "%d", ++count));
            }
        });

        //Increment 10
        increment.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                counter.setText(String.format(Locale.US, "%d", count += 10));
                return true;
            }
        });


        //Decrement 1
        decrement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter.setText(String.format(Locale.US, "%d", --count));
            }
        });

        //Decrement 10
        decrement.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                counter.setText(String.format(Locale.US, "%d", count -= 10));
                return true;
            }
        });


        //Reset
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count = 0;
                counter.setText(String.format(Locale.US, "%d", count));
            }
        });
    }

    protected void onDestroy() {

        super.onDestroy();

        Intent passData = new Intent(this, MainActivity.class);
        passData.putExtra("com.example.button_counter_miles.count", count);
        startActivity(passData);
    }
}