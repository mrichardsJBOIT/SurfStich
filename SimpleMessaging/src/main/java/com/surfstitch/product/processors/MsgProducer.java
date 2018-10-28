package com.surfstitch.product.processors;

import java.util.logging.Logger;
import com.surfstitch.product.msgnqing.*;
import com.surfstitch.product.data.*;

public class MsgProducer implements Runnable{
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private ISSQueue msgQueue;
    private final int maxNumberOfMessages ;
    private final int maxIntervals;
    private final int maxTimeSeconds;
    private final String threadID;
     
    public MsgProducer(ISSQueue queue, int maxNumberOfMessages, int maxIntervals, int maxTimeSeconds, String threadID) {
        this.msgQueue = queue;
        this.maxNumberOfMessages = maxNumberOfMessages;
        this.maxIntervals = maxIntervals;
        this.maxTimeSeconds = maxTimeSeconds;
        this.threadID = threadID;
    }
    
    public void run() {
        try {
            //Implement some sort oof time pslicing later
            
            if (maxIntervals > 0) { ;} 
            if (maxTimeSeconds > 0) {;}             
            generateMessages(maxNumberOfMessages);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
     
    private IMessage createMessage(int idCounter){
        
        String productID = threadID.concat(":").concat(String.format("|%020d|", idCounter));
        String jsonProducString = "{\"productID\":\""+ productID+"\",\"productName\":\"notRealTop_"+idCounter+ 
                                                                  "\",\"productDescription\":\"A made up description_"+idCounter+"\"}" ; 
        Product myProduct = new Product(jsonProducString);
        LOGGER.info(jsonProducString);
        return new Message(myProduct.toJsonString(),String.format("|%07d|", idCounter));
        
    }
    private void generateMessages(int numberOfMEssages) throws InterruptedException {
        
        for (int i = 0; i < maxNumberOfMessages; i++) {
            Thread.sleep(maxIntervals);
            msgQueue.add(createMessage(i));
        }  
         LOGGER.info("Queue Size = "+msgQueue.queueSize());
     }
}
