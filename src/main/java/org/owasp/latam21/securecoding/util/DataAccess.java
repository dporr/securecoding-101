package org.owasp.latam21.securecoding.util;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccess {
    public static DataAccess db;
    public Connection conn;

    public static synchronized DataAccess getDbCon() {
        if ( db == null ) {
            db = new DataAccess();
        }
        return db;
    }

    private DataAccess(){
        String url= "jdbc:mysql://mysqldb:3306/";
        String dbName = "owasp21";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "password";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
}