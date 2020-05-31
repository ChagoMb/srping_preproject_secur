<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form action="/admin/add" method="post">
    <input required type="text" name="firstName" placeholder="First name">
    <input required type="text" name="lastName" placeholder="Last name">
    <input required type="text" name="password" placeholder="Password">
    <input required type="text" name="bankAcc" placeholder="Acc">
    <input required type="text" name="email" placeholder="E-mail">
    <input required type="text" name="role" placeholder="Role">
    <input type="submit" value="Save">
</form>
</body>
</html>
