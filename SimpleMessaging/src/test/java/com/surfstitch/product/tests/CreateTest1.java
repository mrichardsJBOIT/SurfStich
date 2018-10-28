package com.surfstitch.product.tests;

import static org.junit.Assert.assertTrue;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.surfstitch.product.data.*;
import com.surfstitch.product.msgnqing.*;


/**
 * Unit test for Product App.
 */
@RunWith(JUnit4.class)
public class CreateTest1 {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private Product myProduct;
    private String jsonProducString;
    private IMessage myMsg ;
    private ISSQueue myQ;
    
    
    private void setUpTestData(){
        LOGGER.info("Setting Test Data");
        jsonProducString = "{\"productID\":\"0123456789\",\"productName\":\"notRealTop\",\"productDescription\":\"A made up description\"}" ; 
        myProduct = new Product(jsonProducString);
        myMsg = new Message(jsonProducString,"0001");
        myQ = new SSQueue();
    }
    @Test
    public void testProductJSON() {
        this.setUpTestData();
        String jsonProducStringTest = myProduct.toJsonString();
        LOGGER.info("jsonProducStringTest ="+jsonProducStringTest); 
        LOGGER.info("jsonProducString ="+jsonProducString);
        assertTrue(jsonProducString.equalsIgnoreCase(jsonProducStringTest));
    }
    
    @Test 
    public void testQueueAddTo(){
        this.setUpTestData();
        myQ.add(myMsg);
        
        LOGGER.info("myQ.queueSize() ="+myQ.queueSize()); 
       
        
        assertTrue(myQ.queueSize() == 1);
        IMessage getMesg =  myQ.getNext();
         LOGGER.info("Got message from queue, size now ="+myQ.queueSize());
          LOGGER.info("myMsg.getPayload ="+myMsg.getPayload());
         assertTrue(getMesg.getPayload().equalsIgnoreCase(myMsg.getPayload()));
    }
    
    @Test 
    public void testMessage(){
        this.setUpTestData();
        assertTrue(myMsg.getPayload().equalsIgnoreCase(jsonProducString));        
    }
    
}
