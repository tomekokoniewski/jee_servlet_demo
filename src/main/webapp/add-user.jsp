<%--
  Created by IntelliJ IDEA.
  User: tomaszokoniewski
  Date: 02.12.17
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>

<form method="post" action="AddUserServlet">

    <p>Id</p>
    <input type="text" name="id">
    <p>Name</p>
    <input type="text" name="name">
    <p>Surname</p>
    <input type="text" name="surname">
    <p>Age</p>
    <input type="text" name="age">
    <p>Login</p>
    <input type="text" name="login">
    <p>Male</p>
    <input type="text" name="gender">

<button formmethod="post">Submit</button>


</form>

</body>
</html>
