package com.surfstitch.product.persistence;

import java.util.List;

import com.surfstitch.product.msgnqing.IMessage;


public interface IMsgPersister {
    
    public void persist(IMessage message);
    public void persist(List<IMessage> messages);
       
}


