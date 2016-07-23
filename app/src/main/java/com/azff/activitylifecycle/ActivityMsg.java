package com.azff.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by lsx on 2016/7/22.
 */
public class ActivityMsg extends AppCompatActivity {
    private TextView mTextView;
    private EditText mEditText;
    private Button mSendBackButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        //获取第一个活动页面中的
        final String message = getIntent().getStringExtra(MainActivity.BOOKNAME_OF_CATEGORY_PHYSICAL);
        //通过单击按钮，在第二个活动页面中显示提示信息
        // Toast.makeText(ActivityMsg.this,message,Toast.LENGTH_LONG).show();

        //查找textView
        mTextView = (TextView)findViewById(R.id.activity_msg_edit_view);
        //文本框中输入文本，通过按钮将该文本显示在第二个活动页面中的textView中
        mTextView.setText(message);

        //查找editText
        mEditText = (EditText)findViewById(R.id.activity_msg_edit_text);

        //查找button
        mSendBackButton = (Button)findViewById(R.id.activity_msg_send_back_button);
        mSendBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取文本框中输入的内容
                String name = mEditText.getText().toString();
                //创建intent，往上一个活动MainActivity传数据
                Intent intent = new Intent();
                //将name打包在一个名为back的字符串中传递
                intent.putExtra("back", name);
                //设置当前传递的
                setResult(RESULT_OK,intent);
                //结束当前activity，使得MainActivity显示出来
                finish();
            }
        });

    }
}
