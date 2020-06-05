<%@ page import="app.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 27.05.2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        .center {
            margin-left: 43%;
            margin-top: 19%;
        }

        .seccenter {
            margin-left: 2%;
            margin-top: 19%;
        }
        .thcenter {
            margin-left: 6%;
            margin-top: 3%;
        }
    </style>
</head>
<body>
<div class="center">
    <div class="seccenter">Authentication:</div>
    <br/>
    <form action="/login" method="post">
        <input required type="text" name="login" placeholder="Login"/><br/>
        <input required type="password" name="password" placeholder="Password"/><br/>
        <div class="thcenter"><input type="submit" value="Sign"/></div>
    </form>
</div>
</body>
</html>