package com.ostaszewski.damian.projekt1;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by student on 07.03.2017.
 */

public class Yellow extends AppCompatActivity {

    Button b2;

    TextView tekst2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yellow);

        b2 = (Button) findViewById(R.id.button5);
        tekst2 = (TextView) findViewById(R.id.textView2);

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tekst2.setText("PRZEGRANA!! .I.");
                tekst2.setTextColor(Color.parseColor("#FFFF0004"));
                tekst2.setTextSize(getResources().getDimension(R.dimen.dfghj));
                tekst2.setTypeface(tekst2.getTypeface(), Typeface.ITALIC);

            }


    });
}
}