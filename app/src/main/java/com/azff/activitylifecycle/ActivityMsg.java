package com.azff.activitylifecycle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lsx on 2016/7/22.
 */
public class ActivityMsg extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        //获取第一个活动页面中的
        String message = getIntent().getStringExtra(MainActivity.BOOKNAME_OF_CATEGORY_PHYSICAL);
        //通过单击按钮，在第二个活动页面中显示提示信息
        // Toast.makeText(ActivityMsg.this,message,Toast.LENGTH_LONG).show();

        //查找textView
        textView = (TextView)findViewById(R.id.activity_msg_edit_view);
        //文本框中输入文本，通过按钮将该文本显示在第二个活动页面中的textView中
        textView.setText(message);
    }
}
