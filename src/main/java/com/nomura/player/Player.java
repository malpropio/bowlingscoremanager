package com.nomura.player;

import com.nomura.frame.Frame;

/**
 * Represents a bowling player.
 */
public interface Player {

    /**
     * @return the player name.
     */
    String getName();

    /**
     * @param index index of the frame to return.
     * @return Frame at that index, null if index is more than MAX_NB_FRAME
     */
    Frame getFrame(int index);

    /**
     * @return true if we've scored all frames for the player.
     */
    boolean isGameComplete();
}
