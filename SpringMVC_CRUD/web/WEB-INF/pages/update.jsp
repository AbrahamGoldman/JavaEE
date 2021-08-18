<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 2021/7/20
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<f:form action="http://localhost:8080/SpringMVC_CRUD/update/${requestScope.command.id}" method="post">
<%--隐藏域返回id,方便 ModelAttribute方法中继续查找
指定put方法返回，满足REST风格--%>
    <input type="hidden" name="_method" value="PUT"/>
    <input type="hidden" name="id" value="${requestScope.command.id}">

    lastName: <f:input path="lastName"></f:input><br>
    email:    <f:input path="email"></f:input><br>
    gender: <br>
    男：<f:radiobutton path="gender" value="1"></f:radiobutton>
    女：<f:radiobutton path="gender" value="0"></f:radiobutton>
    <br>
<%--itemLabel:为下拉列表中展示的部门名，itemValue为返回给服务器的id--%>
    department:
    <f:select path="department.id" items="${requestScope.departments}" itemLabel="departmentName" itemValue="id">
</f:select>
    <input type="submit" value="提交">
</f:form>
</body>
</html>
