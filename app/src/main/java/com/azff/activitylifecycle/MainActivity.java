package com.azff.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate方法被执行了。");
        Button button = (Button) findViewById(R.id.avtivity_main_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityMsg.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart方法被执行了。");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume方法被执行了。");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: 被执行");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: 被执行了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 被执行了");
    }
}
