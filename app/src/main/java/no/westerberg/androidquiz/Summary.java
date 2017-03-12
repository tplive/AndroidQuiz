package no.westerberg.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    private Player player1;
    private Button resetButton;
    private static final String PLAYER1 = "player1";
    private static final String QINDEX = "qIndex";
    private static int questionIndex;

    protected void displayScore(int score, int total) {
        TextView scoreText = (TextView) findViewById(R.id.textViewScore);
        scoreText.setText(String.format("%s %s %s", score, getString(R.string._of_), total));
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent i = getIntent();
        player1 = (Player) i.getSerializableExtra(PLAYER1);
        questionIndex = i.getIntExtra(QINDEX, 0);

        displayScore(player1.getScore(), questionIndex);
        displayDescription();

        resetButton = (Button)findViewById(R.id.buttonReset);
        resetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Summary.this, MainActivity.class);
                i.putExtra("player1name", player1.getPlayerName());
                i.putExtra("player1email", player1.getPlayerEmail());
                startActivity(i);

                finish();

            }
        });




    }




    private void displayDescription() {
        TextView scoreDesc = (TextView) findViewById(R.id.textViewScoreDesc);
        scoreDesc.setText(getRating(player1.getScore(), questionIndex));
    }

    private String getRating(int score, int total) {
        String returnText;
        long quart = total/4;

        if (score == total) {
            return "Genialt! Alt rett! Android-superstjerne!";
        }else if (score > quart * 3) {
            return "Helt i øvre skikt! Veldig bra jobba!";
        }else if (score >= quart * 2) {
            return "Se der ja, over middels!";
        }else if (score >= quart ) {
            return "Du må øve mer, du burde greie mer enn halvparten!";
        }else {
            return "Dette gikk ikke så bra, gjorde det vel?";
        }

    }
}
