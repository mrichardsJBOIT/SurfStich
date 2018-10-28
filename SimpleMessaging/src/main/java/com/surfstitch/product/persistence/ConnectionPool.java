package com.surfstitch.product.persistence;

import java.sql.Connection;

public interface ConnectionPool {
    public Connection getConnection();
    public boolean releaseConnection(Connection connection);
}