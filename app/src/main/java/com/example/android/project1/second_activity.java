package com.example.android.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class second_activity extends AppCompatActivity {
    private static final String LOG_TAG =
            second_activity.class.getSimpleName();
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        mReply = (EditText) findViewById(R.id.editText_second);
        Intent intent = getIntent();
        String message =
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);
        

    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        Log.w(LOG_TAG, "End SecondActivity");
        finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.w(LOG_TAG, "onStart");
    }
    @Override
    public void onRestart() {
        super.onRestart();
        Log.w(LOG_TAG, "onRestart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.w(LOG_TAG, "onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.w(LOG_TAG, "onPause");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.w(LOG_TAG, "onStop");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w(LOG_TAG, "onDestroy");
    }

}
