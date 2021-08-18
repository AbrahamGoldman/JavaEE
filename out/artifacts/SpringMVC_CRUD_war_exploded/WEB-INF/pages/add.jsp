<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 2021/7/19
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<%--普通的form表单，操作起来麻烦，而且不方便，为了更方便的操作，我们引入SpringMVC表单
通过SpringMVC的表单标签可以实现将模型数据中的属性和页面表单元素相绑定，以实现表单数据更加便捷的编辑和表单值得回显

用了表单标签，可能会报没有command对象这个错误，需要先在request域中放入回显对象:
Neither BindingResult nor plain target object for bean name 'command' available as request attribute

springmvc认为表单数据中的每一项都要回显，path指定的是属性，这个属性为隐藏模型中对象的属性，所以请求域中一定要有一个对象，这个对象拥有这些属性

还可以使用modelAttribute="employee" ,把这个对象中的每一个属性对应的显示出来，相当于是command的别名
那我们存到隐藏域中也得是employee

<% 添加下面这一行是加入绝对路径 action="${cpt}/startAdd"
pageContext.setAttribute("cpt",request.getContextPath());
%>
commandName="command"
--%>
<f:form action="startAdd" modelAttribute="employee"  method="post">
<%--path: 表示对象属性
作用有两个：①如果隐含模型中有某个对象对应得这个属性值，会自动回显。②充当原来的name项
--%>
    lastName： <f:input path="lastName"/><f:errors path="lastName"/>++ ${requestScope.errorInfo.lastName}<br>
    email:    <f:input path="email"/><f:errors path="email"/>++${requestScope.errorInfo.email}<br>
    brith:   <f:input path="birth"/><f:errors path="birth"/>++${requestScope.errorInfo.birth}<br/>
    salary:  <f:input path="salary"/>
    gender:   男：<f:radiobutton path="gender" value="1"/>
              女：<f:radiobutton path="gender" value="0"/><br>
    dept:
<%--
items: 需要遍历的集合
itemLabel:指定某个属性为下拉列表里面的值
itemValue:指定哪个属性作为要提交的值
--%>
    <f:select path="department.id" items="${requestScope.departments}"
              itemLabel="departmentName" itemValue="id"></f:select>
    <input type="submit" value="提交"/>
</f:form>


<%--<form action="startAdd" method="post">--%>

<%--lastName: <input type="text" name="lastName" /><br/>--%>
<%--email:<input type="text" name="email" /><br/>--%>
<%--gender:<br/>--%>
<%--男：<input type="radio" name="gender" value="1"/>--%>
<%--女：<input type="radio" name="gender" value="0"/>--%>
<%--    <br/>--%>
<%--department:--%>
<%--<select name="department.id">--%>
<%--  <c:forEach items="${requestScope.departments}" var="dep"  >--%>
<%--&lt;%&ndash;他下面写的是value="${dep.id}" &ndash;%&gt;--%>
<%--      <option value="${dep.id}" >${dep.departmentName}</option>--%>
<%--  </c:forEach>--%>
<%--</select>--%>
<%--    <br/>--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
</body>
</html>
