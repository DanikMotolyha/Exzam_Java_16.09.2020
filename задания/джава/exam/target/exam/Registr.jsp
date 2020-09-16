<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.06.2020
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main" method="post">
    <label>Name:
        <br/>
        <input type="text" name="name"/>
    </label>
    <br/>
    <label>Surname:
        <br/>
        <input type="text" name="surname"/>
    </label>
    <br/>
    <label>Id:
        <br/>
        <input type="text" name="id"/>
    </label>
    <br/>
    <label>Subject:
        <br/>
        <input type="text" name="subject"/>
    </label>
    <br/>
    <label>Mark:
        <br/>
        <input type="text" name="mark"/>
    </label>
    <button type="submit">Add</button>
</form>
</body>
</html>
