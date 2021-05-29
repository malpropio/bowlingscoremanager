package com.nomura.frame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for @{@link TraditionalFrameTest}.
 */
class TraditionalFrameTest {

    private static final int CURRENT_INDEX = 1;

    private TraditionalFrame underTest;

    @BeforeEach
    void setUp() {
        underTest = new TraditionalFrame(CURRENT_INDEX);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void hasSpare() {
        // Given
        int firstPinCount = 2;
        int secondPinCount = 8;

        // When
        underTest.removePinCount(firstPinCount);
        underTest.removePinCount(secondPinCount);

        // Then
        assertTrue(underTest.hasSpare());
    }

    @Test
    void hashSpareFalseWithPinStandingMoreThanZero() {
        // Given
        int pinCount = 8;

        // When
        underTest.removePinCount(pinCount);

        // Then
        assertFalse(underTest.hasSpare());
    }

    @Test
    void hashSpareFalseWithStrike() {
        // Given
        int pinCount = TraditionalFrame.MAX_NB_PIN;

        // When
        underTest.removePinCount(pinCount);

        // Then
        assertFalse(underTest.hasSpare());
    }

    @Test
    void hasStrike() {
        // Given
        int pinCount = TraditionalFrame.MAX_NB_PIN;

        // When
        underTest.removePinCount(pinCount);

        // Then
        assertTrue(underTest.hasStrike());
    }

    @Test
    void hashStrikeFalse() {
       // Given
       int pinCount = 2;

       // When
        underTest.removePinCount(pinCount);

       // Then
        assertFalse(underTest.hasStrike());
    }

    @Test
    void isCompleteWith2RollNotSpare() {
        // Given
        int pinCount = 2;

        // When
        underTest.removePinCount(pinCount);
        underTest.removePinCount(pinCount);

        // Then
        assertTrue(underTest.isComplete());
    }

    @Test
    void isCompleteWithSpare() {
        // Given
        int firstPinCount = 2;
        int secondPinCount = 8;
        int thirdPinCount = 0;

        // When
        underTest.removePinCount(firstPinCount);
        underTest.removePinCount(secondPinCount);
        underTest.removePinCount(thirdPinCount);

        // Then
        assertTrue(underTest.isComplete());
    }

    @Test
    void isCompleteWithStrike() {
        // Given
        int firstPinCount = TraditionalFrame.MAX_NB_PIN;
        int secondPinCount = 8;
        int thirdPinCount = 0;

        // When
        underTest.removePinCount(firstPinCount);
        underTest.removePinCount(secondPinCount);
        underTest.removePinCount(thirdPinCount);

        // Then
        assertTrue(underTest.isComplete());
    }

    @Test
    void goNextWithStrike() {
        // Given
        int pinCount = TraditionalFrame.MAX_NB_PIN;

        // When
        underTest.removePinCount(pinCount);

        // Then
        assertTrue(underTest.goNext());
    }

    @Test
    void goNextWithSpare() {
        // Given
        int firstPinCount = 2;
        int secondPinCount = 8;

        // When
        underTest.removePinCount(firstPinCount);
        underTest.removePinCount(secondPinCount);

        // Then
        assertTrue(underTest.goNext());
    }

    @Test
    void goNextWithMaxNbOfInput() {
        // Given

        // When

        // Then
    }



    @Test
    void getMaxInputNb() {
        // Given

        // When

        // Then
    }

    @Test
    void removePinCount() {
        // Given

        // When

        // Then
    }

    @Test
    void addToScore() {
        // Given

        // When

        // Then
    }

    @Test
    void getIndex() {
        // Given

        // When
        int frameIndex = underTest.getIndex();

        // Then
        assertEquals(CURRENT_INDEX, frameIndex);
    }

    @Test
    void getPinStanding() {
        // Given

        // When

        // Then
    }

    @Test
    void getScore() {
        // Given

        // When

        // Then
    }

    @Test
    void setPreviousFrameScore() {
        // Given

        // When

        // Then
    }
}