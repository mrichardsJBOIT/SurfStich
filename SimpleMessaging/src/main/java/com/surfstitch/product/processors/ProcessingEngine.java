package com.surfstitch.product.processors;


import java.util.logging.Logger;
import com.surfstitch.product.msgnqing.*;

public class ProcessingEngine {

    /* The processing engine should control all the connections and run the producers and consumers*/

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private MsgProducer         myMsgProducer1;
    private MsgProducer         myMsgProducer2;
    private MsgConsumer         myMsgConsumer1;
    private MsgConsumer         myMsgConsumer2;
    //private MsgConsumer         myMsgConsumer3;
    private ISSQueue            myQ;
    int                         maxNumberOfMessages;
    int                         maxIntervalsProduction;
    int                         maxIntervalsConsumption;
    int                         maxTimeSeconds;
    String                      threadID;
    int                         noMsgsToConsume;

    private void setUpTestData() {
        LOGGER.info("****** Setting ProcessingEngine Data *****");
        myQ = new SSQueue();
        maxNumberOfMessages = 100;
        maxIntervalsProduction = 10;
        maxIntervalsConsumption = 100;
        maxTimeSeconds = 0; //not used yet
        threadID = this.toString();
        myMsgProducer1 = new MsgProducer(myQ, 100, 10, maxTimeSeconds, "myMsgProducer1");
        myMsgProducer2 = new MsgProducer(myQ, 50, 100, maxTimeSeconds, "myMsgProducer2");

        //noMsgsToConsume = (int)Math.ceil((maxNumberOfMessages / 2));
        myMsgConsumer1 = new MsgConsumer(myQ, 75, 50);
        myMsgConsumer2 = new MsgConsumer(myQ, 75, 50);
    }

    public void start() {
        setUpTestData();
        LOGGER.info("****** Creating threads *****");
        Thread producer1 = new Thread(myMsgProducer1);
        Thread producer2 = new Thread(myMsgProducer2);

        Thread consumer1 = new Thread(myMsgConsumer1);
        Thread consumer2 = new Thread(myMsgConsumer2);

        LOGGER.info("****** Starting  threads *****");
        try {
            producer1.start();

            Thread.sleep(50);
            producer2.start();
            Thread.sleep(50);
            consumer1.start();
            consumer2.start();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        LOGGER.info("****** All threads Started*****");
    }
}
