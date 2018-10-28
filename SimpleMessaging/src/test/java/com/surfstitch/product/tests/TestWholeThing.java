package com.surfstitch.product.tests;

//import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;
import com.surfstitch.product.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



/**
 * Unit test for Product App.
 */
@RunWith(JUnit4.class)
public class TestWholeThing {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
 
    @Test
    public void testWhole() {
        
       // ProductApplication myApp = new ProductApplication();
       // myApp.main(null);
        ProductApplication.main(null);
        // assertTrue(1 == (2-1));
    }
}
