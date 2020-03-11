<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/11
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" import="bean.*" %>
<html>
<head>
    <title>editHero</title>
</head>
<body>
<form action="updateHero" method="post">
    名字：<input type="text" name="name" value="${hero.name}"> <br>
    血量：<input type='text' name='hp' value='${hero.hp}'> <br>
    伤害：<input type='text' name='damage' value='${hero.damage}'> <br>
    <input type='hidden' name='id' value='${hero.id}'>
    <input type='submit' value='更新'>
</form>
</body>
</html>
