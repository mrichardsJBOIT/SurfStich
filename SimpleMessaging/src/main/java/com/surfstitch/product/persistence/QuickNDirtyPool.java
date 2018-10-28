package com.surfstitch.product.persistence;
import java.sql.Connection;

public class QuickNDirtyPool implements ConnectionPool {
    
    public Connection getConnection(){
        //Check if we have spare connections
      return null  ;
    }   
    public boolean releaseConnection(Connection connection){
        return true ;
    }

  
    
    
}



