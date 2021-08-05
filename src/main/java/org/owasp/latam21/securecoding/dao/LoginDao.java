package org.owasp.latam21.securecoding.dao;

import org.owasp.latam21.securecoding.model.User;
import org.owasp.latam21.securecoding.util.DataAccess;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.owasp.latam21.securecoding.util.DataAccess;
public class LoginDao {

    public boolean autheticateUSer(User user){
        boolean authorized = false;
        DataAccess db = null;
        try{
            db = DataAccess.getDbCon();
            Statement stm = db.conn.createStatement();
            String query = "SELECT * FROM user WHERE username='"+user.getUsername()+ "' AND password='"+ user.getPassword() +"';";
            System.out.println(query);
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()) {
                System.out.print(rs);
                authorized = true;
            }
        }
        catch (Exception e){

        }
        System.out.println(authorized);
        return authorized;
    }
}
