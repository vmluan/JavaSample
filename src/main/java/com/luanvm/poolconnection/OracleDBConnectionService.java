package main.java.com.luanvm.poolconnection;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.pool.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by luanvm on 9/22/2016.
 * This class is based on OracleConnectionCacheImpl class to cache connection. This class is already deprecated. (JDBBC 2.0)
 * We SHOULD use new architecture for better performance that support JDBC 3.0
 */
public class OracleDBConnectionService {
    OracleConnectionPoolDataSource oracleConnectionPoolDataSource;
    OracleConnectionCacheImpl oracleConnectionCache; // this class is deprecated. We should use new class for better performance.

    /*
        Method to create the connection cache.
     */
    public void setDataSource() throws SQLException {
        String url ="";
        String user = "";
        String pass = "";
        oracleConnectionPoolDataSource = new OracleConnectionPoolDataSource();
        oracleConnectionPoolDataSource.setDriverType("oracle.jdbc.driver.OracleDriver");
        oracleConnectionPoolDataSource.setURL(url);
        oracleConnectionPoolDataSource.setUser(user);
        oracleConnectionPoolDataSource.setPassword(pass);

        oracleConnectionCache = new OracleConnectionCacheImpl(oracleConnectionPoolDataSource);
        oracleConnectionCache.setMinLimit(5);
        oracleConnectionCache.setMaxLimit(10);
        oracleConnectionCache.setCacheScheme(1);
    }

    public Connection getDBConnection(){
        Connection connection = null;
        synchronized (this){ // synchronized this block code to make sure a connection is return to 1 thread only.
            // As if multiple threads use the same connection, it cause a potential issue.
            try{
                connection = oracleConnectionCache.getConnection(); // return logical Connection.
            }catch (SQLException e){
                e.printStackTrace();
            }
            return connection;
        }

    }
    public Connection getNonPooledConnection(String url, String user, String pass){
        Connection connection = null;
        synchronized (this){
            try{
                connection = DriverManager.getConnection(url,user,pass);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
