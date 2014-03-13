package Servlets;

import Utils.DAOStarter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
       // out.print("test");
       if  (DAOStarter.getDAO().SaveUser(request.getParameter("login"), request.getParameter("password"))){
           out.print("User "+request.getParameter("login")+" registered!");
       }
        else
        out.print("Registration error!");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
