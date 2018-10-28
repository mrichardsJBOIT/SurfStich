package com.surfstitch.product.msgnqing;


public interface ISSQueue {
    public void add(IMessage message);
    public  int queueSize();
    public IMessage getNext();
}
