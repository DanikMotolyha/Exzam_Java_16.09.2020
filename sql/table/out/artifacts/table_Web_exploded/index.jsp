
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: danik
  Date: 14.09.2020
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="Servlet" method="get">
    <input type="submit" value="get"/>
</form>
<table>
    <tbody>
<c:forEach var="product" items="${products}">
    <tr>
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
    </tr>
</c:forEach>
    </tbody>
</table>
<H2>Task 2 to table once</H2>
${mail}
${phone}
<form action="Servlet2" method="get">
    <input type="submit" value="get">
</form>
<form action="Servlet2" method="post">
    <input type="submit" value="clear">
</form>
<H2>Ex 3 login and change int</H2>
<form action="Input" method="get">
    <input type="text" name="user"      placeholder="UserName"/>
    <input type="text" name="password"  placeholder="Password"/>
    <input type="submit" value="get"/>
</form>
${infoMessage}
</body>
</html>
