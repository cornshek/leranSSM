<%@ page import="pojo.Product" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/15
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showProduct</title>
</head>
<body>
    <%Product product = (Product) request.getAttribute("product");%>
    产品名称：<%=product.getName()%><br/>
    产品价格：<%=product.getPrice()%>
</body>
</html>
