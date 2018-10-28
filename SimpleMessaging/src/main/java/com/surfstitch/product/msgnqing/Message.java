package com.surfstitch.product.msgnqing;

public class Message implements IMessage {
     
    private String payload;
    private String id;
    
    public Message(String newPayload, String newId){
        this.payload= newPayload;
        this.id=newId;        
    }
        
    public String getPayload()
    {
        return this.payload;
    }
    
    public void addPayload(String payload)
    {
        this.payload = payload;
    }

    public void clearPayload(){
        
        this.payload = null;
    }

    public String getId(){
        return this.id;
    }
    
    public void setId(String newId){
        this.id = newId;
    }
}