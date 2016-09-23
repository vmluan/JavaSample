package main.java.com.luanvm.poolconnection;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;



import javax.sql.DataSource;
/**
 * Created by luanvm on 9/22/2016.
 * This class is to create logical connections for MYSQL database
 * It seems that the mysql connector J does not support Connection Caching..
 * That function is delegated to application server like Tomcat (by using JNDI) or Spring context.
 * To use Connection Cache, we can use a third party: dbcp of Apache.
 */
public class MySQLDBConnectionHelper {

    MysqlConnectionPoolDataSource dataSource = null;

    public void setDataSource(){
        dataSource = new MysqlConnectionPoolDataSource();
        // set cache properties
        java.util.Properties prop = new java.util.Properties();
        prop.setProperty("MinLimit", "2");
        prop.setProperty("MaxLimit", "10");

        // set DataSource properties
        String url = "jdbc:mysql://192.168.1.69:3306/sanyo"; // or: jdbc:oracle:thin:@lovad.dyndns.org:1521:databaseName
        dataSource.setURL(url);
        dataSource.setUser("user");
        dataSource.setPassword("password");

    }
}

