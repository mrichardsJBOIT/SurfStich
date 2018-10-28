package com.surfstitch.product.msgnqing;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

public class SSQueue implements ISSQueue{
    
    Queue<IMessage> ourQueue = new ConcurrentLinkedQueue<IMessage>() ;
           
    public void add(IMessage message){
        ourQueue.add(message);
    }

    public synchronized  int queueSize(){
        //This needs to be synchronised as there could be messages 
        return ourQueue.size();
    }
        
    public IMessage getNext()
    {
        return ourQueue.poll();
    }    
}
