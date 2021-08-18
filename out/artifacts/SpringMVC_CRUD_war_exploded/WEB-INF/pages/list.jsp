<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工列表</title>
    <script type="text/javascript" src="http://localhost:8080/SpringMVC_CRUD/script/jquery-1.7.2.js"></script>
</head>
<body>
<%--cellspacing 两个边框的距离  cellpadding 内容到边框的距离--%>
<table border="1" cellspacing="0" cellpadding="5">
    <tr>
        <th>id</th>
        <th>lastName</th>
        <th>email</th>
        <th>birth</th>
        <th>salary</th>
        <th>gender</th>
        <th>department</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${requestScope.employees}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.lastName}</td>
            <td>${e.email}</td>
            <td>${e.birth}</td>
            <td>${e.salary}</td>
            <td>${(e.gender==1)? "男":"女"}</td>
            <td>${e.department.departmentName}</td>
            <td>
            <a href="http://localhost:8080/SpringMVC_CRUD/edit/${e.id}">EDIT</a>
            </td>
            <td>
            <a href="http://localhost:8080/SpringMVC_CRUD/delete/${e.id}" class="del">DELETE</a>
            </td>
        </tr>
    </c:forEach>
    <form id="delSub" action="http://localhost:8080/SpringMVC_CRUD/delete/${e.id}" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>
    <script type="text/javascript">
        $(function (){
            $(".del").click(function () {
                //alert("hehe")
                //因为我们下面的表单的action不正确，所以引用this这个对象的
                $("#delSub").attr("action",this.href());
                //在这里提交
                $("#delSub").submit();
                return false;
            });
        });
    </script>
</table>
</body>
</html>
