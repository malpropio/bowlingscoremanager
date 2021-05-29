package com.nomura.frame;

/**
 * Represents a bowling frame.
 */
public interface Frame {

    int MAX_NB_FRAME = 10;

    /**
     * @return true if this frame has a spare, false otherwise.
     */
    boolean hasSpare();

    /**
     * @return true if this frame has a strike, false otherwise.
     */
    boolean hasStrike();

    /**
     * @return true if Frame has max nb of inputs, false otherwise.
     */
    boolean isComplete();

    /**
     *
     * @return
     */
    boolean goNext();

    /**
     *
     * @return
     */
    int getMaxInputNb();

    /**
     *
     * @param pinCount
     */
    void removePinCount(int pinCount);

    /**
     *
     * @param pinCount
     */
    void addToScore(int pinCount);

    /**
     *
     * @return
     */
    int getIndex();

    /**
     *
     * @return
     */
    int getPinStanding();

    /**
     *
     * @return
     */
    int getScore();

    /**
     *
     * @param previousFrameScore
     */
    void setPreviousFrameScore(int previousFrameScore);
}
