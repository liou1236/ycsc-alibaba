<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/2/22
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello Maven !<p>
    <a href="hello.action">触发一</a><br>
    <a href="hello2.action">触发二</a><br>
    <a href="admin/hello3.action">触发三：采取扫描包的注解方式；返回ModelAndView对象！</a><br>
    <a href="admin/hello4.action">触发四：采取扫描包的注解方式；返回String视图路径；Model对象注入数据！</a><br>
    <a href="admin/hello5.action">触发五：采取扫描包的注解方式；返回String视图路径；request对象注入数据！</a><br>
    <a href="admin/hello6.action">触发六：采取扫描包的注解方式；request对象注入数据，页面跳转；返回void！</a><br>
</body>
</html>
