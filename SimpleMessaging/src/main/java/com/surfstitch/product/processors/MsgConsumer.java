package com.surfstitch.product.processors;

import java.util.logging.Logger;

import com.surfstitch.product.msgnqing.*;

import java.util.ArrayList;
import java.util.List;

public class MsgConsumer implements Runnable {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private ISSQueue            msgQueue;
    private final int           maxIntervals;
    private final int           maxNumberOfMessages;
    private List<IMessage>      msgListToProcess;                                    //Date need to send to db

    public MsgConsumer(ISSQueue queue, int maxNumberOfMessages, int maxIntervals) {
        this.msgQueue = queue;
        this.maxNumberOfMessages = maxNumberOfMessages;
        this.maxIntervals = maxIntervals;
        this.msgListToProcess = new ArrayList<IMessage>();
    }

    public void run() {
        try {
            getMessages(maxNumberOfMessages);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void getMessages(int numberOfMEssages) throws InterruptedException {

        for (int i = 0; i < maxNumberOfMessages; i++) {
            Thread.sleep(maxIntervals);
            IMessage thisMsg = msgQueue.getNext();
            LOGGER.info(thisMsg.getId() + " :: " + thisMsg.getPayload());
            msgListToProcess.add(thisMsg);
        }
        LOGGER.info("Got Messages, Queue Size = " + msgQueue.queueSize());
        LOGGER.info("Got Messages, msgListToProcess Size = " + msgListToProcess.size());
    }
}
