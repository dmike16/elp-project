package com.example.dmike.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.dmike.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        //TODO
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText edit_text = (EditText)findViewById(R.id.edit_message);
        String message  = edit_text.getText().toString();
        intent.putExtra(MainActivity.EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}