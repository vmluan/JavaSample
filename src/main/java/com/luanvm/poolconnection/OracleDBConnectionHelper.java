package main.java.com.luanvm.poolconnection;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by luanvm on 9/22/2016.
 * This class is using Connection Caching that implemented in DataSource class (support JDBC 3.0)
 */
public class OracleDBConnectionHelper {

    OracleDataSource dataSource = null;

    public void setDataSource(){
        try {
            dataSource = new OracleDataSource();

            // set cache properties
            java.util.Properties prop = new java.util.Properties();
            prop.setProperty("MinLimit", "2");
            prop.setProperty("MaxLimit", "10");

            // set DataSource properties
            String url = "jdbc:oracle:oci8:@lovad.dyndns.org:1521:databaseName"; // or: jdbc:oracle:thin:@lovad.dyndns.org:1521:databaseName
            dataSource.setURL(url);
            dataSource.setUser("user");
            dataSource.setPassword("password");
            dataSource.setConnectionCachingEnabled(true);
            dataSource.setConnectionCacheProperties(prop);
            dataSource.setConnectionCacheName("ImplicitCache01"); // this cache's name
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
        Method is to get logical connection
     */
    public Connection getConnection(){
        Connection connection = null;
        synchronized (this){ // synchronized this block code to make sure a connection is return to 1 thread only.
            // As if multiple threads use the same connection, it cause a potential issue.
            try{
                connection = dataSource.getConnection(); // return logical Connection.
            }catch (SQLException e){
                e.printStackTrace();
            }
            return connection;
        }
    }

    public  void closeDataSource(){
        try {
            dataSource.close(); // close datasource to close all physical connection in the associated cache.
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
