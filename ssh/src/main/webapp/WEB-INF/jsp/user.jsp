<%--
  Created by IntelliJ IDEA.
  User: ljh
  Date: 2022/4/4
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User Add</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
<section>
    <form action="/user/addByFrom" method="post">
        <label for="userName">姓名：</label>
        <input id="userName" type="text" name="userName">
        <br/>
        <label for="age">年龄：</label>
        <input id="age" type="text" name="age">
        <br/>
        <input type="button" value="add" onclick="addByFrom()">
    </form>
    <script>
        function addByFrom () {
            let form = document.forms[0];
            form.submit();
        }
    </script>
</section>

<section>
    <label for="userName2">姓名：</label>
    <input id="userName2" type="text" name="userName">
    <br/>
    <label for="age2">年龄：</label>
    <input id="age2" type="text" name="age">
    <br/>
    <input id="add2" type="button" value="add">
    <script>
        $(function () {
            $("#add2").click(function () {
                let userName = $("#userName2").val();
                let age = $("#age2").val();
                let user = {userName: userName, age: age};
                $.ajax({
                    url: "/user/addByJson",
                    type: "post",
                    data: user,
                    success: function (data) {
                        alert("userName:" + data.userName + ", age:" + data.age);
                    }
                })
            });
        });
    </script>
</section>
</body>
</html>