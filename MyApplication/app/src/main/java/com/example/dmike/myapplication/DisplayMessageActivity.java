package com.example.dmike.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView text_view = new TextView(this);
        text_view.setTextSize(40);
        text_view.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.display_layout);
        layout.addView(text_view);
    }
}
