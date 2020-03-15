<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/10
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getSession</title>
</head>
<body>
    <%
        String name = (String) session.getAttribute("name");
    %>
    session中的name:<%=name%>
</body>
</html>
