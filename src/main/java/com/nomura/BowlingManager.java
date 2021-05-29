package com.nomura;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class BowlingManager {

    private static final Logger LOG = LogManager.getLogger(BowlingManager.class);

    private static final int INVALID_NB_INPUT = -1;

    private static final BufferedReader INPUT_READER = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        String playerName = null;
        do {
            try {
                playerName = readString("Enter your username: ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(playerName == null || Strings.isBlank(playerName));

        Player player = new Player(playerName);
        LOG.info("Starting bowling session for : {}", playerName);

        int trailingIndex = 0, currentIndex = 0;
        do {
            Frame currentFrame = player.getFrame(currentIndex);
            Frame trailingFrame = player.getFrame(trailingIndex);
            int nbPins = readInt("Input your roll between 0 and " + currentFrame.getPinStanding());
            if(validate(currentFrame, nbPins)) {
                for(int i = trailingIndex ; i <= currentIndex ; i++) {
                    Frame f = player.getFrame(i);
                    f.removePinCount(nbPins);
                    Frame nextFrame;
                    int nextIndex;
                    if((nextIndex = i + 1) <= currentIndex && (nextFrame = player.getFrame(nextIndex)) != null) {
                        transferScore(f, nextFrame);
                    }
                }
                LOG.info(player);

                if(trailingFrame.isComplete()) {
                    trailingIndex++;
                }
                if(currentFrame.goNext()) {
                    ++currentIndex;
                    transferScore(currentFrame, player.getFrame(currentIndex));
                }

            }

        } while(!player.isGameComplete() && currentIndex < Frame.MAX_NB_FRAME);

//        String quit = null;
//        do {
//            try {
//                quit = readString("");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } while(!quit.equals('q'));
    }

    private void transferScore(final Frame from, final Frame to) {
        if(from != null && to != null) {
            to.setPreviousFrameScore(from.getScore());
        }
    }

    private boolean validate(final Frame currentFrame, final int nbPins) {
        // TODO - DC : will need to adjust for last frame where you may have 10 or 20 more pins to drop.
        return nbPins <= currentFrame.getPinStanding() && nbPins >= 0;
    }

    private int readInt(final String output) {
        int value = INVALID_NB_INPUT;
        try {
            value = Integer.parseInt(readString(output));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }

    private String readString(final String output) throws IOException {
        LOG.info("{}", output);
        return INPUT_READER.readLine();
    }

    public static void main(final String[] args) {
        LOG.debug("Welcome to BKBowl");
        BowlingManager bm = new BowlingManager();
        try {
            bm.start();
        } catch (Exception e) {
            LOG.error("mess up {}", e.toString());
        }
    }

}
