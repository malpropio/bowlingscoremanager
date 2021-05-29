package com.nomura;

import java.util.Arrays;

/**
 * Represents a bowling frame.
 */
public class Frame {

    public static final int MAX_NB_PIN = 10;

    public static final int MAX_NB_FRAME = 10;

    public static final int MAX_NB_INPUT = 3;

    public static final int MIN_NB_INPUT = 2;

    private final int index;

    private int nbInput = 0;

    private int pinStanding = MAX_NB_PIN;

    private final int[] pinCounts = new int[MAX_NB_INPUT];

    private int previousFrameScore = 0;

    private final boolean isLast;

    private int score;


    public Frame(final int index) {
        this.index = index;
        isLast = index + 1 == MAX_NB_FRAME;
    }

    /**
     * @return true if this frame has a spare, false otherwise.
     */
    boolean hasSpare() {
        return !hasStrike() && pinCounts[0] + pinCounts[1] == MAX_NB_PIN;
    }

    /**
     * @return true if this frame has a strike, false otherwise.
     */
    boolean hasStrike() {
        return pinCounts[0] == MAX_NB_PIN;
    }

    /**
     * @return true if Frame has max nb of inputs, false otherwise.
     */
    public boolean isComplete() {
        return nbInput == getMaxInputNb();
    }

    public boolean goNext() {
        return hasStrike() || nbInput == MIN_NB_INPUT;
    }

    public int getMaxInputNb() {
        return hasStrike() || hasSpare() ? MAX_NB_INPUT : MIN_NB_INPUT;
    }

    public void removePinCount(final int pinCount) {
        if(!isComplete()) {
            if(pinStanding > 0) {
                pinCounts[nbInput] = pinCount;
                pinStanding -= pinCount;
                replenishStandingPin();
            }
            addToScore(pinCount);
            nbInput++;
        }
    }

    private void replenishStandingPin() {
        if(isLast && (nbInput + 1) < getMaxInputNb() && (hasStrike()|| hasSpare())) {
            pinStanding = MAX_NB_PIN;
        }
    }

    public void addToScore(final int pinCount){
        this.score += pinCount;
    }

    public int getIndex() {
        return index;
    }

    public int getPinStanding() {
        return pinStanding;
    }

    public int getScore() {
        return score + previousFrameScore;
    }

    public void setPreviousFrameScore(final int previousFrameScore) {
        this.previousFrameScore = previousFrameScore;
    }

    @Override
    public String toString() {
        return "Frame_" + index +
                "[ nbInput=" + nbInput +
                ", pinStanding=" + pinStanding +
                ", pinCounts=" + Arrays.toString(pinCounts) +
                ", score=" + getScore() +
                ", nextFrame=" + goNext() +
                ", complete=" + isComplete() +
                ']';
    }
}
