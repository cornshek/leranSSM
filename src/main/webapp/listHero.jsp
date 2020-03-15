 <%@ page import="bean.Hero" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/11
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>listHero</title>
</head>
<body>
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>hp</td>
            <td>damage</td>
            <td>edit</td>
            <td>delete</td>
        </tr>

        <%
            List<Hero> heroes = (List<Hero>)request.getAttribute("heroes");
            for (Hero h : heroes) {
        %>
        <tr>
            <td><%=h.getId()%></td>
            <td><%=h.getName()%></td>
            <td><%=h.getHp()%></td>
            <td><%=h.getDamage()%></td>
            <td>
                <a href="editHero?id=<%=h.getId()%>">edit</a>
            </td>
            <td>
                <a href="deleteHero?id=<%=h.getId()%>">delete</a>
            </td>
        </tr>
        <%}%>
        <tr>
            <td colspan="6" align="center">
                <a href="?start=0">首页</a>
                <a href="?start=<%=request.getAttribute("pre")%>">上一页</a>
                <a href="?start=<%=request.getAttribute("next")%>">下一页</a>
                <a href="?start=<%=request.getAttribute("last")%>">末页</a>
            </td>
        </tr>
    </table>
</body>
</html>
