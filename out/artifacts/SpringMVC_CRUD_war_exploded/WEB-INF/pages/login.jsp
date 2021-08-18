<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>login/登录</title>
</head>
<body>
<h1><f:message key="welcome"/></h1>
<form action="" method="post"><br/>
    <f:message key="username"/>： <input name="username"/><br/>
    <f:message key="password"/>： <input name="password"/><br/>
    <input type="submit" value="<f:message key="submit"/>">
</form>
<br/>
<a href="toLogin?locale=zh_CN">中文/</a>
<a href="toLogin?locale=en_US">English</a>
</body>
</html>
