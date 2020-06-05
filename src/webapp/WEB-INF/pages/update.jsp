<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title><style>
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
    <div class="seccenter">Edit this user?</div>
<br/>
<form action="/admin/update" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="text" name="firstName" placeholder="Edit First name"><br/>
    <input type="text" name="lastName" placeholder="Edit Last name"><br/>
    <input type="text" name="password" placeholder="Edit password"><br/>
    <input type="text" name="bankAcc" placeholder="Edit account"><br/>
    <input type="text" name="email" placeholder="Edit e-mail"><br/>
    <p><input type="checkbox" name="user_role" value="${u_role}">Choose role: user<br/>
        <input type="checkbox" name="admin_role" value="${a_role}">Choose role: admin<br/></p>
    <div class="thcenter"><input type="submit" value="Edit"/></div>
</form>
</div>
</body>
</html>
