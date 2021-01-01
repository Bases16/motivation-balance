package edu.arf4.motivationbalance.model.enums;

public enum Estimation {
    LIKE(+1),
    NEUTRAL(0),
    NOT_LIKE(-1);

    public final int score;

    Estimation(int score) {
        this.score = score;
    }
}
