<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All users</title>
    <style>
        TABLE {
            width: 1350px;
            border-collapse: collapse;
        }
        TD, TH {
            padding: 1px;
            border: 1px solid lightgray;
            width: 150px;
        }
        TH {
            background: #696969;
        }
    </style>
</head>
<body>
&nbsp;List of users
<br>
</body>
<body>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Password</th>
        <th>Bank Acc</th>
        <th>E-mail</th>
        <th>Roles</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getFirstName()}</td>
            <td>${user.getLastName()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getBankAcc()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getRoles()}</td>
            <td>
                <form action="/admin/update" method="get">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Edit">
                </form>
            </td>
            <td>
                <form action="/admin/delete" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="/admin/add" method="get">
    <input type="submit" value="Add new user">
</form>
<br>
<form action="/login">
    <input type="submit" value="Log out">
</form>
</body>
</html>
