package com.ostaszewski.damian.projekt1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST = 1;

    Button przycisk1, przycisk2, przycisk3, przycisk4;
    ImageButton b1;

    final static private int CAPTURE_IMAGE = 2;
    TextView tekst1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tekst1 = (TextView) findViewById(R.id.textView);

        b1 = (ImageButton) findViewById(R.id.imageButton);


        przycisk1 = (Button) findViewById(R.id.button1);
        przycisk2 = (Button) findViewById(R.id.button2);
        przycisk3 = (Button) findViewById(R.id.button3);
        przycisk4 = (Button) findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Yellow.class);
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
                tekst1.setTextColor(Color.parseColor("#FFEF8B07"));
            }

        });

        przycisk4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tekst1.setText("Kocham Jule");

            }

        });

        przycisk1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                File mediaDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Apteka");
                File imgFile = new File(mediaDir.getPath() + File.separator + "IMG_" + "RECEPTA_" + ".jpg");
                Uri photoURI = FileProvider.getUriForFile(MainActivity.this, BuildConfig.APPLICATION_ID + ".provider", getOutputMediaFile());
                Uri imgUri =Uri.fromFile(new File(imgFile.getAbsolutePath()));
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE );
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult( intent, CAPTURE_IMAGE);
                } else {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
                    startActivityForResult( intent, CAPTURE_IMAGE);
                }
            }
        });

    }

    private static File getOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Apteka");
        if (!mediaStorageDir.exists()) {
            mediaStorageDir.mkdir();
            if (!mediaStorageDir.mkdirs()) {
                Log.d("Apteka", "problem z utworzeniem katalogu");
                return null;
            }
        }
        // Create a media file name
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
//                .format(new Date());
        File mediaFile;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + "IMG_" + "RECEPTA_" + ".jpg");
        if (mediaFile.exists()) mediaFile.delete();
        Log.d("Zdjecie1234567 : ", mediaFile.toString() );
        return mediaFile;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE) {
            if (resultCode == RESULT_OK) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            } else if (resultCode == RESULT_CANCELED) {
                Log.d("Błąd", "Picture was not taken");
            } else {
                Log.d("Błąd", "Picture was not taken");
            }
        }
    }

}