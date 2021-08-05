package org.owasp.latam21.securecoding.controller;

import org.owasp.latam21.securecoding.dao.LoginDao;
import org.owasp.latam21.securecoding.model.User;
import org.owasp.latam21.securecoding.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "You took the red!";
    }

        @HttpConstraint()
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher = null;
        PrintWriter out = response.getWriter();
        LoginDao loginDao = new LoginDao();
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        User user = new User(username, password);
        try {
            if(!loginDao.autheticateUSer(user)){
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
            Cookie userCookie = new Cookie("user", username);
            userCookie.setMaxAge(60*60*8*1);
            userCookie.setHttpOnly(Constants.HTTP_ONLY_COOKIE);
            userCookie.setSecure(Constants.SECURE_COOKIE);
            userCookie.setDomain(Constants.APPLICATION_DOMAIN);
            response.addCookie(userCookie);
            //response.addHeader("Authorization", "TOken");
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        }catch(Exception e){
        }



    }

    private Cookie getAuthCookie(){
        return null;
    }
    public void destroy() {
    }
}
