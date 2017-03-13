package com.ostaszewski.damian.projekt1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button przycisk1, przycisk2, przycisk3, przycisk4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przycisk1 = (Button) findViewById(R.id.button1);
        przycisk2 = (Button) findViewById(R.id.button2);
        przycisk3 = (Button) findViewById(R.id.button3);
        przycisk4 = (Button) findViewById(R.id.button4);

        przycisk1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Black.class);
                startActivity(i);
            }

        });

        przycisk2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Blue.class);
                startActivity(i);
            }

        });

        przycisk3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Red.class);
                startActivity(i);
            }

        });

        przycisk4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Yellow.class);
                startActivity(i);
            }

        });
    }
}