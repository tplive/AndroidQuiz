package no.westerberg.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Player player1 = new Player();
    private Button startButton;

    Question[] questionBank = new Question[] {
            new Question("Hva er kodenavnet på Android 5.0?", "Cupcake", "Honeycomb", "Lollipop", "Nougat", 3),
            new Question("Hvem utviklet opprinnelig Android operativsystemet?", "Google", "Apple", "Microsoft", "Android Inc", 4),
            new Question("Hvilket år ble Jelly Bean lansert?", "2012", "2002", "2009", "2011", 1),
            new Question("Hvem av disse var ikke med på grunnleggingen av Android Inc?", "Andy Rubin", "Chris White", "Rich Miner", "Eline Westerberg", 4)

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QuestionActivity.class);
                i.putExtra("questionBank", questionBank);
                i.putExtra("player1", player1);
                startActivity(i);

                finish();

            }
        });

        questionBank[0].getQuestionText();

    }




}
