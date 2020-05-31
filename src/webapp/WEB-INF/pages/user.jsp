<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All users</title>
    <style>
        TABLE {
            width: 1575px;
            border-collapse: collapse;
        }
        TD, TH {
            padding: 1px;
            border: 1px solid lightgray;
            width: 175px;
        }
        TH {
            background: #696969;
        }
    </style>
</head>
<body>
&nbsp;Hello ${user.getFirstName()}!
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
        <th>Role</th>
    </tr>
        <tr>
            <td><c:out value = "${user.getId()}"/></td>
            <td><c:out value="${user.getFirstName()}"/></td>
            <td><c:out value="${user.getLastName()}"/></td>
            <td><c:out value="${user.getPassword()}"/></td>
            <td><c:out value="${user.getBankAcc()}"/></td>
            <td><c:out value="${user.getEmail()}"/></td>
            <td><c:out value="${user.getRole()}"/></td>
        </tr>
</table>
<br>
<form action="/login">
    <input type="submit" value="Log out">
</form>
</body>
</html>