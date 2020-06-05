<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
    <style>
        .center {
            margin-left: 45%;
            margin-top: 19%;
        }

        .seccenter {
            margin-left: 3%;
            margin-top: 19%;
        }
        .thcenter {
            margin-left: 7%;
            margin-top: 3%;
        }
    </style>
</head>
<body>
<div class="center">
    <div class="seccenter">Add new user</div>
<form action="/admin/add" method="post">
    <input required type="text" name="firstName" placeholder="First name"><br/>
    <input required type="text" name="lastName" placeholder="Last name"><br/>
    <input required type="text" name="password" placeholder="Password"><br/>
    <input required type="text" name="bankAcc" placeholder="Acc"><br/>
    <input required type="text" name="email" placeholder="E-mail"><br/>
    <p><input type="checkbox" name="user_role" value="${u_role}">User role<br/>
        <input type="checkbox" name="admin_role" value="${a_role}">Admin role<br/></p>
    <div class="thcenter"><input type="submit" value="Save"></div>
</form>
</div>
</body>
</html>
