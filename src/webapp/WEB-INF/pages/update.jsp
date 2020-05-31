<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 30.05.2020
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<body>

&nbsp;Edit user?
<br>
<form action="/admin/update" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="text" name="firstName" placeholder="Edit First name">
    <input type="text" name="lastName" placeholder="Edit Last name">
    <input type="text" name="password" placeholder="Edit password">
    <input type="text" name="bankAcc" placeholder="Edit account">
    <input type="text" name="email" placeholder="Edit e-mail">
    <input type="text" name="role" placeholder="Edit role">
    <input type="submit" value="Edit">
</form>
</body>
</html>
