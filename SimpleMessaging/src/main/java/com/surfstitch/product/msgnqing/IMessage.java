package com.surfstitch.product.msgnqing;

public interface IMessage {
     
    
    public String getPayload();
    public void addPayload(String payload);
    public void  clearPayload();
    public String getId();
    public void setId(String id);
    
}
