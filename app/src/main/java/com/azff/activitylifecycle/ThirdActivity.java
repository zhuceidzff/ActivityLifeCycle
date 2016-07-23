package com.azff.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
    private Button mThirdBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mThirdBackButton = (Button) findViewById(R.id.activity_third_back_button);
        mThirdBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("thirdBack","back to the MainActivity");
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }
}
