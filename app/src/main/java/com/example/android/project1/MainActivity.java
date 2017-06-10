package com.example.android.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jaswanth on 05/06/17.
 */

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE =
            "com.example.android.project1.extra.MESSAGE";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    String jaswanth = "jaswanth";


    private TextView mShowCount;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.w(LOG_TAG, "-------");
        Log.w(LOG_TAG, "onCreate");

        mMessageEditText = (EditText) findViewById(R.id.editText_main);
        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);


    }
    @Override
    public void onStart(){
        super.onStart();
        Log.w(LOG_TAG, "onStart");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.w(LOG_TAG, "onPause");
    }
    @Override
    public void onRestart(){
        super.onRestart();

        Log.w(LOG_TAG, "onrestart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.w(LOG_TAG, "onResume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.w(LOG_TAG, "onStop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.w(LOG_TAG, "onDestroy");
    }
    public void sendActivity(View view) {
        Intent intent = new Intent(this, second_activity.class);


        String message = mMessageEditText.getText().toString();

            intent.putExtra(EXTRA_MESSAGE, message);

            startActivityForResult(intent, TEXT_REQUEST);



    }

    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(second_activity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}

