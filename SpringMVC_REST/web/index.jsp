<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--
发起图书的增删改查请求，使用REST风格的URL地址
请求URL     请求方式     表示含义
/book/1     GET        查询1号图书
/book/1     DELETE     删除1号图书
/book/1     PUT        更新1号图书
/book       POST       新增1号图书

我们现在的问题就是怎么让服务器能够识别DELETE 和 PUT请求，而SpirngMVC提供了对REST风格的支持
1.SpringMVC中有一个Filter，能够把普通的请求转成指定的请求，我们需要配置这个Filter
2.配置好了过滤器以后，如果我们想发其他形式的请求，要按照如下步骤来做：
  ①创建一个post请求的表单
  ②表单中携带一个_method的参数，它的值就是DELETE | PUT

--%>
<%--  <a href="book/1">查询图书</a><br/>--%>


<%--<form action="book/1" method="post">--%>
<%--  <input  name="_method" value="delete">--%>
<%--  <input type="submit" value="删除delete">--%>
<%--</form><br/>--%>
<%--<form action="book/1" method="post">--%>
<%--  <input  name="_method" value="put">--%>
<%--  <input type="submit" value="更新put">--%>
<%--</form><br/>--%>

<%--<form action="book" method="post">--%>
<%--  <input type="submit" value="新增图书">--%>
<%--</form>--%>

<%--  <a href="getParam?username=Smith" >诸葛侯</a>--%>

<%--  <a href="getparam2?user=haha" >哈哈getparam2</a>--%>

<%--javaBean创建好了以后，我们这里就开始输入对象了,Book对象，和Address对象，级联赋值--%>
  <form action="addBook" method="post">
    书名：<input name="bookName" value=""/> <br>
    作者：<input name="author" value=""/> <br>
    价格：<input name="price" value=""/> <br>
    库存：<input name="stock" value=""/> <br>
    销量：<input name="sale" value=""/> <br>
    地址信息:<br>
    省：<input name="address.provice" value=""/><br>
    市：<input name="address.city" value=""/><br>
    街道：<input name="address.street" value=""/><br>
    <input type="submit">

  </form>

<a href="handler01" >
  handler01
</a>

  </body>
</html>
