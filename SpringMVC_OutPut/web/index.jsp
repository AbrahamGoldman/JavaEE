<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
<a href="outPut">outPutTest1</a><br>
  <a href="scopeTest1">scopeTest1</a><br>
  <a href="scopeTest2">scopeTest2</a><br>
  <a href="scopeTest3">scopeTest3</a><br>
  <a href="scopeTest4">ModelAndView</a><br>
  <a href="update">修改图书</a><br>

<form action="update" method="post">
  书名：${requestScope.bookName}<br>
  作者：<input name="author"/><br>
  价格：<input name="price"/><br>
  库存：<input name="stock"/><br>
  销量：<input name="sale"/><br>
  <input type="submit"><br>
</form>


<%--  view --%>

  <a href="hello" >hello</a>
  <a href="handler01" >handler01</a>
  <a href="handler02" >handler02 重定向</a>
  <a href="handler03" >handler03 重定向</a>
  <a href="toLogin">登陆</a>

  <a href="handlerview">测试我自己写的视图和视图解析器</a>
  </body>
</html>
