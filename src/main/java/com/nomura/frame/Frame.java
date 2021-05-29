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
     * @return true if we've hit the nb of tries for this frame or pinStanding == 0, false otherwise.
     */
    boolean goNext();

    /**
     * @return max nb of roll for this frame.
     */
    int getMaxInputNb();

    /**
     * @param pinCount roll count that be removed from standing ping count.
     */
    void removePinCount(int pinCount);

    /**
     * @return index if this frame in the order of frames.
     */
    int getIndex();

    /**
     * @return count of pin still standing.
     */
    int getPinStanding();

    /**
     * @return current score of the frame.
     */
    int getScore();

    /**
     * @param previousFrameScore score of the previous indexed frame.
     */
    void setPreviousFrameScore(int previousFrameScore);
}
