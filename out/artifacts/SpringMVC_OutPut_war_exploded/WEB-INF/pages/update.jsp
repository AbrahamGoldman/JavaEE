<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 2021/7/16
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="post">
    书名：${requestScope.bookName}
    作者：<input name="author"/>
    价格：<input name="price"/>
    库存：<input name="stock"/>
    销量：<input name="sale"/>
    <input type="submit">
</form>
</body>
</html>
