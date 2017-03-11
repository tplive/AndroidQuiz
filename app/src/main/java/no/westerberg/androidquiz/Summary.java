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
        scoreText.setText(String.format("%s %s %s", score, getString(R.string._of_), total)); //TODO Viser ikke korrekt questionIndex
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
        scoreDesc.setText(String.format("Player: %s\nEmail: %s\n", player1.getPlayerName(), player1.getPlayerEmail()));
    }
}
