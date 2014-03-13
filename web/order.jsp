<%@ page import="Utils.CarShopDAODerby" %>
<%@ page import="Utils.DAOStarter" %>
<%--
  Created by IntelliJ IDEA.
  User: VShershnev
  Date: 12.03.14
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Car order:
<form action="/order" method="post">
    Model:
    <select name="model">
        <option value="Mercedes-Benz">Mercedes-Benz </option>
        <option value="BMW">BMW</option>
        <option value="Lada">Lada</option>
    </select>
    <br/>
    Hull:
    <select name="hull">
        <option value="Coupe">Coupe </option>
        <option value="Sedan">Sedan</option>
        <option value="Hatchback">Hatchback</option>
    </select>
    <br/>
    Color:
    <select name="color">
        <option value="White">White </option>
        <option value="Black">Black</option>
        <option value="Blue">Blue</option>
        <option value="Red">Red</option>
    </select>
    <br/>
    Hutch:
    <select name="hutch">
        <option value="Hutch">Hutch </option>
        <option value="NoHutch">No Hutch</option>
    </select>
    <br/>



    <input type="submit" value="Purchase"/>

</form>

<b>User: </b>
<% out.println(DAOStarter.getDAO().getCurrentUser().getLogin()); %> <br/>
<a href="index.jsp">Log In</a> <br/>
<a href="logout.jsp">Log Out</a> <br/>
<b>Already purchased:</b>

<% if (CarShopDAODerby.currentOrder.getCars().isEmpty()){
 out.println(" No orders.");
 }
else {
//out.println(" Some orders.");
    String str = DAOStarter.getDAO().makeHTMLOrder();
    out.println(str);
 }%>
<br/>
<b>Current shop cart:</b>
<% if (CarShopDAODerby.cartOrder.getCars().isEmpty()){
    out.println(" No orders.");
}
else {
    String str = DAOStarter.getDAO().makeHTMLCartOrder();
    out.println(str);
    }%>
<br/>

<%--<% if (CarShopDAODerby.currentOrder.getCars().isEmpty()){%>--%>
<%--<% out.println(" No orders."); %>--%>
<%--<% }%>--%>
<%--<%else {%>--%>
<%--<% out.println(" Some orders."); %>--%>
<%--<% }%>--%>



<%--<% DB.loadOrderXML(DB.getUserFile(DB.currentUser.getLogin())); %>--%>

</body>
</html>
