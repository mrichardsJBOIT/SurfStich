package com.surfstitch.product.tests;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.surfstitch.product.msgnqing.*;
import com.surfstitch.product.processors.*;


/**
 * Unit test for Product App.
 */
@RunWith(JUnit4.class)
public class ProcesserTests {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private MsgProducer         myMsgProducer;
    private MsgConsumer         myMsgConsumer;
    private ISSQueue            myQ;
    int                         maxNumberOfMessages;
    int                         maxIntervals;
    int                         maxTimeSeconds;
    String                      threadID;
    int noMsgsToConsume ;

    private void setUpTestData() {
        LOGGER.info("Setting Test Data");
        myQ = new SSQueue();
        maxNumberOfMessages = 10;
        maxIntervals = 0;
        maxTimeSeconds = 0;
        threadID = this.toString();
        myMsgProducer = new MsgProducer(myQ, maxNumberOfMessages, 10, maxTimeSeconds, threadID);
        noMsgsToConsume = (int)Math.ceil((maxNumberOfMessages / 2));
        myMsgConsumer = new MsgConsumer(myQ, noMsgsToConsume, 100);
    }

    @Test
    public void testCorrectQueueSize() {
        this.setUpTestData();
        LOGGER.info("String threadID =" + maxNumberOfMessages);
        LOGGER.info("Runnning Message Producer (" + maxNumberOfMessages + ")");
        myMsgProducer.run();
        LOGGER.info("Finnished Runnning Message Producer (" + maxNumberOfMessages + ")");
        int qSize = 0;
        qSize = myQ.queueSize();
        LOGGER.info(" myQ.queueSize() = " + qSize);
        assertTrue(qSize == maxNumberOfMessages);
    }

    @Test
    public void testConsumerHalfMessages() {
        
        LOGGER.info(" *******************************  ");
        this.setUpTestData();
        LOGGER.info("String threadID =" + maxNumberOfMessages);
        LOGGER.info("Runnning Message Consumer (" + maxNumberOfMessages + ")");
        myMsgProducer.run();
        LOGGER.info("Finnished Runnning Message Producer (" + maxNumberOfMessages + ")");
        int qSize = 0;
        qSize = myQ.queueSize();
        LOGGER.info(" myQ.queueSize() = " + qSize);
        LOGGER.info(" *******************************  ");
        LOGGER.info("Now run consumer - noMsgsToConsume " + noMsgsToConsume);
        myMsgConsumer.run();
        qSize = 0;
        qSize = myQ.queueSize();
        assertTrue(qSize == (maxNumberOfMessages - noMsgsToConsume));
    }
}
