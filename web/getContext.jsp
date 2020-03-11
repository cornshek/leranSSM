<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/10
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getContext</title>
</head>
<body>
    <%= pageContext.getAttribute("name")%>
    <%=request.getAttribute("name")%>
    <%=session.getAttribute("name")%>

</body>
</html>
