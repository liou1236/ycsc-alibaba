<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
Servlet调用方法：<br>
<a href="hello.action">方法一：连接法</a><br>
方法二：表单提交法
<form action="abc" method="post">
    姓名：<input type="text" name="user"><br>
    密码：<input type="password" name="pw"><br>
    <input type="submit" value="提交">
</form>
方法三：按钮触发
</body>
</html>
