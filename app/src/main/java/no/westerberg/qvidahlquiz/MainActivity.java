package no.westerberg.qvidahlquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

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
        new Question("Hvem av disse var ikke med på grunnleggingen av Android Inc?", "Andy Rubin", "Chris White", "Rich Miner", "Bill Gates", 4),
        new Question("En av disse leverandørene bruker Android som sitt mobil-operativsystem. Hvilken?", "Apple", "Samsung", "Microsoft", "Nokia", 2),
        new Question("Hva står DDMS for?", "Dalvik Memory Server", "Device Memory Server", "Dalvik Monitoring Services", "Dalvik Debug Monitor Services", 4),
        new Question("Hvordan kan man finne et Fragment i Android?", "FragmentManager.findFragmentByID()", "getContext.findFragmentByID()", "findFragmentByID()", "findByID()", 1),
        new Question("Hva er en \"Splash screen\" i Android?", "Initiell aktivitet for en applikasjon", "Initiell tjeneste for en applikasjon", "Initiell skjerm for en applikasjon", "Initiell metode for en applikasjon",  3),
        new Question("Hvilken tillatelse må man ha for å vise lokasjon i Android?", "GPRS tillatelse", "ACCESS_FINE og ACCESS_COARSE tillatelse", "Internett tillatelse", "WIFI tillatelse", 2),
        new Question("Hvilke størrelser støttes?", "Android støtter alle størrelser", "Android støtter ikke alle størrelser", "Android støtter small, normal, large og extra-large", "Størrelse defineres ikke i Android", 3)
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        // Hvis vi kommer fra Summary (har klikket "prøv igjen", vil vi ha med brukernavn og
        // epost som var skrevet inn fra før.
        // TODO Virker enklest å ta med player1-objektet, istedet for strings?
        Intent i = getIntent();
        player1.setPlayerName(i.getStringExtra("player1name"));
        player1.setPlayerEmail(i.getStringExtra("player1email"));

        TextView tvPlayerName = (TextView) findViewById(R.id.playerName);
        tvPlayerName.setText(player1.getPlayerName());
        TextView tvPlayerEmail = (TextView) findViewById(R.id.playerEmail);
        tvPlayerEmail.setText(player1.getPlayerEmail());

        // Stokker rekkefølgen på spørsmålene:
        Collections.shuffle(Arrays.asList(questionBank));

        // Kode som definerer onClick metode for startknappen.
        // Leser UI og setter spillerens navn / epost hvis hen har skrevet det inn,
        // default ellers. Launcher deretter QuestionActivity.
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sjekk om spilleren har tastet inn navn/epost, og bruk evt det.
                // Hvis ikke, sett player1/no email som standardverdier.
                TextView tvPlayerName = (TextView) findViewById(R.id.playerName);
                if (!tvPlayerName.getText().toString().equals("")) {
                    player1.setPlayerName(tvPlayerName.getText().toString());
                } else {
                    player1.setPlayerName("player1");
                }

                TextView tvPlayerEmail = (TextView) findViewById(R.id.playerEmail);
                if (!tvPlayerEmail.getText().toString().equals("")) {
                    player1.setPlayerEmail(tvPlayerEmail.getText().toString());
                } else {
                    player1.setPlayerEmail("no email");
                }
                //Ta med spørsmålene og player1 objektet til neste activity
                Intent i = new Intent(MainActivity.this, QuestionActivity.class);
                i.putExtra("questionBank", questionBank);
                i.putExtra(PLAYER1, player1);
                startActivity(i);

                finish();

            }
        });
    }

    // Test - ta vare på player1 i savedInstanceState
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putSerializable(PLAYER1, player1);
    }






}
