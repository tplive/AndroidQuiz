package no.westerberg.androidquiz;

import java.io.Serializable;

/**
 * Created by Eline on 18.02.2017.
 */

public class Question implements Serializable {
    private String questionText;
    private String option1, option2, option3, option4;
    private int correct;



    public Question(String questionText, String option1, String option2, String option3, String option4, int correct) {
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correct = correct;

    }


    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOption1() {
        return option1;
    }


    public String getOption2() {
        return option2;
    }


    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public int getCorrect() {
        return correct;
    }

    public boolean checkAnswer(int answer) {
        if (answer = this.correct) {
            return true;
        }else{
            return false;
        }
    }

}

