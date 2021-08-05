package org.owasp.latam21.securecoding.dao;

import org.owasp.latam21.securecoding.model.User;
import org.owasp.latam21.securecoding.util.DataAccess;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

    public boolean autheticateUSer(User user){
        boolean authorized = false;
        if(user.getUsername().equals("admin") && user.getPassword().equals("password"))
            authorized = true;
        return authorized;
    }
}
