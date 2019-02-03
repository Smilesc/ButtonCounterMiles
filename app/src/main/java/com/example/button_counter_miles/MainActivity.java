package com.example.button_counter_miles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button increment;
    private Button decrement;
//    private Button reset;
    private TextView counter;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        increment = this.findViewById(R.id.increment);
      decrement = this.findViewById(R.id.decrement);
//        this.reset = this.findViewById(R.id.reset);
        counter = this.findViewById(R.id.counter);

        count = 0;

        increment.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                counter.setText(String.format(Locale.US,"%d", count+=10));
                return true;
            }
        });

        decrement.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                counter.setText(String.format(Locale.US,"%d", count-=10));
                return true;
            }
        });

    }

    public void incrementOnClick(View view){
        counter.setText(String.format(Locale.US,"%d", ++count));
    }

    public void decrementOnClick(View view){
        counter.setText(String.format(Locale.US,"%d", --count));
    }

    public void resetOnClick(View view){
        count = 0;
        counter.setText(String.format(Locale.US,"%d", count));
    }
}
