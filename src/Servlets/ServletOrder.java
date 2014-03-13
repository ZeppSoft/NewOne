package Servlets;

import Utils.Car;
import Utils.CarShopDAODerby;
import Utils.DAOStarter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
     //   if (CarShopDAODerby.currentUser.getLogin().equals("")){
        try {
        String login= (String) DAOStarter.getDAO().getSession().getAttribute("login");
        if (login==null){
            out.print("Please login in system!");
            return;
        }
        }
        catch (java.lang.IllegalStateException e){
            out.print("Please login in system!");
            return;
        }


        Car car = new Car();
        car.setModelName(request.getParameter("model"));
        car.setHullType(request.getParameter("hull"));
        car.setColor(request.getParameter("color"));
        car.setIsHatch(request.getParameter("hutch"));
        DAOStarter.getDAO().addOrder(car);

        String button = "<html>\n" +
                "  <head>\n" +
                "    <title></title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                " <b> Car purchased! </b><br/>"+
                "  <form action=\"order.jsp\" >\n" +
                "      <input type=\"submit\" value=\"Back to orders\"/>\n" +
                "  </form>\n" +
                "  </body>\n" +
                "</html>";

        out.print(button);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/order.jsp");
    }

    @Override
    public void init() throws ServletException {
       // super.init();
        DAOStarter.getDAO().loadOrder();
    }

    @Override
    public void destroy() {
        DAOStarter.getDAO().saveOrder();
    }
}
