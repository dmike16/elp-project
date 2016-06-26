package com.example.dmike.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dmike.util.StatusTracker;
import com.example.dmike.util.Utils;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mActivityName = getString(R.string.activity_a);
        mStatusView = (TextView)findViewById(R.id.status_view_a);
        mStatusAllView = (TextView)findViewById(R.id.status_view_all_a);
        mStatusTacker.setStatus(mActivityName,getString(R.string.on_create));
        Utils.printStatus(mStatusView,mStatusAllView);
    }

    @Override
    protected void onStart(){
        super.onStart();
        mStatusTacker.setStatus(mActivityName, getString(R.string.on_start));
        Utils.printStatus(mStatusView,mStatusAllView);
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        mStatusTacker.setStatus(mActivityName, getString(R.string.on_restart));
        Utils.printStatus(mStatusView,mStatusAllView);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mStatusTacker.setStatus(mActivityName, getString(R.string.on_resume));
        Utils.printStatus(mStatusView,mStatusAllView);
    }

    @Override
    protected void onPause(){
        super.onPause();
        mStatusTacker.setStatus(mActivityName, getString(R.string.on_pause));
        Utils.printStatus(mStatusView,mStatusAllView);
    }

    @Override
    protected void onStop(){
        super.onStop();
        mStatusTacker.setStatus(mActivityName, getString(R.string.on_stop));
        Utils.printStatus(mStatusView,mStatusAllView);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mStatusTacker.setStatus(mActivityName,getString(R.string.on_destroy));
        mStatusTacker.clear();
    }

    public void startDialog(View v){
        Intent intent = new Intent(ActivityA.this,Dialog.class);
        startActivity(intent);
    }

    public void startActivityB(View v){
        Intent intent = new Intent(ActivityA.this,ActivityB.class);
        startActivity(intent);
    }

    public void startActivityC(View v){
        Intent intent = new Intent(ActivityA.this,ActivityC.class);
        startActivity(intent);
    }

    public void finischActivityA(View v){
        ActivityA.this.finish();
    }

    private String mActivityName;
    private TextView mStatusView;
    private TextView mStatusAllView;
    private StatusTracker mStatusTacker = StatusTracker.getInstance();
}
