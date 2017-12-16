<%--
  Created by IntelliJ IDEA.
  User: tomaszokoniewski
  Date: 02.12.17
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title [welcome-user.jsp]</title>
</head>
<body>

<p>
Name z sesji: ${sessionScope.name}
</p>
<p>
Name z requestu: ${name}
</p>

<p>
Your salary: ${sessionScope.salary}
</p>

<p>
    <c:set var="bonus" scope="request" value="${1.2*salary}"/>
Salary with Bonus: <c:out value="${bonus}"/>
</p>



</body>
</html>

<!--  http://localhost:8080/welcome-user?name=Tomek&salary=100  -->