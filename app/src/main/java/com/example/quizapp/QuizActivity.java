package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";

    List<Question> questionList = new ArrayList<Question>();

    TextView questionTextView;
    RadioButton optionA, optionB, optionC, optionD;
    RadioGroup radioGroup;
    Button nextButton;

    int currentQuestionIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        _initQuestion();

        questionTextView = findViewById(R.id.textViewQuestion);
        optionA = findViewById(R.id.radioBTNAid);
        optionB = findViewById(R.id.radioBTNBid);
        optionC = findViewById(R.id.radioBTNCid);
        optionD = findViewById(R.id.radioBTNDid);

        radioGroup = findViewById(R.id.radioGroupID);

        nextButton = findViewById(R.id.btnNextId);

        _initViews();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.radioBTNAid:
                        questionList.get(currentQuestionIndex).selectedIndex = "A";
                        break;

                    case R.id.radioBTNBid:
                        questionList.get(currentQuestionIndex).selectedIndex = "B";
                        break;

                    case R.id.radioBTNCid:
                        questionList.get(currentQuestionIndex).selectedIndex = "C";
                        break;

                    case R.id.radioBTNDid:
                        questionList.get(currentQuestionIndex).selectedIndex = "D";
                        break;
                    default:
                        questionList.get(currentQuestionIndex).selectedIndex = "";
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuestionIndex++;
                if (currentQuestionIndex == questionList.size()) {
                    Log.i(TAG, "onClick: move to NextPage");

                    Intent intent = getIntent();
                    String name = intent.getStringExtra("name");
                    String id = intent.getStringExtra("id");

                    Intent resultIntent = new Intent(getApplicationContext(), ResultActivity.class);
                    resultIntent.putExtra("name", name);
                    resultIntent.putExtra("id", id);
                    resultIntent.putExtra("score", "correct " + _result() + " out of " + questionList.size());
                    Log.i(TAG, "onClick: " + name + id + " " + _result());
                    startActivity(resultIntent);

                } else {
                    if (currentQuestionIndex == questionList.size() - 1)
                        nextButton.setText("Finish");

                    _initViews();
                    radioGroup.clearCheck();
                }


            }
        });

    }

    int _result() {
        int correctAnswer = 0;
        for (Question q : questionList) {
            if (q.selectedIndex == q.answerIndex) correctAnswer++;
        }
        return correctAnswer;
    }

    void _initViews() {
        Question q = questionList.get(currentQuestionIndex);
        questionTextView.setText(q.question);
        optionA.setText(q.options.get(0));
        optionB.setText(q.options.get(1));
        optionC.setText(q.options.get(2));
        optionD.setText(q.options.get(3));
    }

    void _initQuestion() {
        ///question 1
        List<String> q1options = Arrays.asList(
                "When the list has only a few elements",
                "When performing a single search in an unordered list",
                "Used all the time",
                "When the list has only a few elements and When performing a single search in an unordered list"
        );
        questionList.add(new Question("Where is linear searching used?", q1options, "D"));


        //question 2
        List<String> q2options = Arrays.asList(
                "O(nlogn)",
                "O(logn)",
                "O(n)",
                "O(1)"
        );
        questionList.add(new Question("What is the best case for linear search?", q2options, "D"));

        //question 2
        List<String> q3options = Arrays.asList(
                "O(nlogn)",
                "O(logn)",
                "O(n)",
                "O(1)"
        );
        questionList.add(new Question("What is the worst case for linear search?", q3options, "C"));


        /// add rest of the question, must provide 4 options

    }

}