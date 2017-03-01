package se.quizmaniacs.Jdo;

import java.util.List;

/**
 * Created by LeoAsp on 2017-03-01.
 */

public class PlayerData {
    public boolean isReady;

    public int questionsAnswered;
    public int questionsAnsweredCorrectly;

    public List<Boolean> categoriesAnsweredCorrectly;


    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}