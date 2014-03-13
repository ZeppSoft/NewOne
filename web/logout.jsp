<%@ page import="Utils.Order" %>
<%@ page import="Utils.User" %>
<%@ page import="Utils.CarShopDAODerby" %>
<%@ page import="Utils.DAOStarter" %>
<%--
  Created by IntelliJ IDEA.
  User: VShershnev
  Date: 12.03.14
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    DAOStarter.getDAO().setCurrentUser(new User("", ""));
    DAOStarter.getDAO().setCurrentOrder(new Order());
%>
Log out complete!
<br/>
<a href="order.jsp">Back</a>
</body>
</html>
