package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText nameEditText, idEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editTextName);
        idEditText = findViewById(R.id.editTextID);

    }

    public void startQuiz(View view) {

        //get name,id from editText with removing extra spaces
        String name = nameEditText.getText().toString().trim();
        String id = idEditText.getText().toString().trim();

        /// if we get any null/empty value we will show a toast to enter the data
        ///* and use `return` to avoid moving further
        if (name.isEmpty() && id.isEmpty()) {
            String toastMessage = "Please enter the name and Id";
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
            return;
        } else if (name.isEmpty()) {
            String toastMessage = "Please enter the name";
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
            return;
        } else if (id.isEmpty()) {
            String toastMessage = "Please enter the id";
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, QuizActivity.class);
        //lets pass our name and id to next activity and remember the keys
        intent.putExtra("name", name);
        intent.putExtra("id", id);

        startActivity(intent);
    }
}