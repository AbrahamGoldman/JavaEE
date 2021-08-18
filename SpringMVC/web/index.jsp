<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <a href="hello">hello world</a>
  <a href="handle">handle</a>
<%--测试服务器的method和params--%>
  <a href="haha/handle01">haha/handle01</a>

  <%--测试服务器的method和params--%>
  <form method="post" action="haha/handle02" >
    <input name="username" value="888">
    <input name="password" value="1">
    <input type="submit" > handle02
  </form>

  <a href="haha/handle03">haha/handle03</a>

  <a href="url/ant05">urlant模糊测试</a>
  <a href="url/dfd/dxsxs">pathVariable测试</a>

  </body>
</html>
