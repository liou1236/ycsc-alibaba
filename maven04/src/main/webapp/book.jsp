<%@ page contentType="text/html;charset=utf-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<h3>图书信息列表</h3>

<table border="1" >
<tr>
    <td>编号</td>
    <td>书名</td>
    <td>价格</td>
    <td>作者</td>
    <td>图书编号</td>
</tr>
<%--    el表达式   使用request域中变量   用${key}--%>
    <c:forEach items="${books}" var="book" >
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.author}</td>
            <td>${book.no}</td>
            <td><a href="/maven03_war/del?id=${book.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
