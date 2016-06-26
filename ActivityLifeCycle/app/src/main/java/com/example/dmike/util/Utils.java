package com.example.dmike.util;

import android.os.Handler;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dmike on 25/06/16.
 * @author dmike
 */
public class Utils {

    public static void printStatus(final TextView viewMethods, final TextView viewStatus){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               StringBuilder sbMethods = new StringBuilder();
                List<String> listMethods = mStatusTracker.getmMethodList();
                for(String method : listMethods){
                    sbMethods.insert(0,method + "\r\n");
                }
                if(viewMethods != null){
                    viewMethods.setText(sbMethods.toString());
                }

                StringBuilder sbStatus = new StringBuilder();
                for(String key: mStatusTracker.keySet()){
                    sbStatus.insert(0,key +": " + mStatusTracker.getStatus(key) + "\n");
                }
                if(viewStatus != null){
                    viewStatus.setText(sbStatus.toString());
                }
            }
        },750);
    }

    private static StatusTracker mStatusTracker = StatusTracker.getInstance();

}
