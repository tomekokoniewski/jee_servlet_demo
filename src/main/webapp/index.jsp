
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page pageEncoding="utf-8" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<html>
  <body>

  <h2>Hello World!</h2>

  <%@ include file="menu.jsp"%>

  <%
  LocalDateTime currentTime = LocalDateTime.now();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  %>

  <div>
      Strone wygenerowano: <%=currentTime.format(formatter)%>
  </div>

  </body>
</html>
