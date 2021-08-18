<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 2021/7/29
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>成功登录</h1>
${requestScope.teacher}
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>address</th>
        <th>birth</th>
        <th>courser</th>
    </tr>
    <c:forEach items="${requestScope.pageInfo.list}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.address}</td>
            <td>${teacher.birth}</td>
            <td>${teacher.course}</td>
        </tr>
    </c:forEach>
<%--这个tr标签开始具体的分页功能，非常简单--%>
    <tr>
        <td colspan="5">
            <a href="getAll?pn=1">首页</a>
            <c:if test="${pageInfo.pageNum>1}">
                <a href="getAll?pn=${pageInfo.prePage}">上一页</a>
            </c:if>

            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                <c:if test="${num==pageInfo.pageNum}">
                    [${num}]
                </c:if>
                <c:if test="${num!=pageInfo.pageNum}">
                    <a href="getAll?pn=${num}">${num}</a>
                </c:if>
            </c:forEach>

            <c:if test="${pageInfo.pageNum<pageInfo.pages}">
                <a href="getAll?pn=${pageInfo.nextPage}">下一页</a>
            </c:if>
            <a href="getAll?pn=${pageInfo.pages}">末页</a>
        </td>
    </tr>
</table>


</body>
</html>
