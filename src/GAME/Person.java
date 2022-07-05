package GAME;

import java.io.Serializable;

public class Person implements Serializable {


    private String nickk;
    private int SCORE;

    public Person(String nickk, int SCORE) {
        this.nickk = nickk;
        this.SCORE = SCORE;
    }


    @Override
    public String toString() {
        return "Nick: " + nickk + " Points: " + SCORE;

    }
}