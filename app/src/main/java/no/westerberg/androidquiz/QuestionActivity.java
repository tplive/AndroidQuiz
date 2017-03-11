package no.westerberg.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {
    private static final String TAG = "QuestionActivity";
    private static final String QINDEX = "qIndex";
    private static final String PLAYER1 = "player1";
    private Player player1;
    private int questionIndex;
    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton option1, option2, option3, option4;

    protected void displayNextQuestion(Question[] questionBank, int ind, Player player1) {

        if (ind <= questionBank.length-1) {
            radioGroup = (RadioGroup) findViewById(R.id.optionRadioGroup);
            radioGroup.clearCheck();
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
        }else {
            loadSummaryPage();
        }
    }

    private void loadSummaryPage() {
        Intent i = new Intent(QuestionActivity.this, Summary.class);
        i.putExtra(PLAYER1, player1);
        i.putExtra(QINDEX, questionIndex);
        startActivity(i);
    }

    protected String getPlayerAnswer() {
        RadioGroup group = (RadioGroup) findViewById(R.id.optionRadioGroup);
        RadioButton playerAnswer = (RadioButton) findViewById(group.getCheckedRadioButtonId());
        if (group.getCheckedRadioButtonId() == -1) {
            return null;
        }else{
            return playerAnswer.getText().toString();
        }
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
        final Question[] questionBank = (Question[]) i.getSerializableExtra("questionBank");
        player1 = (Player) i.getSerializableExtra(PLAYER1);


        displayNextQuestion(questionBank, questionIndex, player1);

        final Button buttonNext = (Button) findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getPlayerAnswer() == null) {
                    Toast infoToast = Toast.makeText(getApplicationContext(), "Click an answer, please", Toast.LENGTH_SHORT);
                    infoToast.show();
                }else {
                    //TODO Make sure it doesn't crash if the player doesn't answer
                    String correctAnswer = questionBank[questionIndex].getCorrectText();

                    if (correctAnswer == getPlayerAnswer()) {
                        Toast infoToast = Toast.makeText(getApplicationContext(), "Correct, " + player1.getPlayerName(), Toast.LENGTH_SHORT);
                        infoToast.show();
                        player1.scorePoint();
                        questionIndex++;

                    } else {
                        Toast infoToast = Toast.makeText(getApplicationContext(), "Incorrect, " + player1.getPlayerName(), Toast.LENGTH_SHORT);
                        infoToast.show();
                        questionIndex++;
                    }
                    displayNextQuestion(questionBank, questionIndex, player1);
                }

            }
        });
    }





}
