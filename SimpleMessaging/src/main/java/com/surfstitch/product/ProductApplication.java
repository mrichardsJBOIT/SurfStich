package com.surfstitch.product;
import com.surfstitch.product.processors.*;

public class ProductApplication {
    
    private ProcessingEngine engine;

    public ProductApplication(){
        engine = new ProcessingEngine();
    }
    private void runEngine(){
        engine.start();
    }
    public static void main(String[] args) {
        ProductApplication myApp = new ProductApplication();
        myApp.runEngine();
    }



}
