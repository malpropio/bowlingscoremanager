package com.nomura;

import com.nomura.manager.BowlingManager;
import com.nomura.manager.SinglePlayerBowlingManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BowlingRunner {

    private static final Logger LOG = LogManager.getLogger(BowlingRunner.class);

    public static void main(final String[] args) {
        LOG.debug("Welcome to BKBowl");
        BowlingManager bm = new SinglePlayerBowlingManager();
        try {
            bm.start();
        } catch (Exception e) {
            LOG.error("o o, seems like we ran into some prob {}", e.toString());
        }
    }

}
