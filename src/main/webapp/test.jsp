<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 10.12.17
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title [test.jsp]</title>
</head>
<body>

<p>
    wartosc testu: ${test}!
</p>


<p>
    Name z sesji: ${sessionScope.name}!
</p>
<p>
    Name z requestu: ${name}!
</p>

<p>
    Your salary: ${sessionScope.salary}!
</p>


<p>
    <c:set var="bonus" scope="request" value="${1.2*salary}"/>
    Salary with Bonus: <c:out value="${bonus}"/>
</p>



</body>
</html>
