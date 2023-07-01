package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        this.close();
    realConnection.close();
    }

    @Override
    public void close() {
    ConnectionPool.getInstance().destroyPool();
    ConnectionPool.getInstance().releaseConnection( ConnectionPool.getInstance().getConnection());
    }

    @Override
    public boolean isClosed() {
        return false;
    }
    // Implement methods here!
}
