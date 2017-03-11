package no.westerberg.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    private Player player1;
    private static final String PLAYER1 = "player1";
    private static final String QINDEX = "qIndex";
    private static int questionIndex;

    protected void displayScore(int score, int total) {
        TextView scoreText = (TextView) findViewById(R.id.textViewScore);
        scoreText.setText(String.format("%s %s %s", score, getString(R.string._of_), total));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent i = getIntent();
        player1 = (Player) i.getSerializableExtra(PLAYER1);
        questionIndex = i.getIntExtra(QINDEX, 0);

        displayScore(player1.getScore(), questionIndex);
        displayDescription();
    }

    private void displayDescription() {
        TextView scoreDesc = (TextView) findViewById(R.id.textViewScoreDesc);
        scoreDesc.setText(getRating(player1.getScore(), questionIndex));
    }

    private String getRating(int score, int total) {
        String returnText;
        long quart = total/4;

        if (total / score < quart) {
            return "lowerQuart";
        }else if (total / score <= quart * 2) {
            return "secondQuart";
        }else if (total / score <= quart * 3) {
            return "thirdQuart";
        }else {
            return "fourthQuart";
        }

    }
}
