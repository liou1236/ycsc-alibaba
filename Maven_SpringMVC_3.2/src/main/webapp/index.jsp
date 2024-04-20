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
SpringMVC核心类及注解（一）<p>
    <a href="hello.action">触发一</a><br>
    <a href="hello2.action">触发二</a><br>
    <a href="admin/hello3.action">触发三：采取扫描包的注解方式；返回ModelAndView对象！</a><br>
    <a href="admin/hello4.action">触发四：采取扫描包的注解方式；返回String视图路径；Model对象注入数据！</a><br>
    <a href="admin/hello5.action">触发五：采取扫描包的注解方式；返回String视图路径；request对象注入数据！</a><br>
    <a href="admin/hello6.action">触发六：采取扫描包的注解方式；request对象注入数据，页面跳转；返回void！</a><br>
<hr>
SpringMVC核心类及注解（二）<p>
    <a href="hello7.do">方法一：调用视图解析器，只适合return返回string视图路径解析。</a><br>
    <a href="hello8.do">方法二：redirect重定向：二次请求，地址栏改变，调转到全新页面，如删除时查看新列表</a><br>
    <a href="hello9.do">方法三：forward请求转发：一次请求，地址栏不变，可共享request域中数据，如查询时保留关键字。</a><br>
</body>
</html>
