package no.westerberg.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {
    private static final String TAG = "QuestionActivity";
    private static final String QINDEX = "qIndex";
    private int questionIndex;
    private TextView questionTextView;
    private CheckedTextView option1, option2, option3, option4;
    private Button buttonNext;

    protected void displayNextQuestion(Question[] questionBank, int ind) {

        questionTextView = (TextView) findViewById(R.id.questionTextView);
        questionTextView.setText(questionBank[ind].getQuestionText());
        option1 = (CheckedTextView) findViewById(R.id.option1);
        option2 = (CheckedTextView) findViewById(R.id.option2);
        option3 = (CheckedTextView) findViewById(R.id.option3);
        option4 = (CheckedTextView) findViewById(R.id.option4);
    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(QINDEX, questionIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        if (savedInstanceState != null) {
            questionIndex = savedInstanceState.getInt(QINDEX, 0);
        }
            Intent i = getIntent();
            Question[] questionBank = (Question[])i.getSerializableExtra("questionBank");
            displayNextQuestion(questionBank, questionIndex);




    }
}
