package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "ResultActivity";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.textViewResultID);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String id = intent.getStringExtra("id");
        String result = intent.getStringExtra("score");

        Log.i(TAG, "onCreate: " + name + id + result);

        textView.setText("Name: " + name + "\nID: " + id + "\n" + result);
    }
}