<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/10
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>setSession</title>
</head>
<body>
    <%
        session.setAttribute("name", "teemo");
    %>

    <a href="getSession.jsp">跳转到获取session的页面</a>
</body>
</html>
