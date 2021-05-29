package com.nomura.frame;

import java.util.Arrays;

/**
 * Implements a frame for traditional scoring.
 */
public class TraditionalFrame implements Frame {

    public static final int MAX_NB_PIN = 10;

    public static final int MAX_NB_INPUT = 3;

    public static final int MIN_NB_INPUT = 2;

    private final int index;

    private int nbInput = 0;

    private int pinStanding = MAX_NB_PIN;

    private final int[] pinCounts = new int[MAX_NB_INPUT];

    private int previousFrameScore = 0;

    private final boolean isLast;

    private int score;


    public TraditionalFrame(final int index) {
        this.index = index;
        isLast = index + 1 == MAX_NB_FRAME;
    }

    @Override
    public boolean hasSpare() {
        return !hasStrike() && pinCounts[0] + pinCounts[1] == MAX_NB_PIN;
    }

    @Override
    public boolean hasStrike() {
        return pinCounts[0] == MAX_NB_PIN;
    }

    @Override
    public boolean isComplete() {
        return nbInput == getMaxInputNb();
    }

    @Override
    public boolean goNext() {
        // TODO - DC : Fix this, should not try to go next on last frame.
        return hasStrike() || nbInput == MIN_NB_INPUT;
    }

    @Override
    public int getMaxInputNb() {
        return hasStrike() || hasSpare() ? MAX_NB_INPUT : MIN_NB_INPUT;
    }

    @Override
    public void removePinCount(final int pinCount) {
        // TODO - DC : Should add input validation here.
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

    private void addToScore(final int pinCount){
        this.score += pinCount;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public int getPinStanding() {
        return pinStanding;
    }

    @Override
    public int getScore() {
        return score + previousFrameScore;
    }

    @Override
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
