package no.westerberg.androidquiz;

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
    }
}
