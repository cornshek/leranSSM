<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/10
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>setCookie</title>
</head>
<body>
    <%
        Cookie cookie = new Cookie("name", "Gareen");
        cookie.setMaxAge(24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
    %>

    <a href="getCookie.jsp">跳转到获取cookie的页面</a>
</body>
</html>
