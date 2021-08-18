
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>嘻嘻，你好呀</title>
    <%
      pageContext.setAttribute("cpp",request.getContextPath());
    %>
    <script type="text/javascript" src="script/jquery-1.7.2.js"></script>
  </head>
  <body>
<a href="goodNight">Good Night~</a><br/>
  <a href="listAll">列出所有员工</a><br/>
  <a href="toAdd">添加员工</a><br/>

<%--  下面是测试我们自定义的类型转化器--%>
<%--  <form action="emploinfo" method="post">--%>
<%--    <input name="emp" value="zhangfei-dfd@qq.com-1-102">--%>
<%--    <input type="submit" value="提交">--%>
<%--  </form>--%>

<%--测试@RequestBody 这个注解的作用,要有请求体的话，必须用post发请求。提交文件也是可以的--%>
  <form action="testBody" method="post" enctype="multipart/form-data">
    <input name="username"/>
    <input name="password"/>
<%-- 还可以提交文件 --%>
    <input type="file" name="file" />
    <input type="submit" value="提交"/>
  </form>
<%--测试@RequestBody 这个注解的作用,要有请求体的话，必须用post发请求。提交文件也是可以的--%>
  <form action="testBody2" method="post" >haha1
    <input name="username"/>
    <input name="password"/>
    <input type="submit" value="提交"/>
  </form>

<br/>
测试HttpEntity
  <form action="haha1" method="post" >
    <input name="username"/>
    <input name="password"/>
    <input type="submit" value="提交"/>
  </form>

<br/>
测试文件上传给服务器，最大上传100Mb<br/>
  <form action="${cpp}/uploadMultip" method="post" enctype="multipart/form-data"><br/>
   待上传的文件： <input type="file" name="filename"/><br/>
   待上传的文件： <input type="file" name="filename"/><br/>
   待上传的文件： <input type="file" name="filename"/><br/>
    用户名：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="submit" value="提交"/><br/>
  </form>

<br/>

测试不同文件名的文件上传给服务器，最大上传100Mb<br/>
  <form action="${cpp}/uploadMultip2" method="post" enctype="multipart/form-data"><br/>
   待上传的文件： <input type="file" name="filename1"/><br/>
   待上传的文件： <input type="file" name="filename2"/><br/>
   待上传的文件： <input type="file" name="filename3"/><br/>
    用户名：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="submit" value="提交"/><br/>
  </form>

<br/>

<br/>
<a href="${cpp}/test01" >test01</a>
<br/>

<br/>
<a href="${cpp}/toLogin" >tologin</a>
<br/>
<br/>

<a href="${cpp}/handler01?i=10">测试异常类</a>

<br/>
<a href="${cpp}/handler02?name=haerbin">测试自定义异常类</a>

<br/>


<a id="xixi" href="testBody3">使用Ajax发送JSON数据</a>
  <script type="text/javascript">
    $("#xixi").click(function () {
      //下面就是JSON形式的對象
      var emp={
        lastName:"卢布dfdfdfdf",
        email:"125656566@qq.com",
        gender:1
      }
     // alert(emp) //Objest对象
      //卧槽，必须加下面这一行，把JSON对象转成字符串 如果不加就报错，就无法转成Employee对象，丢勒
      var empinfo=JSON.stringify(emp)
     alert(empinfo) //{"lastName":"卢布dfdfdfdf","email":"125656566@qq.com","gender":1}
      $.ajax({
        url:"${cpp}/testBody3",
        type:"post",
        data:empinfo,
        contentType:"application/json",
        // success:function (data) {
        //   alert(data)
        // }
      });
      return false;
    });
  </script>








  </body>
</html>
