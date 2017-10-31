package com.example.martin.mpip_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int GET_TEXT_REQUEST = 1;
    private static String CUSTOM_ACTION = "mk.ukim.finki.mpip.IMPLICIT_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicitIntent = new Intent(getApplicationContext(), ExplicitActivity.class);
                startActivityForResult(explicitIntent, GET_TEXT_REQUEST);
            }
        });

        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent implicitIntent = new Intent();
                implicitIntent.setAction(CUSTOM_ACTION);

                if (implicitIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(implicitIntent);
                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_TEXT_REQUEST && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                String resultText = extras.getString("resultText");
                TextView tv = (TextView) findViewById(R.id.text_view1);
                tv.setText(resultText);
            }
        }
    }
}
