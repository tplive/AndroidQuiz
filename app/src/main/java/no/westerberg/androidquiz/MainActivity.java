package no.westerberg.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String PLAYER1 = "player1";
    Player player1 = new Player();

    private Button startButton;

    //TODO Get questions from json
    Question[] questionBank = new Question[] {
            new Question("Hva er kodenavnet på Android 5.0?", "Cupcake", "Honeycomb", "Lollipop", "Nougat", 3),
            new Question("Hvem utviklet opprinnelig Android operativsystemet?", "Google", "Apple", "Microsoft", "Android Inc", 4),
            new Question("Hvilket år ble Jelly Bean lansert?", "2012", "2002", "2009", "2011", 1),
            new Question("Hvem av disse var ikke med på grunnleggingen av Android Inc?", "Andy Rubin", "Chris White", "Rich Miner", "Bill Gates", 4)
            new Question("En av disse leverandørene bruker Android som sitt operativsystem. Hvilken?", "Apple", "Samsung", "Microsoft", "Nokia", 2)

    };

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putSerializable(PLAYER1, player1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        onSaveInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            player1.setPlayerName(savedInstanceState.getString("player1name", ""));
            player1.setPlayerEmail(savedInstanceState.getString("player1email", ""));

            TextView tvPlayerName = (TextView) findViewById(R.id.playerName);
            tvPlayerName.setText(player1.getPlayerName());
            TextView tvPlayerEmail = (TextView) findViewById(R.id.playerEmail);
            tvPlayerEmail.setText(player1.getPlayerEmail());

        }

        // Kode som definerer onClick metode for startknappen.
        // Leser UI og setter spillerens navn / epost hvis hen har skrevet det inn,
        // default ellers. Launcher deretter QuestionActivity.
        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                TextView tvPlayerName = (TextView) findViewById(R.id.playerName);
                if (!tvPlayerName.getText().toString().equals("")) {
                    player1.setPlayerName(tvPlayerName.getText().toString());
                }else{
                    player1.setPlayerName("player1");
                }

                TextView tvPlayerEmail = (TextView) findViewById(R.id.playerEmail);
                if(!tvPlayerEmail.getText().toString().equals("")) {
                    player1.setPlayerEmail(tvPlayerEmail.getText().toString());
                }else{
                    player1.setPlayerEmail("no email");
                }
                Intent i = new Intent(MainActivity.this, QuestionActivity.class);
                i.putExtra("questionBank", questionBank);
                i.putExtra(PLAYER1, player1);
                startActivity(i);

                finish();

            }
        });

        //questionBank[0].getQuestionText();

    }




}
