<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 2021/7/22
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        //设置路径，相当于以前用的base标签设置路径
        pageContext.setAttribute("cpp", request.getContextPath());
    %>
    <title>AjaxTest</title>

    <script type="text/javascript" src="script/jquery-1.7.2.js"></script>

</head>
<body>
<%--加个时间主要是用来判断这个页面有没有刷新过--%>
<%= new Date()%>
<a id="ajax" href="${cpp}/ajaxGet">ajax请求</a>
<div>

</div>
<script type="text/javascript">
    $("#ajax").click(function () {
        $.ajax({
            url: "${cpp}/ajaxGet",
            type: "GET",
            success: function (data) {
                //console.log(data)
                $.each(data, function () {
                    var emplInfo = this.lastName + "~" + this.birth + "~" + this.gender;
                    $("div").append(emplInfo+"<br/>");
                });
            }
        });
        return false;
    });

</script>

</body>
</html>
