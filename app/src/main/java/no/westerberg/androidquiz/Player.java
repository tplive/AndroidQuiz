package no.westerberg.androidquiz;

/**
 * Created by Eline on 18.02.2017.
 */

public class Player {
    private int score;


    public Player() {
        this.score = 0;
    }

    public void scorePoint() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }
}
