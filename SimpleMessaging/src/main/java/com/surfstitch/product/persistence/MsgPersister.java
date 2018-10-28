package com.surfstitch.product.persistence;

import java.util.List;

import com.surfstitch.product.msgnqing.IMessage;

public class MsgPersister implements IMsgPersister{
    
    
    public void persist(IMessage message){
          //At this point we would write message to db;
          
    }
    
    public void persist(List<IMessage> messages){
        //At this point we would write messages to db;  ;
    }
    
    
}
