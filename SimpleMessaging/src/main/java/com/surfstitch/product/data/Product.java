package com.surfstitch.product.data;


import org.json.JSONException;
import org.json.JSONObject;
import java.util.logging.Logger;

public class Product {
    
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    //private static Logger logger = Logger.getLogger(App.class.getName());
    //Do these fields have a size limit?
    
    private String productID; //is this a key, can we have duplicats
    private String productName;
    private String productDescription;
    private JSONObject productJSON;
    
    public Product ( String productID,String productName, String productDescription){
                
        //Populae the object
        this.productID = productID;
        this.productName=productName;
        this.productDescription=productDescription;
        
        //populate the Jason objects
        productJSON = new org.json.JSONObject();
		productJSON.put("productID",productID);
		productJSON.put("productName",productName);
		productJSON.put("productDescription",productDescription);
    }

    public Product(String jsonProducString){        
    	
    	LOGGER.info(jsonProducString);
		productJSON = new org.json.JSONObject(jsonProducString);
		try{
		    this.productID = productJSON.getString("productID");
            this.productName=productJSON.getString("productName");
            this.productDescription=productJSON.getString("productDescription");
		}
		catch(JSONException jx){
		    //What exceotuin handling should we include here?
		    //Do we want to throw 
			jx.printStackTrace();
		}
    }
    
    public String toJsonString(){        
       return  productJSON.toString();        
    }
    
    public void setProductID(String productID){
      this.productID=productID;  
    }  //is this a key, can we have duplicats
    
    public void setProductName(String productName){
        this.productName = productName;
    }
    

    public void setProductDescription(String productDescription){
        this.productDescription = productDescription;
    }
    
    public String getProductID(){
        
        return this.productID; 
    }

    public String getProductName(){
        return this.productName;
    }
    public String getProductDescription(){
        return this.productDescription;
    }

}
