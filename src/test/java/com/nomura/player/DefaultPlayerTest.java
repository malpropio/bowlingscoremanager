package com.nomura.player;

import com.nomura.frame.Frame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for {@link DefaultPlayer}.
 */
class DefaultPlayerTest {

    private static final String NAME = "DC";

    private DefaultPlayer underTest;

    @BeforeEach
    void setUp() {
        underTest = new DefaultPlayer(NAME);
    }

    @Test
    void getName() {
        // Given

        // When
        String playerName = underTest.getName();

        // Then
        assertEquals(NAME, playerName);
    }

    @Test
    void getFrame() {
        // Given
        int index = 0;

        // When
        Frame indexedFrame = underTest.getFrame(index);

        // Then
        assertEquals(index, indexedFrame.getIndex());
    }

    @Test
    void isGameCompleteFalse() {
        // Given

        // When

        // Then

    }
}