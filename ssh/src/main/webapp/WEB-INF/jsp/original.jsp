<%--
  Created by IntelliJ IDEA.
  User: ljh
  Date: 2022/4/2
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Original</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
<h1>Original</h1>
<div>
    <c:forEach items="${map}" var="m">
        <div>${m.key} ---> ${m.value}</div>
    </c:forEach>
</div>
<div>
    <img src="/img/bird.jpg" alt="bird">
</div>
<script>
    $(function () {
        alert(1);
    });
</script>
</body>
</html>