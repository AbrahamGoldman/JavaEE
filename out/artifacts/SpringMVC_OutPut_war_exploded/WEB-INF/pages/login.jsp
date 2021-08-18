<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fmt:message key="welcome"/>
<form action="login" method="post">
    <fmt:message key="username"/>：<input name="username"/>
    <fmt:message key="password"/>：<input name="password"/>
    <input type="submit" value="<fmt:message key="loginbtn"/>">
</form>

</body>
</html>
