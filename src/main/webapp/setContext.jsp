<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/10
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>setContext</title>
</head>
<body>
    <%
        pageContext.setAttribute("name", "gareen");
        request.setAttribute("name", "gareen");
        session.setAttribute("name","gareen");
    %>

    <%=pageContext.getAttribute("name")%><br>
    <%=request.getAttribute("name")%>
    <%response.sendRedirect("getContext.jsp");%>

</body>
</html>
