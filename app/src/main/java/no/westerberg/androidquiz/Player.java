package no.westerberg.androidquiz;

import java.io.Serializable;

/**
 * Created by Eline on 18.02.2017.
 */

public class Player implements Serializable {
    private int score;
    private String playerName;
    private String playerEmail;


    public Player() {
        this.score = 0;
    }

    public void scorePoint() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }
    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerEmail(String email) {
        this.playerEmail = email;
    }
}
