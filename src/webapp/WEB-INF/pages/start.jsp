<%--
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
            margin-left: 40%;
            margin-top: 19%;
        }
    </style>
</head>
<body>
<div class="center">
    Authentication:
    <br>
    <form action="/login/begin">
        <input required type="text" name="login" placeholder="Login">
        <input required type="password" name="password" placeholder="Password">
        <input type="submit" value="Sign">
    </form>
</div>

</body>
</html>