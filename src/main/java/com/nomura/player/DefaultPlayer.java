package com.nomura.player;

import com.nomura.frame.TraditionalFrame;
import com.nomura.frame.Frame;

import java.util.Arrays;

import static com.nomura.frame.Frame.MAX_NB_FRAME;

/**
 * Represents a bowling player.
 */
public class DefaultPlayer implements Player {

    private final String name;

    private final Frame[] scoringFrames = new Frame[MAX_NB_FRAME];

    private Frame lastFrame;

    public DefaultPlayer(String name) {
        this.name = name;
        for(int i = 0 ; i < MAX_NB_FRAME; i++) {
            scoringFrames[i] = new TraditionalFrame(i);
            lastFrame = scoringFrames[i];
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Frame getFrame(final int index) {
        return index < MAX_NB_FRAME && index >= 0 ? scoringFrames[index] : null;
    }

    @Override
    public boolean isGameComplete() {
        return lastFrame.isComplete();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name=" + name + '\'' +
                ", frames=" + Arrays.toString(scoringFrames) +
                '}';
    }
}
