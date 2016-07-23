package com.azff.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    public static final String BOOKNAME_OF_CATEGORY_PHYSICAL = "bookName_of_category_physical";
    private Button mButton;
    private Button mThirdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate方法被执行了。");
        //查找button
        mButton = (Button) findViewById(R.id.avtivity_main_button);
        //链接文本框
        final EditText editText = (EditText) findViewById(R.id.activity_main_edit_text);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
           /* public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityMsg.class);
                startActivity(intent);
            }*/
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Button clicked",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,ActivityMsg.class);
                //将文本通过单击按钮传递到第二个活动页面，并显示提示信息
                //intent.putExtra("name","追加第二个活动页面的文字信息");
                //将文本框中的内容通过单击按钮获取并在第二个活动页面的显示提示
                intent.putExtra(BOOKNAME_OF_CATEGORY_PHYSICAL, editText.getText().toString());
                //直接跳转到下一个活动页面
                // startActivity(intent);
                //可以一次性完成这项任务，当程序执行到这段代码的时候，假若从T1Activity跳转到下一个Text2Activity，
                // 而当这个Text2Activity调用了finish()方法以后，程序会自动跳转回T1Activity，
                // 并调用前一个T1Activity中的onActivityResult( )方法。
                startActivityForResult(intent,0);
            }
        });

        //查找mThirdButton
        mThirdButton = (Button)findViewById(R.id.activity_main_third_button);
        mThirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent,1);
            }
        });


    }
    //

    //将activityMsg活动页面中文本框的输入结果返回，并在本活动中提示
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String name = "";
        //由requestCode决定返回的是哪一个活动页面的信息
        switch (requestCode){
            case 0:
                name = data.getStringExtra("back");
                break;
            case 1:
                name = data.getStringExtra("thirdBack");
                break;
        }

        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
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
