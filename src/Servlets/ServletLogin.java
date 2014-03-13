package Servlets;

import Utils.DAOStarter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
       if  (DAOStarter.getDAO().ReadUser(request.getParameter("login"), request.getParameter("password"))){
           String html = "<html>\n" +
                   "  <head>\n" +
                   "    <title></title>\n" +
                   "  </head>\n" +
                   "  <body>\n" +
                   "  Welcome, user "+request.getParameter("login")+"\n" +
             //      "  <form action=\"order.jsp\" method=\"post\">\n" +
                   "  <form action=\"\\order\" method=\"get\">\n" +
                   "      <input type=\"submit\" value=\"To shop\"/>\n" +
                   "  </form>\n" +
                   "  <a href=\"index.jsp\">Login</a>\n" +
                   "  </body>\n" +
                   "</html>";
           out.print(html);

       }
        else
        out.print("User "+request.getParameter("login")+ " not found!");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
