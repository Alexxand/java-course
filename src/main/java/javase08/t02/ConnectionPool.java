package javase08.t02;


import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Logger;

public class ConnectionPool implements AutoCloseable{
    private final BlockingQueue<Connection> unusedConnections;
    private final List<Connection> allConnections;
    private final Properties driverProperties;
    private final String url;

    private static final int MAX_CONNECTIONS_NUMBER = 1000;
    private static final int DEFAULT_INITIAL_CONNECTIONS_NUMBER = 6;

    public ConnectionPool(String driver, String url, Properties info){
        this(DEFAULT_INITIAL_CONNECTIONS_NUMBER,driver,url,info);
    }

    public ConnectionPool(int initConNumber, String driver, String url, Properties info){
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException e){
            //типа залогировал
            e.printStackTrace();
        }
        driverProperties = info;
        this.url = url;
        allConnections = new ArrayList<>(initConNumber);
        try {
            for (int i = 0; i < initConNumber; ++i) {
                allConnections.add(new PoolingConnection(DriverManager.getConnection(url, info)));
            }
        } catch (SQLException e){
            //типа залогировал
            e.printStackTrace();
        }
        unusedConnections = new ArrayBlockingQueue<>(allConnections.size(),false,allConnections);
    }

    public Connection getConnection() throws InterruptedException{
        Connection returnedConnection = unusedConnections.poll();
        if(returnedConnection != null){
            return new PoolingConnection(returnedConnection);
        } else {
            if (allConnections.size() < MAX_CONNECTIONS_NUMBER){
                try {
                    returnedConnection = DriverManager.getConnection(url, driverProperties);
                } catch (SQLException e){
                    //типа залогировал
                    e.printStackTrace();
                }
                allConnections.add(returnedConnection);
                return new PoolingConnection(returnedConnection);
            } else {
                returnedConnection = unusedConnections.take();
                return new PoolingConnection(returnedConnection);
            }
        }
    }

    @Override
    public void close() throws SQLException{
        for(Connection connection : allConnections){
            Connection innerConnection = connection.unwrap(Connection.class);
            innerConnection.close();
        }
    }


    private class PoolingConnection implements Connection {
        Connection innerConnection;

        PoolingConnection(Connection connection){
            innerConnection = connection;
        }

        @Override
        public Statement createStatement() throws SQLException {
            return innerConnection.createStatement();
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return innerConnection.prepareStatement(sql);
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return innerConnection.prepareCall(sql);
        }

        @Override
        public String nativeSQL(String sql) throws SQLException {
            return innerConnection.nativeSQL(sql);
        }

        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException {
            innerConnection.setAutoCommit(autoCommit);
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return innerConnection.getAutoCommit();
        }

        @Override
        public void commit() throws SQLException {
            innerConnection.commit();
        }

        @Override
        public void rollback() throws SQLException {
            innerConnection.rollback();
        }

        @Override
        public void close() {
            unusedConnections.add(innerConnection);
        }

        @Override
        public boolean isClosed() {
            return unusedConnections.contains(innerConnection);
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return innerConnection.getMetaData();
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {
            innerConnection.setReadOnly(readOnly);
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return innerConnection.isReadOnly();
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {
            innerConnection.setCatalog(catalog);
        }

        @Override
        public String getCatalog() throws SQLException {
            return innerConnection.getCatalog();
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {
            innerConnection.setTransactionIsolation(level);
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return innerConnection.getTransactionIsolation();
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return innerConnection.getWarnings();
        }

        @Override
        public void clearWarnings() throws SQLException {
            innerConnection.clearWarnings();
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return innerConnection.createStatement();
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return innerConnection.prepareStatement(sql,resultSetType,resultSetConcurrency);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return innerConnection.prepareCall(sql,resultSetType,resultSetConcurrency);
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return innerConnection.getTypeMap();
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            innerConnection.setTypeMap(map);
        }

        @Override
        public void setHoldability(int holdability) throws SQLException {
            innerConnection.setHoldability(holdability);
        }

        @Override
        public int getHoldability() throws SQLException {
            return innerConnection.getHoldability();
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return innerConnection.setSavepoint();
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return innerConnection.setSavepoint(name);
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
            innerConnection.rollback();
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            innerConnection.releaseSavepoint(savepoint);
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return innerConnection.createStatement(resultSetType,resultSetConcurrency,resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return innerConnection.prepareStatement(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return innerConnection.prepareCall(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return innerConnection.prepareStatement(sql,autoGeneratedKeys);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return innerConnection.prepareStatement(sql,columnIndexes);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return innerConnection.prepareStatement(sql,columnNames);
        }

        @Override
        public Clob createClob() throws SQLException {
            return innerConnection.createClob();
        }

        @Override
        public Blob createBlob() throws SQLException {
            return innerConnection.createBlob();
        }

        @Override
        public NClob createNClob() throws SQLException {
            return innerConnection.createNClob();
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return innerConnection.createSQLXML();
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            return innerConnection.isValid(timeout);
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {
            innerConnection.setClientInfo(name,value);
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            innerConnection.setClientInfo(properties);
        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            return innerConnection.getClientInfo(name);
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return innerConnection.getClientInfo();
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return innerConnection.createArrayOf(typeName,elements);
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return innerConnection.createStruct(typeName,attributes);
        }

        @Override
        public void setSchema(String schema) throws SQLException {
            innerConnection.setSchema(schema);
        }

        @Override
        public String getSchema() throws SQLException {
            return innerConnection.getSchema();
        }

        @Override
        public void abort(Executor executor) throws SQLException {
            innerConnection.abort(executor);
        }

        @Override
        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
            innerConnection.setNetworkTimeout(executor,milliseconds);
        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return innerConnection.getNetworkTimeout();
        }

        @Override
        public <T> T unwrap(Class<T> iface) {
            if (!isWrapperFor(iface))
                return null;
            return (T) innerConnection;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) {
            return Connection.class == iface;
        }
    }
}
