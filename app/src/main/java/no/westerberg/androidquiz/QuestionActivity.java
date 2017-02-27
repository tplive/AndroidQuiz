package no.westerberg.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {
    private static final String TAG = "QuestionActivity";
    private static final String QINDEX = "qIndex";
    private int questionIndex;
    private TextView questionTextView;
    private RadioButton option1, option2, option3, option4;
    private Button buttonNext;

    protected int displayNextQuestion(Question[] questionBank, int ind) {

        questionTextView = (TextView) findViewById(R.id.questionTextView);
        questionTextView.setText(questionBank[ind].getQuestionText());
        option1 = (RadioButton) findViewById(R.id.btnOption1);
        option1.setText(questionBank[ind].getOption1());
        option2 = (RadioButton) findViewById(R.id.btnOption2);
        option2.setText(questionBank[ind].getOption2());
        option3 = (RadioButton) findViewById(R.id.btnOption3);
        option3.setText(questionBank[ind].getOption3());
        option4 = (RadioButton) findViewById(R.id.btnOption4);
        option4.setText(questionBank[ind].getOption4());
        return questionBank[ind].getCorrect();
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
