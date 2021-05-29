package com.nomura;

import java.util.Arrays;

import static com.nomura.Frame.MAX_NB_FRAME;

/**
 * Represents a bowling player.
 */
public class Player {

    private final String name;

    private final Frame[] scoringFrames = new Frame[MAX_NB_FRAME];

    private Frame lastFrame;

    public Player(String name) {
        this.name = name;
        for(int i = 0 ; i < MAX_NB_FRAME; i++) {
            scoringFrames[i] = new Frame(i);
            lastFrame = scoringFrames[i];
        }
    }

    public String getName() {
        return name;
    }

    public Frame getLastFrame() {
        return lastFrame;
    }

    /**
     * @param index index of the frame to return.
     * @return Frame at that index, null if index is more than MAX_NB_FRAME
     */
    public Frame getFrame(final int index) {
        return index < MAX_NB_FRAME && index >= 0 ? scoringFrames[index] : null;
    }

    public boolean isGameComplete() {
        return lastFrame.isComplete();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name=" + name + '\'' +
                ", scoringFrames=" + Arrays.toString(scoringFrames) +
                '}';
    }
}
